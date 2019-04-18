package HA_01;

import java.util.ArrayList;
import java.util.Iterator;

public class DeliveryService {

    private int counter = 0;
    private ArrayList<Caterer> caterers = new ArrayList<Caterer>();

    public void deliver(String fNo, String address) {
        System.out.println("Delivering-> " + fNo + " to -> " + address);
        if (counter >= caterers.size()) counter = 0;
        this.caterers.get(counter).deliver(fNo, address);
        counter++;
    }

    public void addCaterers(Caterer... caterers) {
        for (Caterer el : caterers) {
            System.out.println("Adding caterer: " +el);
            if (this.caterers.contains(el)) {
                System.out.println(el + " It was already :(");
                return;
            }
            this.caterers.add(el);
        }
    }
    public ArrayList<Caterer> getCaterers() {
        System.out.println("Retrieving caterers");
        return this.caterers;
    }

    public DeliveryService withCateres(Caterer cateres) {
        this.addCaterers(cateres);
        return this;
    }
}
