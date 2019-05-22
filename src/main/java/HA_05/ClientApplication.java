package HA_05;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientApplication {

    private Stage primayStage;
    private Scene scene;

    private Client client;
    private TransportListener transportListener;
    private Button requestButton;
    private VBox clientBox;
    private TextField userNameField;
    private TextField startField;
    private TextField destinationField;
    private TextField transportTime;

    private Parent root;


    public ClientApplication() {
        transportListener = new TransportListener();
    }

    public ClientApplication(Client customer) {
        this.client = customer;

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
        this.requestButton = (Button) scene.lookup("#requestButton");
        this.clientBox = (VBox) scene.lookup("#clientBox");

        transportListener.setName(userNameField.getText());
        transportListener.setStartLocation(startField.getText());
        transportListener.setDestination(destinationField.getText());
        transportListener.setTime(transportTime.getText());

        this.requestButton.setOnAction(e -> this.client.sendRequest(transportListener.toString()));
        //Aca biene lo de Channel o Mqtt
        this.primayStage.setScene(this.scene);
        this.primayStage.show();
    }


}
