package HA_05;

import org.json.JSONObject;

import java.io.IOException;

public class TransportListener {
    private String type;
    private String name;
    private String startLocation;
    private String destination;
    private String time;



    private String preice;
    private boolean confirmation;

    public TransportListener(){

    }

    public TransportListener(String type, String name, String location, String destination, String time, boolean confirmation, String preice){
        this.type = type;
        this.name = name;
        this.startLocation = location;
        this.destination = destination;
        this.time = time;
        this.confirmation = confirmation;
        this.preice = preice;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }
    public void setPreice(String preice) {
        this.preice = preice;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public String getStartLocation() {
        return startLocation;
    }
    public String getDestination() {
        return destination;
    }
    public String getTime() {
        return time;
    }
    public boolean getConfirmation() {
        return confirmation;
    }
    public String getPreice() {
        return preice;
    }

    public String toString(){
        String listenerTransport = "";
        try{
            JSONObject propertys = new JSONObject();
            propertys.put("type",this.getType());
            propertys.put("name", this.getName());
            propertys.put("startLocation",this.getStartLocation());
            propertys.put("destination",this.getDestination());
            propertys.put("time", this.getTime());
            propertys.put("preiceField",this.getPreice());
            propertys.put("confirmation", this.getConfirmation());

            listenerTransport = propertys.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listenerTransport;
    }

}
