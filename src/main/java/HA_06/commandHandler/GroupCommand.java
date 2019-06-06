package HA_06.commandHandler;

import HA_06.Node;
import HA_06.controller.Controller;
import javafx.application.Platform;
import sun.rmi.runtime.RuntimeUtil;

import java.util.ArrayList;

public class GroupCommand extends CommandHandler {

    private Controller controller;
    private ArrayList<Node> listLine;

    public GroupCommand(Controller controller) {
        this.controller = controller;
        listLine = new ArrayList<>();
    }

    @Override
    public boolean execute(String[] path) {
        Node group = new Node();
        /**
         * Mehrere Linie Gruppieren (group g1 l1 l2 l3 g0 g3.l1)
         */
        for (int i = 2; i < path.length; i++) {
            listLine.add(controller.getObjects().get(path[i]));
            controller.getObjects().get(path[i]).setParentNode(group);
        }
        group.setChildrenNodes(listLine);
        group.setName(path[1]);
        controller.getObjects().put(group.getName(), group);
        controller.clearDrawArea();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    controller.drawLines(controller.getObjects().get(path[1]));
                    System.out.println("NEW OBJECT DRAW");
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
        return true;
    }
}
