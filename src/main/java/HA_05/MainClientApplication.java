package HA_05;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainClientApplication extends Application {
    public static void main(String...args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientApplication clientApplication = new ClientApplication();
        clientApplication.show(primaryStage);
    }
}
