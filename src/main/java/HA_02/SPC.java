package HA_02;

public class SPC extends Visitor {

    @Override
    public Object visit(Node node){

        Integer counter = 0;
        for(int i = 0; i < node.getChildNodes().size();i++){
            if(node.getChildNodes().get(i) instanceof StoryPoint &&
                    node.getChildNodes().get(i).getParentNode()instanceof Feature)
                counter++;
            counter +=(Integer)visit(node.getChildNodes().get(i));
        }
        return counter;

    }

}
