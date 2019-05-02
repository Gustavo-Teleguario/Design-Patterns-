package HA_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Assembler {

    private final String path;
    private ArrayList<CommandHandler> commandHandlerList = new ArrayList<CommandHandler>();
    private Stack stack = new Stack();


    public Assembler(String path) {
        this.path = path;

    }

    public boolean execute() throws IOException {

        boolean succes = false;
        File data = new File(this.path);
        FileReader reader = new FileReader(data);
        BufferedReader inBuffer = new BufferedReader(reader);
        /**
         * line get all command from File
         */
        String lineCommand = inBuffer.readLine();
        while (lineCommand != null) {
            for (int i = 0; i < this.getCommandHandlerList().size(); i++) {
                succes = this.getCommandHandlerList().get(i).execute(lineCommand);

                if (succes) break;
            }
            lineCommand = inBuffer.readLine();
        }
        return true;
    }

    public Stack getStack() {
        return this.stack;
    }

    public ArrayList<CommandHandler> getCommandHandlerList() {
        return commandHandlerList;
    }

    public void setCommandHandlerList(ArrayList<CommandHandler> commandHandlerList) {
        this.commandHandlerList = commandHandlerList;
    }
}
