package HA_05;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ClientApplication {

    private Stage primayStage;
    private Scene scene;
    //private Client client;
    private TransportListener transportListener;
    private Button requestButton;
    private VBox clientBox;
    private TextField userNameField;
    private TextField startField;
    private TextField destinationField;
    private TextField transportTime;
    private TextField whenField;

    public ListView getStatusView() {
        return statusView;
    }

    private ListView statusView;

    public ClientApplication() {
        transportListener = new TransportListener();
    }

    public ClientApplication(Client customer) {
        //this.client = customer;

    }

    public void show(Stage primayStage) {
        this.primayStage = primayStage;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("ClientScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.scene = new Scene(root);
        this.userNameField = (TextField) scene.lookup("#userNameField");
        this.startField = (TextField) scene.lookup("#startField");
        this.destinationField = (TextField) scene.lookup("#destinationField");
        this.transportTime = (TextField) scene.lookup("#transportTimeField");
        this.whenField = (TextField) scene.lookup("#whenn");
        this.requestButton = (Button) scene.lookup("#requestButton");
        this.clientBox = (VBox) scene.lookup("#clientBox");
        this.statusView = (ListView) scene.lookup("#listViewClient");

        transportListener.setName(userNameField.getText());
        transportListener.setStartLocation(startField.getText());
        transportListener.setDestination(destinationField.getText());
        transportListener.setTime(transportTime.getText());
        transportListener.setWhen(whenField.getText());

        this.requestButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Client client = new Client("ToTransport",  ClientApplication.this);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("CustomerName", userNameField.getText());
                jsonObject.put("Start ", startField.getText());
                jsonObject.put("destination ", destinationField.getText());
                jsonObject.put("AbholungZeit", transportTime.getText());
                jsonObject.put("wann", whenField.getText());
                System.out.println("DATA WAS SENT TO THE TRANSPORTATION SERVICES " + jsonObject.toString());
                statusView.getItems().add("Send " + jsonObject.toString());
                statusView.refresh();
                System.out.println("TOPIC: "+ client.getTopic());
                client.sendRequest(jsonObject);
            }
        });
        this.primayStage.setScene(this.scene);
        this.primayStage.show();
    }
    public void arrivedRequestForTransport(JSONObject object) {
        System.out.println("message Arrived in Transport Service");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(object.toString());
                    String transportType = null;
                    String customerName = object.getString("CustomerName");
                    String start = object.getString("Start ");
                    String destination = object.getString("destination ");
                    String transportTime = object.getString("AbholungZeit");
                    String date = object.getString("wann");
                    transportType = "customerName: " + customerName + " start: " + start+ "destination: " + destination + " UhrZeit: " + transportTime + "Wann:? "+date;
                    System.out.println(transportType);
                    statusView.getItems().add(transportType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
