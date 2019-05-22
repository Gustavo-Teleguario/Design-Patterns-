package HA_05;


import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

public class Client implements MqttCallback {

    public static String MQTT_BROKER = "tcp://localhost:1883";

    private String topic = "";
    private MqttClient client;
    private ClientApplication clientApplication;
    private TaxiApplication taxiApplication;

    public Client(String channel, ClientApplication clientApplication) {

        this.clientApplication = clientApplication;
        this.topic = channel;

        try {
            this.client = new MqttClient(Client.MQTT_BROKER, MqttClient.generateClientId());
            client.setCallback(this);
            client.connect();
            System.out.println("CONECCTION SUCCESFULL \n");
            client.subscribe(topic);


        }catch (MqttException e){
            e.printStackTrace();
        }
    }

    public void sendRequest(String listener){
        MqttMessage message = new MqttMessage();
        message.setPayload(listener.getBytes());
        try{
            if(client.isConnected()== false){
                client.connect();
            }
            client.publish(topic, message);
            System.out.println("MESSAGE PUBLISHED ON CHANNEL: "+topic);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }
    @Override
    public void connectionLost(Throwable cause) {

    }
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("MESSAGE SUCCESSFULL ARRIVED\n");
        JSONObject transport = new JSONObject(message.toString());
        String type = transport.getString("type");
        if(type.equals("request")){
            taxiApplication.receiveRequestforTransport(transport);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

}