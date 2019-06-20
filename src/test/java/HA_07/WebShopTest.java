package HA_07;

import HA_07.Shop.ShopProduct;
import HA_07.Shop.ShopServer;
import HA_07.WareHouse.WareHouse;
import HA_07.WareHouse.WarehouseBuilder;
import HA_07.WareHouse.WarehouseServer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Files.delete;

public class WebShopTest {

    @Test
    public void testWarehouse() throws Exception {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");

        Files.walk(Paths.get("database")).filter(path -> path.toString().endsWith(".yaml")).forEach(path -> {
            try {
                delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        ShopServer shopServer = new ShopServer();
        WarehouseServer warehouseServer = new WarehouseServer();

        warehouseServer.main(null);
        shopServer.main(null);

        Thread.sleep(100);

        WarehouseServer.builder.addLotToStock("lot1", "Shoe 42, size 8", 50);
        WarehouseServer.builder.addLotToStock("lot2", "Shoe 42, size 8", 50);
        WarehouseServer.builder.addLotToStock("lot3", "Shoe 42, size 9", 50);

        //first lot
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot1") != null);
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot1").getWareHouseProduct().getName().equals("Shoe 42, size 8"));
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot1").getLotSize()== 50);
        //second lot
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot2") != null);
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot2").getWareHouseProduct().getName().equals("Shoe 42, size 8"));
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot2").getLotSize()== 50);
        // third lot
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot3") != null);
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot3").getWareHouseProduct().getName().equals("Shoe 42, size 9"));
        Assert.assertTrue(     WarehouseServer.builder.getLot("lot3").getLotSize()== 50);


        Thread.sleep(100);

        //Shop Product  Video shauen


        // shopServer
      /*  Assert.assertTrue(shopServer.builder.getFromProducts("Shoe 42, size 8").getInStock()==0);
        System.out.println(shopServer.builder.getFromProducts("Shoe 42, size 8").getInStock());
        // Assert.assertTrue(shopServer.builder.getFromProducts("Shoe 42, size 8").getId().equals("Shoe42Size8"));
        System.out.println(shopServer.builder.getFromProducts("Shoe 42, size 8").getId().equals("Shoe42size8"));*/

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");


    }
}
