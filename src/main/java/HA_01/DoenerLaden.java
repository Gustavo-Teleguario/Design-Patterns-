package HA_01;

public class DoenerLaden implements Caterer
{
    public void deliver(String fNo, String addresse){
        System.out.println("I deliver Doener: "+ fNo +" to "+ addresse);
    }
}
