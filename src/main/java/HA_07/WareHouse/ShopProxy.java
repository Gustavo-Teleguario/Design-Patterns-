package HA_07.WareHouse;

import org.fulib.yaml.EventFiler;
import org.fulib.yaml.EventSource;
import org.fulib.yaml.Yamler;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.fulib.yaml.EventSource.EVENT_KEY;
import static org.fulib.yaml.EventSource.EVENT_TYPE;

public class ShopProxy {

    public static final String ADD_PRODUCT_TO_SHOP = "addProductToShop";
    public static final String PRODUCT = "product";
    public static final String NUMBER_OF_TIMES = "numberOfTimes";

    private EventSource eventSource;
    private ScheduledExecutorService executor;

    public ShopProxy() {

        this.eventSource = new EventSource();
        executor = Executors.newSingleThreadScheduledExecutor();

        EventFiler eventFiler = new EventFiler(eventSource)
                .setHistoryFileName("database/ShopProxy.yaml");

        String history = eventFiler.loadHistory();
        if (history != null) {
            ArrayList<LinkedHashMap<String, String>> eventsList = new Yamler().decodeList(history);
            eventSource.append(history);
        }
        eventFiler.storeHistory();
        eventFiler.startEventLogging();
    }

    public void addProductToShop(String bookingId, String productName, int numberOfItems) {

        LinkedHashMap<String, String> event = new LinkedHashMap<String, String>();
        event.put(EVENT_TYPE, ADD_PRODUCT_TO_SHOP);
        event.put(EVENT_KEY, bookingId);
        event.put(PRODUCT, productName);
        event.put(NUMBER_OF_TIMES, "" + numberOfItems);

        eventSource.append(event);
        String yaml = EventSource.encodeYaml(event);

    }

    public void sendRequest(String yaml) throws IOException {

        try {
            URL url = new URL("http://localhost:3374/event");
            URLConnection connection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) connection;
            http.setRequestMethod("POST");
            http.setDoOutput(true);

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
            executor.schedule(() -> {
                try {
                    sendRequest(yaml);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }, 20, TimeUnit.SECONDS);

        }
    }


    public String getEventSource() {
        String yaml = eventSource.encodeYaml();
        return yaml;
    }
}
