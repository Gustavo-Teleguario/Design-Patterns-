package HA_07.Shop;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fulib.yaml.Yamler;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ShopServer {

    public static ShopBuilder builder;
    private static ScheduledExecutorService executor;
    private static ExecutorService threadPool;
    private static Date time;
    private static String lastKnowWarehouseEventTime;
    public static HttpServer server;

    public ShopServer() {
        builder = new ShopBuilder();
        time = new Date();
    }

    public static void main(String[] args) {

       server = null;

        try {
            executor = Executors.newSingleThreadScheduledExecutor();
            threadPool = Executors.newCachedThreadPool();

            server = HttpServer.create(new InetSocketAddress(5001), 0);
            server.setExecutor(executor);
            HttpContext context = server.createContext("/do");
            context.setHandler(x -> handleReques(x));

            HttpContext proxyContent = server.createContext("/getWarehouseEvents");
            proxyContent.setHandler(x-> builder.wareHouse.getWarehouseEvent(x));

            server.start();

            /*
            Funktioniert leider nicht
             */
           // retrieveNewEventsFromWarehouse();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void retrieveNewEventsFromWarehouse() {
        lastKnowWarehouseEventTime = time.toString();
        String wareHouseEvents = sendRequest("http://localhost:3374/getShopEvents", "lastKnow" + lastKnowWarehouseEventTime);
        ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(wareHouseEvents);
        executor.execute(() -> builder.applyEvent(eventList));
    }

    public static String sendRequest(String urlAdress, String yaml) {
        Logger.getGlobal().info("\n" + "Shopserver:: sendRequest\n" + " url: "
                + urlAdress + " \n" + "postYaml: " + yaml);

        try {

            URL url = new URL(urlAdress);
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
            StringBuilder text = new StringBuilder();
            bufferedReader.close();
            while (true){
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                text.append(line);
            }

            bufferedReader.close();
            String response = text.toString();
            return response;
        } catch (Exception e) {
            executor.schedule(()-> sendRequest(urlAdress,yaml),60, TimeUnit.SECONDS);
        }
        return null;
    }

    private static void handleReques(HttpExchange exchange) throws IOException {

        String body = getBody(exchange);
        System.out.println("Shop Server: got " + body);
      //  ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(body.toString());
        writeAnswer(exchange, "OK");
        retrieveNewEventsFromWarehouse();
    }

    private static void writeAnswer(HttpExchange exchange, String response) {

        try {
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            Logger.getGlobal().info("could not ansewer");
        }
    }

    public static String getBody(HttpExchange exchange) throws IOException {
        URI requestURI = exchange.getRequestURI();
        InputStream requestBody = exchange.getRequestBody();
        BufferedReader buf = new BufferedReader(new InputStreamReader(requestBody, StandardCharsets.UTF_8));
        StringBuilder text = new StringBuilder();

        while (true) {

            String line = buf.readLine();
            if (line == null) {
                break;
            }
            text.append(line);
        }
        String yaml = text.toString();
        return yaml;
    }
}
