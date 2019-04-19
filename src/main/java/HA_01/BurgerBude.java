package HA_01;

public class BurgerBude implements Caterer
{
    @Override
    public void deliver(String fNo, String addresse){
        System.out.println("I deliver burgers: "+ fNo +" to "+ addresse);
    }

}
