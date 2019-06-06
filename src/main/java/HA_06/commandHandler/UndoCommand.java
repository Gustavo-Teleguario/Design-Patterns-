package HA_06.commandHandler;

import HA_06.controller.Controller;

public class UndoCommand extends CommandHandler{

    private Controller controller;


    public UndoCommand(Controller controller){
        this.controller = controller;
    }
    @Override
    public boolean execute(String[] path) {
        controller.undoRedoCommand("undo");
        return true;
    }
}
