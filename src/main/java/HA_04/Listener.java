package HA_04;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


public class Listener {

    public BufferedWriter bufferedWriter = null;
    public FileWriter fileWriter = null;
    public HashMap<Node, String> listObject;

    public Listener() {
        listObject = new HashMap<>();
    }

    public void propertyChange(Node object, String name, Object oldValue, Object newValue) {

        JSONObject propertyChange = new JSONObject();
        propertyChange.put("ChangeProperty", name);
        propertyChange.put("ObjectId", object.getId());
        propertyChange.put("ObjectName", object.getClass().getName());
        propertyChange.put("OldValue", oldValue);
        propertyChange.put("NewValue", newValue);
        propertyChange.put("TimeStamp", System.currentTimeMillis());


        try {

            if (bufferedWriter == null) {
                fileWriter = new FileWriter("src/test/log.json");
                bufferedWriter = new BufferedWriter(fileWriter);
            }
            bufferedWriter.write(propertyChange.toString());
            System.out.println("Successfully Copied JSON Object to File ..");
            System.out.println("\nJSON Object " + propertyChange);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public void subscribe(Node node) {
        listObject.put(node, node.getId());
        node.listener = this;
    }
}
