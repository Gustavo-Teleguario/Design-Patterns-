package HA_08;

import HA_07.Shop.ShopBuilder;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.ShopServer;
import HA_07.WareHouse.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WebShopTest {

    @Test
    public void testWarehouse() throws Exception {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");

        try {
            Files.delete(Paths.get("database/Warehouse.yaml"));
            Files.delete(Paths.get("database/Shop.yaml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ShopServer shopServer = new ShopServer();
        WarehouseServer warehouseServer = new WarehouseServer();

        shopServer.main(null);
        warehouseServer.main(null);

        WarehouseBuilder warehouseBuilder = WarehouseServer.builder;
        ShopBuilder shopBuilder = ShopServer.builder;

        warehouseBuilder.addLotToStock("lot1", "Shoe 42, size 8", 50);
        warehouseBuilder.addLotToStock("lot2", "Shoe 42, size 8", 50);
        warehouseBuilder.addLotToStock("lot3", "Shoe 42, size 9", 50);

        printProductsFromWareHouseAndShop(warehouseBuilder, shopBuilder);
        Thread.sleep(100);
        //first lot
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot1") != null);
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot1").getWareHouseProduct().getName().equals("Shoe 42, size 8"));
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot1").getLotSize()== 50);
        //second Lot
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot3") != null);
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot3").getWareHouseProduct().getName().equals("Shoe 42, size 9"));
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot3").getLotSize()== 50);

        ShopServer.builder.addCostumer("Maynor", "Calle14");
        ShopServer.builder.orderProduct("o1", "Shoe 42, size 8", "Maynor");

        ShopOrder order = ShopServer.builder.getFromOrders("o1");

        Assert.assertEquals(order.getShopCustomer().getAddresse(),"Calle14");
        Assert.assertEquals(order.getShopCustomer().getName(),"Maynor");
        Assert.assertEquals(ShopServer.builder.getFromCustomer("Maynor").getAddresse(),"Calle14");

        printProductsFromWareHouseAndShop(warehouseBuilder,shopBuilder);

        WarehouseServer.server.stop(0);
        WarehouseServer.builder = null;

        ShopServer.server.stop(0);
        ShopServer.builder = null;

        Thread.sleep(100);

        WarehouseServer.main(null);

        Thread.sleep(100);

        printProductsFromWareHouseAndShop(warehouseBuilder,shopBuilder);

        Thread.sleep(100);

        WarehouseServer.builder.addLotToStock("lot4","Shoe 39, size 6",20 );

        Thread.sleep(100);

        printProductsFromWareHouseAndShop(warehouseBuilder,shopBuilder);

       ShopServer.main(null);

       Thread.sleep(100);

       printProductsFromWareHouseAndShop(warehouseBuilder,shopBuilder);



        System.out.println("******************** ***************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");
    }

    private void printProductsFromWareHouseAndShop(WarehouseBuilder warehouseBuilder, ShopBuilder shopBuilder) {

        if(WarehouseServer.builder != null){
            System.out.println("Warehouse: "+ warehouseBuilder.warehouse.getName());
            System.out.println("Products: " );
            for(WareHouseProduct product: warehouseBuilder.warehouse.getProducts()){
                System.out.println(product.getName()+" "+product.getId());
                for(Lot lot : product.getLots()){
                    System.out.println("LOT: "+ lot+ "size "+ lot.getLotSize());
                }
            }
        }
        if(ShopServer.builder != null){
            System.out.println("Shop: "+ shopBuilder.shop.getName());
            System.out.println("Products: ");
            for(ShopProduct product : shopBuilder.shop.getProducts()){
                System.out.println("ProductName: "+ product.getName()+ " "+ product.getId());
                System.out.println("Anzahl der Artikel "+ product.getInStock());
            }
        }
    }


}


