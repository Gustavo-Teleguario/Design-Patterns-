package HA_07.Shop;

import org.fulib.yaml.EventSource;

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


    private EventSource eventSource;
    private Shop shop;
    private WarehouseProxy warehouseProxy;

    public ShopBuilder() {
        eventSource = new EventSource();
        shop = new Shop();
        warehouseProxy = new WarehouseProxy();

    }

    public void orderProduct(String productName, String addresse, String orderId){

        LinkedHashMap<String,String> event = new LinkedHashMap<>();
        ShopProduct product = getFromProducts(productName);
        double oldCount = product.getInStock();
        product.setInStock(oldCount-1);
        event.put(EVENT_TYPE,"orderProduct");
        event.put(EVENT_KEY,orderId);
        event.put(PRODUCT, productName);
        event.put("ADDRESS", addresse);
        eventSource.append(event);

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
}
