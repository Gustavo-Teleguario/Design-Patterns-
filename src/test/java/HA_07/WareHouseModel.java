package HA_07;

import de.uniks.networkparser.graph.Cardinality;
import de.uniks.networkparser.graph.Clazz;
import de.uniks.networkparser.graph.DataType;
import org.junit.Test;
import org.sdmlib.models.classes.ClassModel;

public class WareHouseModel {

    @Test
    public void wareHouseModel() {

        ClassModel model = new ClassModel("HA_07.WareHouse");

        Clazz lotClass = model.createClazz("Lot")
                .withAttribute("id", DataType.STRING)
                .withAttribute("lotSize", DataType.DOUBLE);

        Clazz palettePlaceClass = model.createClazz("PalettePlace")
                .withAttribute("column", DataType.DOUBLE)
                .withAttribute("id", DataType.STRING)
                .withAttribute("row", DataType.DOUBLE);

        Clazz wareHouseClass = model.createClazz("WareHouse")
                .withAttribute("name", DataType.STRING);

        Clazz wareHouseOrderClass = model.createClazz("WareHouseOrder")
                .withAttribute("addresse", DataType.STRING)
                .withAttribute("id", DataType.STRING)
                .withAttribute("product", DataType.STRING);

        Clazz wareHouseProductClass = model.createClazz("WareHouseProduct")
                .withAttribute("name", DataType.STRING)
                .withAttribute("id", DataType.STRING);

        wareHouseClass.withBidirectional(wareHouseClass, "orders", Cardinality.MANY, "wareHouse", Cardinality.ONE);
        wareHouseClass.withBidirectional(wareHouseProductClass, "products", Cardinality.MANY, "wareHouse", Cardinality.ONE);
        wareHouseClass.withBidirectional(palettePlaceClass, "places", Cardinality.MANY, "wareHouse", Cardinality.ONE);

        wareHouseOrderClass.withBidirectional(wareHouseProductClass, "products", Cardinality.MANY, "orders", Cardinality.MANY);

        wareHouseProductClass.withBidirectional(lotClass, "lots", Cardinality.MANY, "wareHouseProduct", Cardinality.ONE);

        lotClass.withBidirectional(palettePlaceClass, "palettePlace", Cardinality.ONE, "lot", Cardinality.ONE);

        model.generate("src/main/java");

    }

}
