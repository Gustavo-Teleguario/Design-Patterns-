package HA_07.Shop;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.fulib.yaml.Yamler;


import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ShopServer {

    public static ShopBuilder builder;

    public ShopServer() {
        builder = new ShopBuilder();
    }

    public static void main(String[]args) {

        HttpServer server = null;

        try {
            server = HttpServer.create(new InetSocketAddress(5001), 0);
            HttpContext context = server.createContext("/do");
            context.setHandler(x -> handleReques(x));

            server.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleReques(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
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
        os.close();
    }
}
