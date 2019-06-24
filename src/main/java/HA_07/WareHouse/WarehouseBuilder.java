package HA_07.WareHouse;

import HA_07.Shop.WarehouseProxy;
import org.fulib.yaml.EventFiler;
import org.fulib.yaml.EventSource;
import org.fulib.yaml.Yamler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.fulib.yaml.EventSource.EVENT_KEY;
import static org.fulib.yaml.EventSource.EVENT_TYPE;

public class WarehouseBuilder {

    public static final String ADD_LOT_TO_STOCK = "addLotToStock";
    public static final String LOT_ID = "lotId";
    public static final String PRODUCT = "product";
    public static final String SIZE = "size";
    public static final String ADD_PRODUCT = "addProduct";
    public static final String PRODUCT_ID = "productId";
    public static final String NAME = "name";
    public static final String ORDER_PRODUCT = "orderProduct";
    public static final String ADDRESS = "address";

    private WarehouseProxy warehouseProxy;
    private EventSource eventSource;
    public ShopProxy theShop;
    public WareHouse warehouse;

    public WarehouseBuilder() throws Exception {
        warehouse = new WareHouse().setName("TheWarehouse");
        warehouseProxy = new WarehouseProxy();
        eventSource = new EventSource();

        EventFiler eventFiler = new EventFiler(eventSource).setHistoryFileName("database/Warehouse.yaml");
        for (int i = 23; i < 28; i++) {
            PalettePlace palettePlace = new PalettePlace()
                    .setColumn(i)
                    .setRow(42)
                    .setId(String.format("place%dx%d", 42, i))
                    .setWareHouse(warehouse);
        }

        String yaml = eventFiler.loadHistory();
        if (yaml != null) {
            ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(yaml);
            this.applyEvents(eventList);
        }
        eventFiler.startEventLogging();
    }

    public void applyEvents(ArrayList<LinkedHashMap<String, String>> eventList) throws Exception {

        for (LinkedHashMap<String, String> map : eventList) {
            if (ADD_LOT_TO_STOCK.equals(map.get(EVENT_TYPE))) {
                int size = Integer.valueOf(map.get(SIZE));
                addLotToStock(map.get(LOT_ID), map.get(PRODUCT), size);
            } else if (ORDER_PRODUCT.equals(map.get(EVENT_TYPE))) {
                orderProduct(map.get(EVENT_KEY), map.get(PRODUCT), map.get(ADDRESS));
            }
        }
    }

    private void orderProduct(String orderId, String productName, String address) {
        WareHouseOrder order = getFromOrders(orderId);

        if (order.getProduct() == null) {
            //new Order
            WareHouseProduct product = getFromProducts(productName);
            // order.setProduct(product);
            order.setAddresse(address);

            LinkedHashMap<String, String> event = new LinkedHashMap<>();
            event.put(EVENT_TYPE, ORDER_PRODUCT);
            event.put(EVENT_KEY, orderId);
            event.put(PRODUCT, productName);
            event.put(ADDRESS, ADDRESS);
            eventSource.append(event);

            Lot lot = product.getLots().get(0);


        }
    }

    private WareHouseOrder getFromOrders(String orderId) {
        return null;
    }

    public Lot addLotToStock(String lotId, String productName, int size) throws Exception {
        Lot lot = getLot(lotId);
        double oldSize = lot.getLotSize();

        WareHouseProduct wareHouseProduct = getFromProducts(productName);

        lot.setWareHouseProduct(wareHouseProduct);

        if (lot.getPalettePlace() == null) {
            for (PalettePlace place : this.warehouse.getPlaces()) {
                if (place.getLot() == null) {
                    place.setLot(lot);
                    break;
                }
            }
        }
        lot.setLotSize(size);
        LinkedHashMap<String, String> event = new LinkedHashMap<>();
        event.put(EVENT_TYPE, "add_product_to_shop");
        event.put(EVENT_KEY, lotId);
        event.put(LOT_ID, lotId);
        event.put(PRODUCT, productName);
        event.put(SIZE, "  " + size);
        eventSource.append(event);

        if (oldSize == 0.0) {
            this.warehouseProxy.addProductToShop(event);
        }
        return lot;
    }

    private WareHouseProduct getFromProducts(String name) {

        String productId = name.replaceAll("\\W", "");

        for (WareHouseProduct product : warehouse.getProducts()) {

            if (product.getId().equals(productId)) {
                product.setName(name);
                return product;
            }
        }

        WareHouseProduct result = new WareHouseProduct()
                .setId(productId)
                .setName(name)
                .setWareHouse(this.warehouse);

        return result;
    }

    public Lot getLot(String lotId) {

        for (WareHouseProduct product : warehouse.getProducts()) {
            for (Lot lot : product.getLots()) {
                if (lot.getId().equals(lotId)) {
                    return lot;
                }
            }
        }
        Lot lot = new Lot()
                .setId(lotId);
        return lot;
    }

}
