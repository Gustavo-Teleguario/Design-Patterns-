package HA_05;

import javafx.application.Platform;
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
    private Button acceptButton;
    private TransportListener transportListener;

    public TaxiApplication() {
        transportListener = new TransportListener();
    }

    public TaxiApplication(Client client) {
        this.client = client;

    }

    public void show(Stage primaryStage){
        this.primaryStage = primaryStage;
        AnchorPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("TaxiScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.scene = new Scene(root);
        this.preiceField = (TextField) scene.lookup("#preiceField");
        this.statusView = (ListView) scene.lookup("#listViewClient");
        this.acceptButton = (Button) scene.lookup("#accept");
        transportListener.setPreice(preiceField.getText());


        this.acceptButton.setOnAction(e -> this.client.sendRequest(transportListener.toString()));
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }


    @FXML
    public void receiveRequestforTransport(JSONObject object) {
        System.out.println("message Arrived");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    String transportType = null;
                    String name = object.getString("name");
                    String price = object.getString("price");
                    String time = object.getString("time");
                    transportType = "Name: " + name + " Preis: " + price + " UhrZeit: " + time;
                    System.out.println(transportType);
                    statusView.getItems().add(transportType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
