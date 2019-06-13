package HA_07;

import de.uniks.networkparser.graph.Cardinality;
import de.uniks.networkparser.graph.Clazz;
import de.uniks.networkparser.graph.DataType;
import org.junit.Test;
import org.sdmlib.models.classes.ClassModel;

public class ShopModel
{
    @Test
    public void ShopModel(){

        ClassModel model = new ClassModel("HA_07.Shop");

        Clazz shopClass = model.createClazz("Shop");

        Clazz shopCustomerClass = model.createClazz("ShopCustomer")
                .withAttribute("addresse", DataType.STRING)
                .withAttribute("name", DataType.STRING);

        Clazz shopProductClass = model.createClazz("ShopProduct")
                .withAttribute("id", DataType.STRING)
                .withAttribute("inStock",DataType.DOUBLE)
                .withAttribute("name", DataType.STRING)
                .withAttribute("price",DataType.DOUBLE);

        Clazz shopOrderClass = model.createClazz("ShopOrder")
                .withAttribute("id",DataType.STRING);

        shopClass.withBidirectional(shopProductClass,"products", Cardinality.MANY,"shop", Cardinality.ONE);
        shopClass.withBidirectional(shopCustomerClass, "customers",Cardinality.MANY,"shop",Cardinality.ONE);
        shopClass.withBidirectional(shopOrderClass,"orders",Cardinality.MANY,"shop",Cardinality.ONE);
        shopCustomerClass.withBidirectional(shopOrderClass,"orders", Cardinality.MANY,"shopCustomer", Cardinality.ONE);
        shopOrderClass.withBidirectional(shopProductClass,"products",Cardinality.MANY,"orders",Cardinality.MANY);

        model.generate("src/main/java");
    }
}
