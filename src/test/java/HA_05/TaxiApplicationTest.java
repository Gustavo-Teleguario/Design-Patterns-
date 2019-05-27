package HA_05;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 05
 * University of Kassel
 */
// HA05: 07/10
    // -3 Das ist kein richtiges Test
public class TaxiApplicationTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TaxiApplication taxiApplication = new TaxiApplication();
        taxiApplication.show(primaryStage);
    }

    @Test
    public void testCustomer() throws IOException {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

        TextField preice = (TextField) lookup("#preiceField").query();
        ListView listView = (ListView)lookup("#listViewClient") .query();
        Button sendPreice = (Button) lookup("#sendPreice").query();
        Button acceptPreice = (Button)lookup("#accept").query();

        clickOn(preice).write("12-Euro");
        clickOn(sendPreice).clickOn(MouseButton.PRIMARY);
        clickOn(acceptPreice).clickOn(MouseButton.PRIMARY);

        assertEquals("12-Euro", preice.getText());
        String contentListView = listView.toString();
        Assert.assertTrue(!contentListView.isEmpty());
        System.out.println(listView.getItems().get(0).toString());


        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

    }
}
