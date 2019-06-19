package HA_07;

import HA_07.Shop.ShopBuilder;
import HA_07.Shop.ShopServer;
import HA_07.WareHouse.WarehouseBuilder;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 07
 * University of Kassel
 */
// HA07: 10/10
public class AddProductToShopTest {

    @Test
    public void microServicesTest() throws Exception {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");

        WarehouseBuilder warehouseBuilder = new WarehouseBuilder();
        ShopServer shopServer = new ShopServer();
        shopServer.main(null);

        Thread.sleep(100);

        warehouseBuilder.addLotToStock("lot1", "Shoe 42, size 8", 50);
        warehouseBuilder.addLotToStock("lot2", "Shoe 42, size 8", 50);
        warehouseBuilder.addLotToStock("lot3", "Shoe 42, size 9", 50);

        //first lot
        Assert.assertTrue(warehouseBuilder.getLot("lot1") != null);
        Assert.assertTrue(warehouseBuilder.getLot("lot1").getWareHouseProduct().getName().equals("Shoe 42, size 8"));
        Assert.assertTrue(warehouseBuilder.getLot("lot1").getLotSize()== 50);
        //second lot
        Assert.assertTrue(warehouseBuilder.getLot("lot2") != null);
        Assert.assertTrue(warehouseBuilder.getLot("lot2").getWareHouseProduct().getName().equals("Shoe 42, size 8"));
        Assert.assertTrue(warehouseBuilder.getLot("lot2").getLotSize()== 50);
        // third lot
        Assert.assertTrue(warehouseBuilder.getLot("lot3") != null);
        Assert.assertTrue(warehouseBuilder.getLot("lot3").getWareHouseProduct().getName().equals("Shoe 42, size 9"));
        Assert.assertTrue(warehouseBuilder.getLot("lot3").getLotSize()== 50);


        // shopServer
        Assert.assertTrue(shopServer.builder.getFromProducts("Shoe 42, size 8").getInStock()==0);
        System.out.println(shopServer.builder.getFromProducts("Shoe 42, size 8").getInStock());
       // Assert.assertTrue(shopServer.builder.getFromProducts("Shoe 42, size 8").getId().equals("Shoe42Size8"));
        System.out.println(shopServer.builder.getFromProducts("Shoe 42, size 8").getId().equals("Shoe42size8"));

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("***********************************************");


    }
}
