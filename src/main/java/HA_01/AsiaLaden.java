package HA_01;

public class AsiaLaden implements Caterer
{

    @Override
    public void deliver(String fNo, String address) {
        System.out.println("gebratenen Nudel No: "+ fNo + " to "+ address);
    }
}
