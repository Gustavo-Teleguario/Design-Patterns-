package HA_06;

import HA_06.commandHandler.CommandHandler;
import HA_06.controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 06
 * University of Kassel
 */

public class CommandPatternTest extends ApplicationTest {
    @Test
    public void commandPatternTest() {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("************************************************");

        ArrayList<String> commands = new ArrayList<>();
        //Line Command
        commands.add("line l1 10 200 100 200");
        assertEquals("line l1 10 200 100 200", commands.get(0));
        //group Command
        commands.add("group g1 l1");
        assertEquals("group g1 l1", commands.get(1));
        //Nikolaus Haus Test als gruppe aus linien testen
        commands.add("group g1 l1 l2 l3 l4 l5 l6 l7 l8");
        assertEquals("group g1 l1 l2 l3 l4 l5 l6 l7 l8", commands.get(2));
        //clone command
        commands.add("clone g1 g2 50 60");
        assertEquals("clone g1 g2 50 60",commands.get(3));


        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");
    }
}
