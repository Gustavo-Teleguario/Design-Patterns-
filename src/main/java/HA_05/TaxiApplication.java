package HA_05;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class TaxiApplication {

    private Client client;
    private Stage primaryStage;
    private Scene scene;
    private TextField preiceField;
    private ListView statusView;
    private Button sendPreice;
    private Button accept;
    private TransportListener transportListener;
    private ClientApplication clientApplication;

    public TaxiApplication() {
        transportListener = new TransportListener();
    }

    public TaxiApplication(Client client) {
        this.client = client;
    }

    public void show(Stage primaryStage) {
        this.primaryStage = primaryStage;
        clientApplication = new ClientApplication();
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("TaxiScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.scene = new Scene(root);
        this.preiceField = (TextField) scene.lookup("#preiceField");
        this.statusView = (ListView) scene.lookup("#listViewClient");
        this.sendPreice = (Button) scene.lookup("#sendPreice");
        this.accept = (Button) scene.lookup("#accept");
        transportListener.setPreice(preiceField.getText());

        transportListener.setType("Abholung");
        transportListener.setPreice(preiceField.getText());

        this.sendPreice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Client client = new Client("ToCarla",TaxiApplication.this);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Preice ", preiceField.getText());
                System.out.println("DATA WAS SENT TO CUSTOMER " + transportListener.toString());
                statusView.getItems().add("Send " + jsonObject.toString());
                statusView.refresh();
                client.sendRequest(jsonObject);
            }
        });
        this.accept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Client client = new Client("toTransport",TaxiApplication.this);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("confirmation ", "Accepted");
                jsonObject.put("pay", "payIsAccepted");
                transportListener.setConfirmation(true);
                System.out.println("DATA WAS SENT TO TRANSPORT " + transportListener.getConfirmation());
                statusView.getItems().add("Send " + jsonObject.toString());
                statusView.refresh();
                System.out.println("TOPIC: "+ client.getTopic());
                client.sendRequest(jsonObject);
            }
        });
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public void arrivedRequestForCustomer(JSONObject object) {
        System.out.println("message Arrived at Customer");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(object.toString());
                    String transportType = null;
                    String price = object.getString("Preice ");
                    String confirmation = "Accepted";
                    transportType = "Preice: " + price + " confirmation: " + confirmation;
                    System.out.println(transportType);
                    statusView.getItems().add(transportType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
