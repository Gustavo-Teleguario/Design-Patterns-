package HA_03;

public class Store extends CommandHandler {

    public Store(Assembler next) {
        super(next);
    }

    @Override
    public boolean execute(String command) {
        String[] values = command.split(" ");
        String commandName = values[0].substring(0, values[0].length());

        if (!commandName.equals("Store")) {
            return false;
        }
        if (X == 0) {
            return false;
        }
        if (!this.getNext().getStack().isEmpty()) {
            Integer valueXY = (Integer) this.getNext().getStack().pop();
            this.addValueInMap("X", valueXY);
        } else {
            return false;
        }
        return true;
    }

}
