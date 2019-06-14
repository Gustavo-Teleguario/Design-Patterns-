package HA_07;


import HA_02.FulibProject;
import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.fulib.classmodel.ClassModel;
import org.junit.Test;

public class ShopModel
{
    @Test
    public void ShopModel(){

        ClassModelBuilder model = Fulib.classModelBuilder("HA_07.Shop", "src/main/java");

        ClassBuilder shopClass = model.buildClass("Shop");

        ClassBuilder shopCustomerClass = model.buildClass("ShopCustomer")
                .buildAttribute("addresse", model.STRING)
                .buildAttribute("name", model.STRING);

        ClassBuilder shopProductClass = model.buildClass("ShopProduct")
                .buildAttribute("id", model.STRING)
                .buildAttribute("inStock",model.DOUBLE)
                .buildAttribute("name", model.STRING)
                .buildAttribute("price",model.DOUBLE);

        ClassBuilder shopOrderClass = model.buildClass("ShopOrder")
                .buildAttribute("id",model.STRING);

        shopClass.buildAssociation(shopProductClass,"products", model.MANY,"shop", model.ONE);
        shopClass.buildAssociation(shopCustomerClass, "customers",model.MANY,"shop",model.ONE);
        shopClass.buildAssociation(shopOrderClass,"orders",model.MANY,"shop",model.ONE);
        shopCustomerClass.buildAssociation(shopOrderClass,"orders", model.MANY,"shopCustomer", model.ONE);
        shopOrderClass.buildAssociation(shopProductClass,"products",model.MANY,"orders",model.MANY);

       ClassModel classModel = model.getClassModel();
       Fulib.generator().generate(classModel);
    }
}
