package HA_06.controller;

import HA_06.commandHandler.*;
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
    private TextField commandField;

    public Controller() {
        LineCommand lineCommand = new LineCommand(this);
        GroupCommand groupCommand = new GroupCommand(this);
        CloneCommand cloneCommand = new CloneCommand(this);
        commandList = new LinkedList<>();
        revertedCommand = new LinkedList<>();
        objects = new HashMap<>();

        handle = new HashMap<String, CommandHandler>();
        handle.put("line", lineCommand);
        handle.put("group", groupCommand);
        handle.put("clone", cloneCommand);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("2D-GRAPHIC-EDITOR");
        VBox box = new VBox();
        this.commandField = new TextField();
        this.commandField.setId("commandField");
        this.commandField.setMinWidth(300);
        this.drawArea = new Pane();
        this.commandField.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

    public void drawLines(Node nodeObject) {
        if (nodeObject.getChildrenNodes() == null) {
            HA_06.Line lineObject = (HA_06.Line) nodeObject;
            Line line = new Line();
            line.setStartX(lineObject.getxPos());
            line.setStartY(lineObject.getyPos());
            line.setEndX(lineObject.getxEnd());
            line.setEndY(lineObject.getyEnd());
            drawArea.getChildren().addAll(line);
            return;
        }
        for (Node el : nodeObject.getChildrenNodes()) {
            if (el != null) {
                drawLines(el);
            }
        }
    }

    public void clearDrawArea() {
        System.out.println("AREA CLEANING\n");
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

    public void setHandle(HashMap<String, CommandHandler> handle) {
        this.handle = handle;
    }

    public Pane getDrawArea() {
        return drawArea;
    }

    public TextField getCommandField() {
        return commandField;
    }
}
