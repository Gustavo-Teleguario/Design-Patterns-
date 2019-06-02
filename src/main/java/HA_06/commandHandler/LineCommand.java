package HA_06.commandHandler;

import HA_06.Line;
import HA_06.controller.Controller;

public class LineCommand extends CommandHandler {

    private Controller controller;

    public LineCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public boolean execute(String[] path) {
        try {
            Line line = new Line();
            line.setName(path[1]);
            line.setxPos(Integer.parseInt(path[2]));
            line.setyPos(Integer.parseInt(path[3]));
            line.setxEnd(Integer.parseInt(path[4]));
            line.setyEnd(Integer.parseInt(path[5]));
            controller.getObjects().put(path[1], line);
            controller.drawObject(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
