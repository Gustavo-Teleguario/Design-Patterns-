package HA_06.commandHandler;

import HA_06.Node;
import HA_06.controller.Controller;

public class DrawCommand extends CommandHandler {

    Controller controller;

    public DrawCommand(Controller controller){
        this.controller = controller;
    }
    @Override
    public boolean execute(String[] path) {

        Node childNode = controller.getObjects().get(path[1]);
        controller.drawObject(controller.getObjects().get(path[1]));
        return true;
    }
}
