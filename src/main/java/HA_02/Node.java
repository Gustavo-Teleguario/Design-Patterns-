package HA_02;

import java.util.ArrayList;

/**
 * Hausaufgabe 2
 * a) Implementiert ein Datenmodell für Projekte mit dem Composite Pattern
 */

public abstract class Node {

    private String name = "Unknown";
    private Node parentNode = null;
    private ArrayList<Node> childNodes = new ArrayList<Node>();


    public Node() {
    }

    public Node(String name) {
        System.out.println(getClass().getName() + " Is created with this Name: " + name + " . ");
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public Node withName(String name) {
        System.out.println(" Constructing name");
        setName(name);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Node withParentNode(Node parentNode) {
        System.out.println("Constructing parent Node");
        this.setParentNode(parentNode);
        return this;
    }

    public void setParentNode(Node parentNode) {
        if (this.getParentNode() == parentNode) return;
        this.parentNode = parentNode;
        if (parentNode != null) parentNode.addChildNode(this);
        System.out.println(parentNode.getClass().getName() + " is  set as Parent Node. ");
    }


    public Node getParentNode() {
        return this.parentNode;
    }


    public void addChildNode(Node... childNodes) {
        for (Node el : childNodes) {
            if (el == null) continue;
            if (this.getChildNodes().contains(el)) continue;
            this.getChildNodes().add(el);
            el.setParentNode(this);
            System.out.println(el + " Is added as child Node ");

        }
    }

    public ArrayList<Node> getChildNodes() {

        return this.childNodes;
    }

    public Node withChildNode(Node... childNode) {
        System.out.println(" Constructing child Node");
        this.addChildNode(childNode);
        return this;
    }

    // Falsche Implementation des Pattern (*1)
    public int sumStoryPoints() {
        int counter = 0;
        for (int j = 0; j < this.getChildNodes().size(); j++) {
            if (this.getChildNodes().get(j) instanceof StoryPoint)
                counter++;
            counter += this.getChildNodes().get(j).sumStoryPoints();
        }
        return counter;
    }

    public Object accept(Visitor visitor){
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        if (this.getName() == null)
            return getClass().getName();
        return getName();
    }
}
