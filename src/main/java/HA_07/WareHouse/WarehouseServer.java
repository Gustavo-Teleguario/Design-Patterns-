package HA_07.WareHouse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fulib.yaml.Yamler;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.*;
import java.util.logging.Logger;

import static HA_07.Shop.ShopServer.getBody;

public class WarehouseServer {

    public static WarehouseBuilder builder;
    private static ScheduledExecutorService executorService;
    public static HttpServer server;

    public static void main(String[] args) {

        server = null;
        try {
            builder = new WarehouseBuilder();
            server = HttpServer.create(new InetSocketAddress(5002), 0);
            executorService = Executors.newSingleThreadScheduledExecutor();
            server.setExecutor(executorService);

            HttpContext context = server.createContext("/getShopEvent");
            context.setHandler(x -> {
                try {
                    handleShopPing(x);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            HttpContext proxyContext = server.createContext("/getShopEvents");
            proxyContext.setHandler(x -> handleWarehouseRequest(x));

            server.start();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleWarehouseRequest(HttpExchange exchange) {
        String events = getBody(exchange);
        writeAnswer(exchange, "OK");
        ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(events);
        executorService.execute(() -> {
            try {
                builder.applyEvents(eventList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    private static void handleShopPing(HttpExchange exchange) throws Exception {

        String body = getBody(exchange);
        System.out.println("Warehouse Sever got" + body);

        URI requestURI = exchange.getRequestURI();
        InputStream requestBody = exchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody, StandardCharsets.UTF_8));
        StringBuilder text = new StringBuilder();

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            text.append(line);
        }

        String yaml = text.toString();
        ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(yaml);
        builder.applyEvents(eventList);

        String response = builder.theShop.getEventSource();
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }

    private static String getBody(HttpExchange exchange) {
        URI requestURI = exchange.getRequestURI();
        InputStream requestBody = exchange.getRequestBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(requestBody, StandardCharsets.UTF_8));
        StringBuilder text = new StringBuilder();

        while (true) {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
            text.append(line);
            text.append("\n");
        }
        String yaml = text.toString();
        return yaml;
    }

    public static void sendRequest(String urlAddress, String yaml) {

        try {
            URL url = new URL(urlAddress);
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

        } catch (Exception e) {
            executorService.schedule(() -> sendRequest(urlAddress, yaml), 50, TimeUnit.SECONDS);
        }
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

}
