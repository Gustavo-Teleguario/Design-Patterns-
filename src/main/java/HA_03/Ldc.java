package HA_03;

public class Ldc extends CommandHandler {


    public Ldc(Assembler next) {
        super(next);
    }

    @Override
    public boolean execute(String command) {

        String commandName = command.substring(0, command.length() - 2);
        if (!commandName.equals("Ldc")) {
            return false;
        }
        String[] values = command.split(" ");
        /**
         * add value into Stack
         */
        this.setX(Integer.parseInt((String) this.getNext().getStack().push(values[1])));

        return true;
    }
}
