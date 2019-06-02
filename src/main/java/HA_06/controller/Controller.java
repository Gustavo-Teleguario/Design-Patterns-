package HA_06.controller;
import HA_06.commandHandler.CommandHandler;
import HA_06.commandHandler.DrawCommand;
import HA_06.commandHandler.LineCommand;
import HA_06.Node;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.LinkedList;

public class Controller extends Application {

    private LinkedList<String> commandList;
    private LinkedList<String> revertedCommand;
    private HashMap<String, CommandHandler> handle;
    private HashMap<String, Node> objects;

    private Pane drawArea;


    public Controller() {

        LineCommand lineCommand = new LineCommand(this);
        DrawCommand drawCommand = new DrawCommand(this);
        commandList = new LinkedList<>();
        revertedCommand = new LinkedList<>();
        objects = new HashMap<>();
        handle = new HashMap<String, CommandHandler>();
        handle.put("line", lineCommand);
        handle.put("draw", drawCommand);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        TextField commandField = new TextField();
        commandField.setMinWidth(300);
        this.drawArea = new Pane();
        commandField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() != KeyCode.ENTER) {
                    return;
                }
                String command;
                command = commandField.getText();
                getCommandList().add(command);
                System.out.println(command);
                String[] stringsParts = command.split(" ");
                CommandHandler commandHandler = handle.get(stringsParts[0]);
                System.out.println(handle.get(stringsParts));
                commandHandler.execute(stringsParts);
                commandField.clear();
            }
        });

        drawArea.setMinSize(400, 300);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(drawArea, commandField);

        final Scene scene = new Scene(box, 600, 400);
        scene.setFill(null);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void drawLine(Line line) {
        drawArea.getChildren().addAll(line);

    }

    public void drawObject(Node nodeObject) {
        if (nodeObject.getChildrenNodes() == null) {
            HA_06.Line lineObject = (HA_06.Line) nodeObject;
            Line line = new Line();
            line.setStartX(lineObject.getxPos());
            line.setStartY(lineObject.getyPos());
            line.setEndX(lineObject.getxEnd());
            line.setEndY(lineObject.getyEnd());
            drawLine(line);
            return;
        }
        for (Node el : nodeObject.getChildrenNodes()) {
            if (el != null) {
                drawObject(el);
            }
        }
    }
    public void clearDrawArea() {
        System.out.println(drawArea);
        drawArea.getChildren().clear();
    }

    public LinkedList<String> getCommandList() {
        return commandList;
    }

    public LinkedList<String> getRevertedCommand() {
        return revertedCommand;
    }

    public HashMap<String, CommandHandler> getHandle() {
        return handle;
    }

    public HashMap<String, Node> getObjects() {
        return objects;
    }

}
