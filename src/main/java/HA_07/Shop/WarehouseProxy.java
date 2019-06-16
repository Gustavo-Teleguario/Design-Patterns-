package HA_07.Shop;

import jdk.internal.util.xml.impl.Input;
import org.fulib.yaml.EventSource;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.fulib.yaml.EventSource.EVENT_TYPE;

public class WarehouseProxy {

    private EventSource eventSource;
    private ScheduledExecutorService executorService;

    public WarehouseProxy() {
        this.eventSource = new EventSource();
        executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void addProductToShop(LinkedHashMap<String, String> event) throws Exception {

        String yaml = EventSource.encodeYaml(event);
        sendRequest(yaml);

    }

    private void sendRequest(String yaml) throws Exception {
        try {

            URL url = new URL("http://localhost:3374/event");
            URLConnection conection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) conection;
            http.setRequestMethod("POST");
            http.setDoInput(true);

            byte[] output = yaml.getBytes(StandardCharsets.UTF_8);
            int lenght = output.length;

            http.setFixedLengthStreamingMode(lenght);
            http.setRequestProperty("Content-Type", "application/yaml; chartset=UTF-8");
            http.connect();

            try (OutputStream os = http.getOutputStream()) {
                os.write(output);
            }

            InputStream inputStream = http.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line = bufferedReader.readLine();
            bufferedReader.close();
        } catch (Exception e) {
            executorService.schedule(() -> {
                try {
                    sendRequest(yaml);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }, 20, TimeUnit.SECONDS);

        }
    }
}
