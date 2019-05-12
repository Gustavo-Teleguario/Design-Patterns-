package HA_04;

import HA_04.Listener;
import HA_04.Node;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 04
 * University of Kassel
 */

public class ChangeSerialisationTest {


    @Test
    public void changeSerializationTest() {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

        Listener listener = new Listener();

        Node fulibProjekt = new Node(listener).setDescription("Projekt");
        listener.subscribe(fulibProjekt);

        Node WT1819 = new Node(listener).setDescription("Release");
        Node SS19 = new Node(listener).setDescription("Release");

        /**
         * Pro Sprint 2 oder 3 Features
         */

        Node sprint1 = new Node(listener).setDescription("SprintWS1");
        Node sprint2 = new Node(listener).setDescription("SprintWS2");
        Node sprint3 = new Node(listener).setDescription("SprintWS3");


        Node sprintS1 = new Node(listener).setDescription("SprintSS1");
        Node sprintS2 = new Node(listener).setDescription("SprintSS2");
        Node sprintS3 = new Node(listener).setDescription("SprintSS3");

        /**
         * Pro Feature 8 Story Points
         */
        Node f1 = new Node(listener).setStoryPoints(8).setDescription("Feature");
        Node f2 = new Node(listener).setStoryPoints(8).setDescription("Feature");
        Node fS1 = new Node(listener).setStoryPoints(8).setDescription("FeatureSS1");
        Node fS2 = new Node(listener).setStoryPoints(8).setDescription("FeatureSS2");

        fulibProjekt.setNodeChild(WT1819);
        fulibProjekt.setNodeChild(SS19);

        WT1819.setNodeChild(sprint1).setNodeChild(sprint2).setNodeChild(sprint3);
        SS19.setNodeChild(sprintS1).setNodeChild(sprintS2).setNodeChild(sprintS3);

        sprint1.setNodeChild(f1).setNodeChild(f2);
        sprint2.setNodeChild(f1).setNodeChild(f2);
        sprint2.setNodeChild(f1).setNodeChild(f2);

        sprintS1.setNodeChild(fS1).setNodeChild(fS2);
        sprintS2.setNodeChild(fS1).setNodeChild(fS2);
        sprintS2.setNodeChild(fS1).setNodeChild(fS2);

        assertEquals(13, listener.listObject.size());
        /**
         * Close file
         */
        try {

            listener.bufferedWriter.flush();
            listener.bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");
    }
}
