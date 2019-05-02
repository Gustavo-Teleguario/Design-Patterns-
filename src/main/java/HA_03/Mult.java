package HA_03;

public class Mult extends CommandHandler {

    public Mult(Assembler next) {
        super(next);
    }

    @Override
    public boolean execute(String command) {

        String commandName = command.substring(0, command.length());
        if (!commandName.equals("Mult")) {
            return false;
        }
        String valueX = null;
        String valueY = null;

        Integer result = 0;
        /**
         * get 2 numbers from stack if them exist
         */
        if (this.getNext().getStack().toString().length() > 4) {
            //multipliziere 2 werte und push das ergebnisse in Stack
            valueX = (String) this.getNext().getStack().pop();
            valueY = (String) this.getNext().getStack().pop();
            result = Integer.parseInt(valueX) * Integer.parseInt(valueY);
            this.setX(result);
            this.getNext().getStack().push(result);
        } else {
            this.setX(0);
        }
        return true;
    }
}
