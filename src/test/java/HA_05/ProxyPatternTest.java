package HA_05;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ProxyPatternTest {


    @Test
    public void fileTest(){
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

        File clientScreenFXML = new File("src\\main\\resources\\HA_05\\ClientScreen.fxml");
        Assert.assertTrue(clientScreenFXML.exists());
        File taxiScrennFXML = new File("src\\main\\resources\\HA_05\\TaxiScreen.fxml");
        Assert.assertTrue(taxiScrennFXML.exists());
    }
    @Test
    public void mqttClientTest(){
        Client client = new Client("toTransport",new TaxiApplication());
        TransportListener transportListener = new TransportListener("toCarla", "Thea", "12 Euro");

        try{
            MqttClient clientMqtt = new MqttClient(Client.MQTT_BROKER,MqttClient.generateClientId());
            String topic = client.getTopic();
            clientMqtt.setCallback(client);
            clientMqtt.connect();
            clientMqtt.subscribe("toTransport");
            Assert.assertTrue(clientMqtt.isConnected());
            JSONObject testObject = new JSONObject();
            testObject.put("receiver", transportListener.getType());
            testObject.put("taxiFahrer", transportListener.getName());
            testObject.put("preice", transportListener.getPreice());

            assertEquals("toTransport", topic);
            client.sendRequest(testObject);

        }catch (MqttException e){
            e.printStackTrace();
        }
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");
    }
}
