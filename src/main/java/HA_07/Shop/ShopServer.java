package HA_07.Shop;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fulib.yaml.Yamler;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ShopServer {

    private static ShopBuilder builder;
    private static ExecutorService executor;
    private static ExecutorService threadPool;
    private static Date time;
    private static String lastKnowWarehouseEventTime;

    public ShopServer() {
        builder = new ShopBuilder();
    }

    public static void main(String[] args) {

        HttpServer server = null;

        try {
            executor = Executors.newSingleThreadExecutor();
            threadPool = Executors.newCachedThreadPool();

            server = HttpServer.create(new InetSocketAddress(5001), 0);
            server.setExecutor(executor);
            HttpContext context = server.createContext("/do");
            context.setHandler(x -> handleReques(x));

            HttpContext proxyContent = server.createContext("/getWarehouseEvents");

            server.start();

            retrieveNewEventsFromWarehouse();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void retrieveNewEventsFromWarehouse() {

        lastKnowWarehouseEventTime = time.toString();
        String wareHouseEvents = sendRequest("http://localhost:3374/getShopEvent", "lastKnow" + lastKnowWarehouseEventTime);
        ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(wareHouseEvents);
        executor.execute(() -> builder.applyEvent(eventList));
    }

    private static String sendRequest(String url, String postYaml) {
        Logger.getGlobal().info("\n" + "Shopserver:: sendRequest\n" + " url: "
                + url + " \n" + "postYaml: " + postYaml);

      /*  try {

        }catch (IOException e){
            e.printStackTrace();
        }*/
        return null;
    }

    private static void handleReques(HttpExchange exchange) throws IOException {

        String body = getBody(exchange);
        System.out.println("Shop Server: got " + body);
        ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(body.toString());
        writeAnswer(exchange, "OK");

        retrieveNewEventsFromWarehouse();

       /* InputStream requestBody = exchange.getRequestBody();
        BufferedReader reader = new BufferedReader(new InputStreamReader(requestBody));

        StringBuilder message = new StringBuilder();

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            message.append(line).append("\n");
        }
        String yaml = message.toString();
        ArrayList<LinkedHashMap<String, String>> list = new Yamler().decodeList(yaml);
        builder.applyEvent(list);

        String response = "OK" + exchange.getRequestURI();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();*/
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
