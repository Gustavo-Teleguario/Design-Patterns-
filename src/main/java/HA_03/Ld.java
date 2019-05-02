package HA_03;

public class Ld extends CommandHandler {

    public Ld(Assembler next) {
        super(next);
    }

    @Override
    public boolean execute(String command) {
        String[] lineCommand = command.split(" ");
        String nameCommand = lineCommand[0].substring(0, lineCommand[0].length());
        if (!nameCommand.equals("Ld")) {
            return false;
        }
        if (!this.getSpeicher().isEmpty()) {
            Integer valInMap = this.getSpeicher().get("X");
            this.getNext().getStack().push(valInMap);
            this.setX(valInMap);
        }
        return true;
    }
}
