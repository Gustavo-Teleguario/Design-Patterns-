package HA_07.Shop.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.Shop.ShopProduct;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.Shop.util.ShopOrderPO;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.util.ShopProductPO;
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.util.ShopPO;
import HA_07.Shop.Shop;

public class ShopProductPO extends PatternObject<ShopProductPO, ShopProduct>
{

    public ShopProductSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ShopProductSet matches = new ShopProductSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((ShopProduct) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ShopProductPO(){
      newInstance(null);
   }

   public ShopProductPO(ShopProduct... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public ShopProductPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public ShopProductPO createIdCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createIdCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_ID)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createIdAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_ID)
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
         return ((ShopProduct) getCurrentMatch()).getId();
      }
      return null;
   }
   
   public ShopProductPO withId(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopProduct) getCurrentMatch()).setId(value);
      }
      return this;
   }
   
   public ShopProductPO createInStockCondition(double value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_INSTOCK)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createInStockCondition(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_INSTOCK)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createInStockAssignment(double value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_INSTOCK)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public double getInStock()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopProduct) getCurrentMatch()).getInStock();
      }
      return 0;
   }
   
   public ShopProductPO withInStock(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopProduct) getCurrentMatch()).setInStock(value);
      }
      return this;
   }
   
   public ShopProductPO createNameCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createNameCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_NAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createNameAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_NAME)
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
         return ((ShopProduct) getCurrentMatch()).getName();
      }
      return null;
   }
   
   public ShopProductPO withName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopProduct) getCurrentMatch()).setName(value);
      }
      return this;
   }
   
   public ShopProductPO createPriceCondition(double value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_PRICE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createPriceCondition(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_PRICE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopProductPO createPriceAssignment(double value)
   {
      new AttributeConstraint()
      .withAttrName(ShopProduct.PROPERTY_PRICE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public double getPrice()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopProduct) getCurrentMatch()).getPrice();
      }
      return 0;
   }
   
   public ShopProductPO withPrice(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopProduct) getCurrentMatch()).setPrice(value);
      }
      return this;
   }
   
   public ShopOrderPO createOrdersPO()
   {
      ShopOrderPO result = new ShopOrderPO(new ShopOrder[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopProduct.PROPERTY_ORDERS, result);
      
      return result;
   }

   public ShopOrderPO createOrdersPO(String modifier)
   {
      ShopOrderPO result = new ShopOrderPO(new ShopOrder[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopProduct.PROPERTY_ORDERS, result);
      
      return result;
   }

   public ShopProductPO createOrdersLink(ShopOrderPO tgt)
   {
      return hasLinkConstraint(tgt, ShopProduct.PROPERTY_ORDERS);
   }

   public ShopProductPO createOrdersLink(ShopOrderPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopProduct.PROPERTY_ORDERS, modifier);
   }

   public ShopOrderSet getOrders()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopProduct) this.getCurrentMatch()).getOrders();
      }
      return null;
   }

   public ShopPO createShopPO()
   {
      ShopPO result = new ShopPO(new Shop[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopProduct.PROPERTY_SHOP, result);
      
      return result;
   }

   public ShopPO createShopPO(String modifier)
   {
      ShopPO result = new ShopPO(new Shop[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopProduct.PROPERTY_SHOP, result);
      
      return result;
   }

   public ShopProductPO createShopLink(ShopPO tgt)
   {
      return hasLinkConstraint(tgt, ShopProduct.PROPERTY_SHOP);
   }

   public ShopProductPO createShopLink(ShopPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopProduct.PROPERTY_SHOP, modifier);
   }

   public Shop getShop()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopProduct) this.getCurrentMatch()).getShop();
      }
      return null;
   }

}
