package HA_04;

import java.util.ArrayList;

/**
 * Hausaufgabe 04
 * Erweiterung für Listener
 */

public class Node {

    //hausaufgabe 4
    private String description = "Unknown";
    private ArrayList<Node> childNodes = new ArrayList<Node>();
    private int storyPoints = 0;
    private String id;
    Listener listener;

    public Node() {
    }

    public Node(Listener listener) {

        this.setId(" Id " + listener.randomUUID());
        this.listener = listener;
        listener.subscribe(this);
    }


    public ArrayList<Node> getChildNodes() {

        return this.childNodes;
    }

    public int sumStoryPoints() {
        int counter = 0;
        for (int j = 0; j < this.getChildNodes().size(); j++) {
            /*if (this.getChildNodes().get(j) instanceof this.getStoryPoints())
                counter++;*/
            counter += this.getChildNodes().get(j).sumStoryPoints();
        }
        return counter;
    }

    /*******************************************************/
    public int getStoryPoints() {
        return storyPoints;
    }

    public String getId() {
        return id;
    }

    public Node setStoryPoints(int value) {
        if (value != this.storyPoints) {
            System.out.println("storyPoint added");
            int oldValue = this.storyPoints;
            this.storyPoints = value;
            firePropertyChange("storyPoint", oldValue, value);
        }
        return this;
    }

    public Node setId(String value) {
        if (value != this.id) {
            System.out.println("ID added");
            String oldValue = this.id;
            this.id = value;
            firePropertyChange("Id", oldValue, value);
        }
        return this;

    }

    public Node setDescription(String value) {
        if (value != this.description) {
            System.out.println("description added");
            String oldValue = this.description;
            this.description = value;
            firePropertyChange("Description", oldValue, value);
        }
        return this;

    }

    public Node setNodeChild(Node value) {
        ArrayList<Node> oldValue = new ArrayList<Node>();
        oldValue.addAll(childNodes);
        childNodes.add(value);
        firePropertyChange("Children", oldValue, childNodes);
        listener.subscribe(value);
        return this;
    }

    public String getDescription() {
        return this.description;
    }


    public boolean firePropertyChange(String name, Object oldValue, Object newValue) {
        if (listener != null) {
            listener.propertyChange(this, name, oldValue, newValue);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getDescription() == null)
            return getClass().getName();
        return getDescription();
    }
}
