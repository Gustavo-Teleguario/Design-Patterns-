package HA_05;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javax.xml.soap.Text;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ClientApplicationTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientApplication clientApplication = new ClientApplication();
        clientApplication.show(primaryStage);
    }

    @Test
    public void testCustomer() throws IOException {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

        TextField name = (TextField) lookup("#userNameField").query();
        TextField start = (TextField) lookup("#startField").query();
        TextField destination = (TextField) lookup("#destinationField").query();
        TextField transportTime = (TextField) lookup("#transportTimeField").query();
        TextField when = (TextField) lookup("#whenn").query();
        Button requestButton = (Button) lookup("#requestButton").query();

        clickOn(name).write("Carla");
        clickOn(start).write("Wilhemshoehe Alle 73 Kassel");
        clickOn(destination).write("DEZ Kassel");
        clickOn(transportTime).write("12:00");
        clickOn(when).write("Today");
        clickOn(requestButton).clickOn(MouseButton.PRIMARY);

        assertEquals("Carla", name.getText());
        assertEquals("Wilhemshoehe Alle 73 Kassel", start.getText());
        assertEquals("DEZ Kassel", destination.getText());
        assertEquals("12:00", transportTime.getText());
        assertEquals("Today", when.getText());

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

    }
}
