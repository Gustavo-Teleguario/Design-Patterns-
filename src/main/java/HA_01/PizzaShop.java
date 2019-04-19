package HA_01;

public class PizzaShop implements Caterer
{
    @Override
    public void deliver(String fNo, String addresse){

        System.out.println("I deliver Pizza: "+ fNo +" to "+ addresse);
    }
}
