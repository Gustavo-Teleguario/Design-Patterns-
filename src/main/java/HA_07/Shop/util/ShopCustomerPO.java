package HA_07.Shop.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.Shop.ShopCustomer;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.Shop.util.ShopOrderPO;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.util.ShopCustomerPO;
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.util.ShopPO;
import HA_07.Shop.Shop;

public class ShopCustomerPO extends PatternObject<ShopCustomerPO, ShopCustomer>
{

    public ShopCustomerSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ShopCustomerSet matches = new ShopCustomerSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((ShopCustomer) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ShopCustomerPO(){
      newInstance(null);
   }

   public ShopCustomerPO(ShopCustomer... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public ShopCustomerPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public ShopCustomerPO createAddresseCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopCustomer.PROPERTY_ADDRESSE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopCustomerPO createAddresseCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopCustomer.PROPERTY_ADDRESSE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopCustomerPO createAddresseAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopCustomer.PROPERTY_ADDRESSE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public String getAddresse()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopCustomer) getCurrentMatch()).getAddresse();
      }
      return null;
   }
   
   public ShopCustomerPO withAddresse(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopCustomer) getCurrentMatch()).setAddresse(value);
      }
      return this;
   }
   
   public ShopCustomerPO createNameCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopCustomer.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopCustomerPO createNameCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopCustomer.PROPERTY_NAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopCustomerPO createNameAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopCustomer.PROPERTY_NAME)
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
         return ((ShopCustomer) getCurrentMatch()).getName();
      }
      return null;
   }
   
   public ShopCustomerPO withName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopCustomer) getCurrentMatch()).setName(value);
      }
      return this;
   }
   
   public ShopOrderPO createOrdersPO()
   {
      ShopOrderPO result = new ShopOrderPO(new ShopOrder[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopCustomer.PROPERTY_ORDERS, result);
      
      return result;
   }

   public ShopOrderPO createOrdersPO(String modifier)
   {
      ShopOrderPO result = new ShopOrderPO(new ShopOrder[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopCustomer.PROPERTY_ORDERS, result);
      
      return result;
   }

   public ShopCustomerPO createOrdersLink(ShopOrderPO tgt)
   {
      return hasLinkConstraint(tgt, ShopCustomer.PROPERTY_ORDERS);
   }

   public ShopCustomerPO createOrdersLink(ShopOrderPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopCustomer.PROPERTY_ORDERS, modifier);
   }

   public ShopOrderSet getOrders()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopCustomer) this.getCurrentMatch()).getOrders();
      }
      return null;
   }

   public ShopPO createShopPO()
   {
      ShopPO result = new ShopPO(new Shop[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopCustomer.PROPERTY_SHOP, result);
      
      return result;
   }

   public ShopPO createShopPO(String modifier)
   {
      ShopPO result = new ShopPO(new Shop[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopCustomer.PROPERTY_SHOP, result);
      
      return result;
   }

   public ShopCustomerPO createShopLink(ShopPO tgt)
   {
      return hasLinkConstraint(tgt, ShopCustomer.PROPERTY_SHOP);
   }

   public ShopCustomerPO createShopLink(ShopPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopCustomer.PROPERTY_SHOP, modifier);
   }

   public Shop getShop()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopCustomer) this.getCurrentMatch()).getShop();
      }
      return null;
   }

}
