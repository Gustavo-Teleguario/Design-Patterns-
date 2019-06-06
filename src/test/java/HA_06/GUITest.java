package HA_06;

import HA_06.controller.Controller;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 06
 * University of Kassel
 */

public class GUITest extends ApplicationTest {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    public void commandPatternTest() {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");

        //GUI Testing
        ArrayList<String> commands = new ArrayList<>();
        TextField commandField = controller.getCommandField();
        commands.add("line l1 100 100 200 200");
        commands.add("line l2 100 100 200 100");
        commands.add("line l3 200 100 150 30");
        commands.add("line l4 100 100 150 30");
        commands.add("line l5 100 100 100 200");
        commands.add("line l6 200 100 100 200");
        commands.add("line l7 200 100 200 200");
        commands.add("line l8 100 200 200 200");

        //Nikolaus Haus gruppe von linien
        commands.add("group g1 l1 l2 l3 l4 l5 l6 l7 l8");
        commands.add("group g2 l1 l2 l3 l4 l5 l6 l7 l8");
        commands.add("clone g1 g2 60 100");
        commands.add("clone g1 60 0");
        commands.add("undo");
        commands.add("redo");

        for (String el : commands) {
            clickOn(commandField).write(el);
            clickOn(commandField).push(KeyCode.ENTER);
        }

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");
    }
}
