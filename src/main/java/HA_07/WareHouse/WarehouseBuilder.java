package HA_07.WareHouse;

import HA_07.Shop.WarehouseProxy;
import org.fulib.yaml.EventFiler;
import org.fulib.yaml.EventSource;
import org.fulib.yaml.Yamler;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.fulib.yaml.EventSource.EVENT_KEY;
import static org.fulib.yaml.EventSource.EVENT_TYPE;

public class WarehouseBuilder {


    private WareHouse warehouse;
    private WarehouseProxy warehouseProxy;
    private EventSource eventSource;

    public WarehouseBuilder() {
        warehouse = new WareHouse();
        warehouseProxy = new WarehouseProxy();
        eventSource = new EventSource();

       /* EventFiler eventFiler = new EventFiler(eventSource).setHistoryFileName("");
        for (int i = 23; i < 26; i++) {
            PalettePlace palettePlace = new PalettePlace()
                    .setColumn(i)
                    .setRow(42)
                    .setId(String.format("place%dx%d", 42, i))
                    .setWareHouse(warehouse);
        }

        String yaml = eventFiler.loadHistory();
        if (yaml != null) {
            ArrayList<LinkedHashMap<String, String>> eventList = new Yamler().decodeList(yaml);
            this.appyEvents(eventList);
        }
        eventFiler.startEventLogging();*/
    }

    private void appyEvents(ArrayList<LinkedHashMap<String, String>> eventList) {
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
        event.put("LOT_ID", lotId);
        event.put("PRODUCT", productName);
        event.put("SIZE","  " +size);
        eventSource.append(event);

        if(oldSize == 0.0){
            this.warehouseProxy.addProductToShop(event);
        }

        return lot;
    }

    private WareHouseProduct getFromProducts(String name){

        String productId = name.replaceAll("\\W", "");

        for(WareHouseProduct product: warehouse.getProducts()){

            if(product.getId().equals(productId)){
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

        for(WareHouseProduct product: warehouse.getProducts()){
            for(Lot lot : product.getLots()){
                if(lot.getId().equals(lotId)){
                    return lot;
                }
            }
        }
        Lot lot = new Lot()
                .setId(lotId);
        return lot;
    }
}
