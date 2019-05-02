package HA_03;

public class Print extends CommandHandler {


    public Print(Assembler next) {
        super(next);
    }

    @Override
    public boolean execute(String command) {
        String commandName = command.substring(0, command.length());
        if (!commandName.equals("Print")) {
            return false;
        }
        System.out.println(this.getNext().getStack().toString());
        return true;
    }
}
