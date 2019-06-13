package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.WareHouse.WareHouse;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.WareHouse.util.WareHousePO;
import HA_07.WareHouse.util.WareHouseSet;
import HA_07.WareHouse.util.WareHouseProductPO;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.util.WareHouseProductSet;
import HA_07.WareHouse.util.PalettePlacePO;
import HA_07.WareHouse.PalettePlace;
import HA_07.WareHouse.util.PalettePlaceSet;

public class WareHousePO extends PatternObject<WareHousePO, WareHouse>
{

    public WareHouseSet allMatches()
   {
      this.setDoAllMatches(true);
      
      WareHouseSet matches = new WareHouseSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((WareHouse) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public WareHousePO(){
      newInstance(null);
   }

   public WareHousePO(WareHouse... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public WareHousePO(String modifier)
   {
      this.setModifier(modifier);
   }
   public WareHousePO createNameCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouse.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHousePO createNameCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(WareHouse.PROPERTY_NAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHousePO createNameAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouse.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public String getName()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouse) getCurrentMatch()).getName();
      }
      return null;
   }
   
   public WareHousePO withName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((WareHouse) getCurrentMatch()).setName(value);
      }
      return this;
   }
   
   public WareHousePO createWareHousePO()
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouse.PROPERTY_WAREHOUSE, result);
      
      return result;
   }

   public WareHousePO createWareHousePO(String modifier)
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouse.PROPERTY_WAREHOUSE, result);
      
      return result;
   }

   public WareHousePO createWareHouseLink(WareHousePO tgt)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_WAREHOUSE);
   }

   public WareHousePO createWareHouseLink(WareHousePO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_WAREHOUSE, modifier);
   }

   public WareHouse getWareHouse()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouse) this.getCurrentMatch()).getWareHouse();
      }
      return null;
   }

   public WareHousePO createOrdersPO()
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouse.PROPERTY_ORDERS, result);
      
      return result;
   }

   public WareHousePO createOrdersPO(String modifier)
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouse.PROPERTY_ORDERS, result);
      
      return result;
   }

   public WareHousePO createOrdersLink(WareHousePO tgt)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_ORDERS);
   }

   public WareHousePO createOrdersLink(WareHousePO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_ORDERS, modifier);
   }

   public WareHouseSet getOrders()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouse) this.getCurrentMatch()).getOrders();
      }
      return null;
   }

   public WareHouseProductPO createProductsPO()
   {
      WareHouseProductPO result = new WareHouseProductPO(new WareHouseProduct[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouse.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public WareHouseProductPO createProductsPO(String modifier)
   {
      WareHouseProductPO result = new WareHouseProductPO(new WareHouseProduct[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouse.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public WareHousePO createProductsLink(WareHouseProductPO tgt)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_PRODUCTS);
   }

   public WareHousePO createProductsLink(WareHouseProductPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_PRODUCTS, modifier);
   }

   public WareHouseProductSet getProducts()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouse) this.getCurrentMatch()).getProducts();
      }
      return null;
   }

   public PalettePlacePO createPlacesPO()
   {
      PalettePlacePO result = new PalettePlacePO(new PalettePlace[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouse.PROPERTY_PLACES, result);
      
      return result;
   }

   public PalettePlacePO createPlacesPO(String modifier)
   {
      PalettePlacePO result = new PalettePlacePO(new PalettePlace[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouse.PROPERTY_PLACES, result);
      
      return result;
   }

   public WareHousePO createPlacesLink(PalettePlacePO tgt)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_PLACES);
   }

   public WareHousePO createPlacesLink(PalettePlacePO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouse.PROPERTY_PLACES, modifier);
   }

   public PalettePlaceSet getPlaces()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouse) this.getCurrentMatch()).getPlaces();
      }
      return null;
   }

}
