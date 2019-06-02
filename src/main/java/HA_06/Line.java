package HA_06;

import java.util.ArrayList;

public class Line extends Node{

    private double xPos;
    private double yPos;
    private double xEnd;
    private double yEnd;


    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public void setxEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public void setyEnd(double yEnd) {
        this.yEnd = yEnd;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public double getxEnd() {
        return xEnd;
    }

    public double getyEnd() {
        return yEnd;
    }


    public void setChildren(ArrayList<Node> children){
        return;
    }

    @Override
    public ArrayList<Node> getChildrenNodes() {
        return null;
    }
}
