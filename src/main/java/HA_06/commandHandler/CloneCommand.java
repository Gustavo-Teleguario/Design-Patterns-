package HA_06.commandHandler;

import HA_06.Line;
import HA_06.Node;
import HA_06.controller.Controller;

import java.util.ArrayList;
public class CloneCommand extends CommandHandler {

    private Controller controller;
    private ArrayList<Node> listLine;

    public CloneCommand(Controller controller) {
        this.controller = controller;
        this.listLine = new ArrayList<>();
    }

    @Override
    public boolean execute(String[] path) {
        ArrayList<Node> tempList = new ArrayList<>();
        double shiftPosX = 0;
        double shiftPoxY = 0;
        /**
         * Group clone und offset Koordinaten (clone g1 posX posY)
         */
        for (int i = 1; i < path.length - 2; i++) {
            listLine.add(controller.getObjects().get(path[i]));
            if(path[i].toString().equals("g1")){
                shiftPosX = Double.parseDouble(path[path.length - 1]);
                System.out.println("object name clone->"+path[i].toString()+" Pos "+path[path.length - 2]);
            }else if(path[i].toString().equals("g2")){

            }
        }


       // double shiftPosX = Double.parseDouble(path[path.length - 2]);

        for (Node el : listLine) {
            if (el.getChildrenNodes() != null) {
                Node tmpNode = new Node();
                tmpNode.getChildrenNodes().addAll(el.getChildrenNodes());
                if (el.getPartenNode() != null) {
                    tmpNode.setParentNode(el.getPartenNode());
                }
                tempList.add(tmpNode);
            }
        }
        for (Node childNode : tempList.get(0).getChildrenNodes()) {
            Node parent = childNode.getPartenNode();
            Line line = (Line) childNode;
            line.setxPos(line.getxPos() + shiftPosX);
            line.setxEnd(line.getxEnd() + shiftPosX);
            line.setyPos(line.getyPos() + shiftPoxY);
            line.setyEnd(line.getyEnd() + shiftPoxY);
            line.setParentNode(parent);
            tempList.add(line);
        }
        listLine = tempList;
        for (Node el : listLine) {
            this.controller.drawLines(el);
        }
        return true;
    }
}
