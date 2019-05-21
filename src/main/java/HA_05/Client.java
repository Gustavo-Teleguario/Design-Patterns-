package HA_05;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class Client {

    public static String MQTT_BROKER = "tcp//localhost:1883";


    private MqttClient mqtt;
    private Client client;
    private TaxiApplication taxiApplication;

    private String location;
    private String userName;


    //Gui Controller
    private ClientApplication clientApplication;



    private Target target;

    //Target es el Ziel


    public Client(){
        location = "";
        mqtt = null;
    }
    public Client(String name){
        this.userName = name;
    }
    public Client(TaxiApplication taxiapplication){
        this.taxiApplication = taxiapplication;
    }

    public void newCustomer(Client client) throws MqttException{
        this.client = client;
        mqtt = new MqttClient(MQTT_BROKER, MqttClient.generateClientId());
        mqtt.connect();

        if(mqtt.isConnected()){
            //Customer message
            JSONObject message = new JSONObject();
            message.put("Name", client.getUserName());
            message.put("Location", client.getTarget().getLocation());
            MqttMessage mqttMessage = new MqttMessage(message.toString().getBytes());
            mqtt.publish("TAXI",mqttMessage);
        }
        mqtt.disconnect();
    }
    public String getUserName(){
        return this.userName;
    }

    public String getLocation() {
        return location;
    }
    public Target getTarget() {
        return target;
    }
    public ClientApplication getClientApplication() {
        return clientApplication;
    }

    public void setClientApplication(ClientApplication clientApplication) {
        this.clientApplication = clientApplication;
    }
}
