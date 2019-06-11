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
// HA06: 08/10
// -2 java.util.NoSuchElementException
//	at java.util.Optional.orElseThrow(Optional.java:290)
//	at org.testfx.service.finder.impl.WindowFinderImpl.window(WindowFinderImpl.java:70)
//	at org.testfx.robot.impl.WriteRobotImpl.fetchTargetWindow(WriteRobotImpl.java:86)
//	at org.testfx.robot.impl.WriteRobotImpl.write(WriteRobotImpl.java:78)
//	at org.testfx.robot.impl.WriteRobotImpl.write(WriteRobotImpl.java:73)
//	at org.testfx.api.FxRobot.write(FxRobot.java:506)
//	at org.testfx.api.FxRobot.write(FxRobot.java:60)
//	at HA_06.GUITest.commandPatternTest(GUITest.java:61)
//	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//	at java.lang.reflect.Method.invoke(Method.java:498)
//	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
//	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
//	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
//	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
//	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
//	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
//	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
//	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
//	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
//	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
//	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
//	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
//	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
//	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
//	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
//	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
//	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
//	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
//	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
//	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
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
