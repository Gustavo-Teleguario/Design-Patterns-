package HA_06.commandHandler;

import HA_06.controller.Controller;

public class RedoCommand extends CommandHandler {
    Controller controller;

    public RedoCommand(Controller controller) {
        this.controller = controller;
    }
    @Override
    public boolean execute(String[] path) {
        controller.undoRedoCommand("redo");

        return true;
    }
}
