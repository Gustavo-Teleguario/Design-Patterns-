package HA_06;

import HA_06.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    Controller controller = new Controller();
    controller.start(primaryStage);
    }
}
