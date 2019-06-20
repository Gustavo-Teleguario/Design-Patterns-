package HA_07.WareHouse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WarehouseServer {

    public static WarehouseBuilder builder;
    private static ExecutorService executorService;
    private static long lastKnowWarehouseEventTime;
    public static HttpServer server;


    public static void main(String[]args){

        server = null;
        try {
            builder = new WarehouseBuilder();
            server = HttpServer.create(new InetSocketAddress(6789), 0);
            executorService = Executors.newSingleThreadExecutor();
            server.setExecutor(executorService);

            HttpContext context = server.createContext("/ping");
            context.setHandler(x-> handleShopPing(x));

            HttpContext proxyContext = server.createContext("/getShopEvents");
            //proxyContext.setHandler(x -> builder.getTheShop().getShopEvents(x));

            server.start();



        }catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleShopPing(HttpExchange x) {
    }
}
