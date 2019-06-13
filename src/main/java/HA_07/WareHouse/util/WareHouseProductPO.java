package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.WareHouse.WareHouseProduct;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.WareHouse.util.LotPO;
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.util.WareHouseProductPO;
import HA_07.WareHouse.util.LotSet;
import HA_07.WareHouse.util.WareHouseOrderPO;
import HA_07.WareHouse.WareHouseOrder;
import HA_07.WareHouse.util.WareHouseOrderSet;
import HA_07.WareHouse.util.WareHousePO;
import HA_07.WareHouse.WareHouse;

public class WareHouseProductPO extends PatternObject<WareHouseProductPO, WareHouseProduct>
{

    public WareHouseProductSet allMatches()
   {
      this.setDoAllMatches(true);
      
      WareHouseProductSet matches = new WareHouseProductSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((WareHouseProduct) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public WareHouseProductPO(){
      newInstance(null);
   }

   public WareHouseProductPO(WareHouseProduct... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public WareHouseProductPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public WareHouseProductPO createIdCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseProduct.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseProductPO createIdCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseProduct.PROPERTY_ID)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseProductPO createIdAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseProduct.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public String getId()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseProduct) getCurrentMatch()).getId();
      }
      return null;
   }
   
   public WareHouseProductPO withId(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((WareHouseProduct) getCurrentMatch()).setId(value);
      }
      return this;
   }
   
   public WareHouseProductPO createNameCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseProduct.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseProductPO createNameCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseProduct.PROPERTY_NAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseProductPO createNameAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseProduct.PROPERTY_NAME)
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
         return ((WareHouseProduct) getCurrentMatch()).getName();
      }
      return null;
   }
   
   public WareHouseProductPO withName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((WareHouseProduct) getCurrentMatch()).setName(value);
      }
      return this;
   }
   
   public LotPO createLotsPO()
   {
      LotPO result = new LotPO(new Lot[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouseProduct.PROPERTY_LOTS, result);
      
      return result;
   }

   public LotPO createLotsPO(String modifier)
   {
      LotPO result = new LotPO(new Lot[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouseProduct.PROPERTY_LOTS, result);
      
      return result;
   }

   public WareHouseProductPO createLotsLink(LotPO tgt)
   {
      return hasLinkConstraint(tgt, WareHouseProduct.PROPERTY_LOTS);
   }

   public WareHouseProductPO createLotsLink(LotPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouseProduct.PROPERTY_LOTS, modifier);
   }

   public LotSet getLots()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseProduct) this.getCurrentMatch()).getLots();
      }
      return null;
   }

   public WareHouseOrderPO createOrdersPO()
   {
      WareHouseOrderPO result = new WareHouseOrderPO(new WareHouseOrder[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouseProduct.PROPERTY_ORDERS, result);
      
      return result;
   }

   public WareHouseOrderPO createOrdersPO(String modifier)
   {
      WareHouseOrderPO result = new WareHouseOrderPO(new WareHouseOrder[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouseProduct.PROPERTY_ORDERS, result);
      
      return result;
   }

   public WareHouseProductPO createOrdersLink(WareHouseOrderPO tgt)
   {
      return hasLinkConstraint(tgt, WareHouseProduct.PROPERTY_ORDERS);
   }

   public WareHouseProductPO createOrdersLink(WareHouseOrderPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouseProduct.PROPERTY_ORDERS, modifier);
   }

   public WareHouseOrderSet getOrders()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseProduct) this.getCurrentMatch()).getOrders();
      }
      return null;
   }

   public WareHousePO createWareHousePO()
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouseProduct.PROPERTY_WAREHOUSE, result);
      
      return result;
   }

   public WareHousePO createWareHousePO(String modifier)
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouseProduct.PROPERTY_WAREHOUSE, result);
      
      return result;
   }

   public WareHouseProductPO createWareHouseLink(WareHousePO tgt)
   {
      return hasLinkConstraint(tgt, WareHouseProduct.PROPERTY_WAREHOUSE);
   }

   public WareHouseProductPO createWareHouseLink(WareHousePO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouseProduct.PROPERTY_WAREHOUSE, modifier);
   }

   public WareHouse getWareHouse()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseProduct) this.getCurrentMatch()).getWareHouse();
      }
      return null;
   }

}
