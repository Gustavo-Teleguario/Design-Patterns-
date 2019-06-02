package HA_06;

import java.util.ArrayList;

public class Node {
    private String name = "Unknow";
    private Node partenNode = null;
    private ArrayList<Node> childrenNodes = new ArrayList<>();

    public Node() {
    }

    public Node(String name) {
        System.out.println(getClass().getName() + " Is created with this name " + name + " . ");
        this.setName(name);
    }

    public void setParentNode(Node parentNode) {
        if (this.partenNode == partenNode) return;
        this.partenNode = parentNode;
        if (parentNode != null) {
            parentNode.addChildNode(this);
            System.out.println(parentNode.getClass().getName()+" is set as Parent Node. ");
        }
    }

    public void addChildNode(Node... childNode) {
        for (Node el : childNode) {
            if (el == null) continue;
            if (this.getChildrenNodes().contains(el)) continue;
            this.getChildrenNodes().add(el);
            el.setParentNode(this);
            System.out.println(el + " Is added as child Node");
        }
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Node getPartenNode() {
        return partenNode;
    }

    public ArrayList<Node> getChildrenNodes() {
        return childrenNodes;
    }

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartenNode(Node partenNode) {
        this.partenNode = partenNode;
    }

    public void setChildrenNodes(ArrayList<Node> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

}
