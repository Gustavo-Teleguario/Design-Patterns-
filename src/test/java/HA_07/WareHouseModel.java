package HA_07;

import org.fulib.Fulib;
import org.fulib.builder.ClassBuilder;
import org.fulib.builder.ClassModelBuilder;
import org.fulib.classmodel.ClassModel;
import org.junit.Test;


public class WareHouseModel {

    @Test
    public void wareHouseModel() {

        ClassModelBuilder model = Fulib.classModelBuilder("HA_07.WareHouse", "src/main/java");

        ClassBuilder lotClass = model.buildClass("Lot")
                .buildAttribute("id", model.STRING)
                .buildAttribute("lotSize", model.DOUBLE);

        ClassBuilder palettePlaceClass = model.buildClass("PalettePlace")
                .buildAttribute("column", model.DOUBLE)
                .buildAttribute("id", model.STRING)
                .buildAttribute("row", model.DOUBLE);

        ClassBuilder wareHouseClass = model.buildClass("WareHouse")
                .buildAttribute("name", model.STRING);

        ClassBuilder wareHouseOrderClass = model.buildClass("WareHouseOrder")
                .buildAttribute("addresse", model.STRING)
                .buildAttribute("id", model.STRING)
                .buildAttribute("product", model.STRING);

        ClassBuilder wareHouseProductClass = model.buildClass("WareHouseProduct")
                .buildAttribute("name", model.STRING)
                .buildAttribute("id", model.STRING);

        wareHouseClass.buildAssociation(wareHouseClass, "orders", model.MANY, "wareHouse", model.ONE);
        wareHouseClass.buildAssociation(wareHouseProductClass, "products", model.MANY, "wareHouse", model.ONE);
        wareHouseClass.buildAssociation(palettePlaceClass, "places", model.MANY, "wareHouse", model.ONE);

        wareHouseOrderClass.buildAssociation(wareHouseProductClass, "products", model.MANY, "orders", model.MANY);

        wareHouseProductClass.buildAssociation(lotClass, "lots", model.MANY, "wareHouseProduct", model.ONE);

        lotClass.buildAssociation(palettePlaceClass, "palettePlace", model.ONE, "lot", model.ONE);

       ClassModel classModel = model.getClassModel();
       Fulib.generator().generate(classModel);

    }

}
