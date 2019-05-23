package HA_05;


import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

public class Client implements MqttCallback {

    public static String MQTT_BROKER = "tcp://iot.eclipse.org:1883";

    private String topic = "";
    private MqttClient client;
    private ClientApplication clientApplication;
    private TaxiApplication taxiApplication;
    private TransportListener transportListener;

    public Client() {
        transportListener = new TransportListener();
    }

    public Client(String channel, ClientApplication clientApplication) {
        this.topic = channel;
        this.clientApplication = clientApplication;
        try {
            this.client = new MqttClient(Client.MQTT_BROKER, MqttClient.generateClientId());
            client.setCallback(this);
            client.connect();
            System.out.println("CONECCTION SUCCESFULL \n");
            client.subscribe(channel);

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    public Client(String channel, TaxiApplication taxiApplication) {
        this.taxiApplication = taxiApplication;
        this.topic = channel;
        try {
            this.client = new MqttClient(Client.MQTT_BROKER, MqttClient.generateClientId());
            client.setCallback(this);
            client.connect();
            System.out.println("CONECCTION SUCCESFULL \n");
            client.subscribe(channel);

        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    public void sendRequest(JSONObject listener) {
        MqttMessage message = new MqttMessage();
        message.setPayload(listener.toString().getBytes());
        try {
            if (client.isConnected() == false) {
                client.connect();
            }
            client.publish(topic, message);
            System.out.println("TOPIC: " + topic + " MESSAGE PUBLISHED ON CHANNEL: " + message);
        } catch (MqttException e) {
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
        System.out.println(topic);
        clientApplication.arrivedRequestForTransport(transport);
        if(topic.equals("toCarla") == true)
        taxiApplication.arrivedRequestForCustomer(transport);
        client.disconnect();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    public String getTopic() {
        return topic;
    }

    public TransportListener getTransportListener() {
        return transportListener;
    }
}
