package HA_03;

import java.util.HashMap;

public abstract class CommandHandler {

    protected final Assembler next;
    protected static Integer X = 0;
    public static HashMap<String, Integer> speicher = new HashMap<String, Integer>();


    public CommandHandler(Assembler next) {
        this.next = next;
    }

    public abstract boolean execute(String path);

    public Assembler getNext() {
        return this.next;
    }

    public void addValueInMap(String s, Integer n) {
        this.speicher.put(s, n);
    }

    public void setX(Integer x) {
        this.X = x;
    }

    public Integer getX() {
        return this.X;
    }

    public HashMap<String, Integer> getSpeicher() {
        return speicher;
    }
}
