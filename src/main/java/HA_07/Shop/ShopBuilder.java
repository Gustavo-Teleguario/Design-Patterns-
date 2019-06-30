package HA_07.Shop;

import HA_06.Line;
import HA_07.WareHouse.WareHouse;
import org.fulib.yaml.EventFiler;
import org.fulib.yaml.EventSource;
import org.fulib.yaml.Yamler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.fulib.yaml.EventSource.EVENT_KEY;
import static org.fulib.yaml.EventSource.EVENT_TYPE;

public class ShopBuilder {

    public static final String ADD_PRODUCT_TO_SHOP = "addProductToShop";
    public static final String SIZE = "size";
    public static final String PRODUCT = "product";
    public static final String NUMBER_OF_ITEMS = "numberOfItems";
    public static final String ADD_CUSTOMER = "addCustomer";


    private EventSource eventSource;
    public Shop shop;
    private WarehouseProxy warehouseProxy;
    public WareHouse wareHouse;

    public ShopBuilder() {
        eventSource = new EventSource();
        shop = new Shop().setName("TheShop");
        warehouseProxy = new WarehouseProxy();

       EventFiler eventFilter = new EventFiler(eventSource)
                .setHistoryFileName("database/Shop.yaml");
        String yaml = eventFilter.loadHistory();
        if(yaml != null){
            ArrayList<LinkedHashMap<String,String>> eventList = new Yamler().decodeList(yaml);
            this.applyEvent(eventList);
        }
        eventFilter.startEventLogging();

    }

    public void orderProduct(String orderId, String productName, String customerName){

        LinkedHashMap<String,String> event = eventSource.getEvent(orderId);
        if(event != null){
            return;
        }

        ShopOrder order = getFromOrders(orderId);
        ShopCustomer customer = getFromCustomer(customerName);
        ShopProduct product = getFromProducts(productName);


        double size = product.getInStock() -1;
        if(size == 0){
            shop.getProducts().remove(product);
        }
        product.setInStock(size);
        order.setShopCustomer(customer);

        event = new LinkedHashMap<String, String>();
        event.put(EVENT_TYPE,ADD_CUSTOMER);
        event.put(EVENT_KEY,orderId);
        event.put(PRODUCT, productName);
        event.put("NAME", order.getShop().getName());
        eventSource.append(event);

        String yaml = eventSource.encodeYaml();
        ShopServer.sendRequest("http://localhost:5002/warehouseOrder",yaml);

        warehouseProxy.orderProduct(event);

    }

    public void applyEvent(ArrayList<LinkedHashMap<String, String>> list) {
        for (LinkedHashMap<String, String> lis : list) {
            if (ADD_PRODUCT_TO_SHOP.equals(lis.get(EVENT_TYPE))) {

                String numberOfItems = lis.get(SIZE);
                int counter = Integer.parseInt(numberOfItems);
                addProductToShop(lis.get(EVENT_KEY), lis.get("productName"), counter);
            }
        }
    }

    private void addProductToShop(String eventKey, String productName, int counter) {

        LinkedHashMap<String,String> event = eventSource.getEvent(eventKey);
        if(event != null){
            return;
        }
        ShopProduct shopProduct = getFromProducts(productName);
        double inStock = shopProduct.getInStock();
        shopProduct.setInStock(inStock+counter);

        event = new LinkedHashMap<>();
        event.put(EVENT_TYPE,"add_product_to_shop");
        event.put(EVENT_KEY, eventKey);
        event.put(PRODUCT, productName);
        event.put(NUMBER_OF_ITEMS," "+shopProduct.getInStock());
        eventSource.append(event);



    }

    public ShopProduct getFromProducts(String productName) {
        String productId = productName.replaceAll("\\W","");
        for(ShopProduct product: shop.getProducts()){
            if(product.getName().equals(productName)){
                return product;
            }
        }
        ShopProduct shopProduct = new ShopProduct()
                .setName(productName)
                .setId(productId)
                .setShop(this.shop);

        return shopProduct;
    }

    public void addCostumer(String name, String address){

        LinkedHashMap<String, String> event = eventSource.getEvent(name);
        if(event != null){
            return;
        }
        ShopCustomer customer = getFromCustomer(name)
        .setAddresse(address);

        event = new LinkedHashMap<String,String>();
        event.put(EVENT_TYPE, "ADD_CUSTOMER");
        event.put(EVENT_KEY, name);
        event.put("ADDRESS", customer.getAddresse());
        eventSource.append(event);
    }

    public ShopCustomer getFromCustomer(String name) {

        for(ShopCustomer el: shop.getCustomers()){
            if(el.getName().equals(name)){
                return el;
            }
        }
        ShopCustomer result = new ShopCustomer()
                .setName(name)
                .setShop(shop);
        return result;
    }

    public ShopOrder getFromOrders(String orderId) {
        for(ShopOrder order: shop.getOrders()){
            if(order.getId().equals(orderId)){
                return order;
            }
        }
        ShopOrder result = new ShopOrder()
                .setId(orderId)
                .setShop(shop);
        return result;
    }
}
