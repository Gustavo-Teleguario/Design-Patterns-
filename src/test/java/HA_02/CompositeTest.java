package HA_02;

import HA_02.*;
import org.junit.Test;
/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 02
 * University of Kassel
 */

// HA02: 02/10
    // -2 Kein Test es fehlen Assertions. Naechtes mal mehr Punkte abzug
    // -3 Siehe (*1)
    // -3 Kein gitignore

public class CompositeTest {
    @Test
    public void compositeTest() {

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");
        /**
         * Test Composite Pattern
         */
        System.out.println("**************** Hausaufgabe2 Teil (b)*******************\n");
        //Feature Objects
        int numberOfStoryPoints = 8;
        Feature f1 = new Feature("Feature1");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f1.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature1")));
        }
        Feature f2 = new Feature("Feature2");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f2.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature2")));
        }
        Feature f3 = new Feature("Feature3");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f3.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature3")));
        }
        Feature f4 = new Feature("Feature4");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f4.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature4")));
        }
        Feature f5 = new Feature("Feature5");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f5.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature5")));
        }
        Feature f6 = new Feature("Feature6");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f6.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature6")));
        }
        Feature f7 = new Feature("Feature7");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f7.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature7")));
        }
        Feature f8 = new Feature("Feature8");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f8.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature8")));
        }
        Feature f9 = new Feature("Feature9");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f9.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature9")));
        }
        Feature f10 = new Feature("Feature10");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f10.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature10")));
        }
        Feature f11 = new Feature("Feature11");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f11.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature11")));
        }
        Feature f12 = new Feature("Feature12");
        for(int i = 0; i < numberOfStoryPoints; i++){
            f12.withChildNode(new StoryPoint((String)("StoryPoint "+ i +"--Fuer Feature12")));
        }

        //Add all feature into a Tree
        FulibProject fulib = new FulibProject();
        fulib.withChildNode(new Release("WS1819")
                        .withChildNode(new Sprint("Sprint1").withChildNode(f1, f2),
                                new Sprint("Sprint2").withChildNode(f3, f4),
                                new Sprint("Sprint3").withChildNode(f5, f6)),
                            new Release("SS19")
                        .withChildNode(new Sprint("Sprint4").withChildNode(f7, f8),
                                new Sprint("Sprint5").withChildNode(f9, f10),
                                new Sprint("Sprint6").withChildNode(f11, f12)));


        System.out.println("**************** Hausaufgabe2 Teil (c)********************\n");
        System.out.println("\t\tSum all StoryPoints: " + fulib.sumStoryPoints());
        System.out.println("**********************************************************\n\n");

        System.out.println("****************** Hausaufgabe2 Teil (d)**********************");
        fulib.withChildNode(new Epic("Epic1").withChildNode(new Release("ReleaseForEpic2019")
                        .withChildNode(new Sprint("SprintInEpic1").withChildNode(f1, f2),
                                new Sprint("SprintInEpic2").withChildNode(f3, f4),
                                new Sprint("SprintInEpic3").withChildNode(f5, f6))));

        System.out.println("*********************************************************\n");
        System.out.println("\t\tSum all StoryPoints: " + fulib.sumStoryPoints());
        System.out.println("**********************************************************\n\n");


        System.out.println("********************* Hausaufgabe2 Teil (e)*********************\n\n");
        f1.withChildNode(new Task("Task1"), new Task("Task2"),
                new Task("Task3"), new Task("Task4"));
        f2.withChildNode(new Task("Task5"), new Task("Task6"),
                new Task("Task7"), new Task("Task8"));
        f3.withChildNode(new Task("Task9"), new Task("Task10"),
                new Task("Task11"), new Task("Task12"));
        f4.withChildNode(new Task("Task13"), new Task("Task14"),
                new Task("Task15"), new Task("Task16"));
        f5.withChildNode(new Task("Task17"), new Task("Task18"),
                new Task("Task19"), new Task("Task20"));
        f6.withChildNode(new Task("Task21"), new Task("Task22"),
                new Task("Task23"), new Task("Task24"));

        System.out.println("*********************************************************\n");
        System.out.println("\t\tSum all StoryPoints: " + fulib.sumStoryPoints());
        System.out.println("**********************************************************\n\n");

        System.out.println("********************* Hausaufgabe2 Teil (f)*********************\n\n");

        fulib.withChildNode(new Epic("Epic1").withChildNode(
                        new Release("WS1819"),
                        new Release("SS19"),
                        new Docu("IamADocu")));

        System.out.println("*********************************************************\n");
        System.out.println("\t\tSum all StoryPoints: " + fulib.sumStoryPoints());
        System.out.println("**********************************************************\n\n");

        /**
         * Test mit Visitor Pattern.
         */

        System.out.println("************* Hausaufgabe2 VISITOR PATTERN *****************\n");
        System.out.println("Task Counter(CT) with Visitor Pattern "+fulib.accept(new CT()));
        System.out.println("Story Point Counter(SPC) with Visitor Pattern "+fulib.accept(new SPC())+"\n");

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");
    }
}
