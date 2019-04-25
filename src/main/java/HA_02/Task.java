package HA_02;

public class Task extends Node {

    public Task() {

    }

    public Task(String name) {
        super(name);
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
