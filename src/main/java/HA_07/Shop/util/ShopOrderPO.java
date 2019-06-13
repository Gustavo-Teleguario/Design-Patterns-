package HA_07.Shop.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.Shop.ShopOrder;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.Shop.util.ShopCustomerPO;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.util.ShopOrderPO;
import HA_07.Shop.util.ShopProductPO;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.util.ShopProductSet;
import HA_07.Shop.util.ShopPO;
import HA_07.Shop.Shop;

public class ShopOrderPO extends PatternObject<ShopOrderPO, ShopOrder>
{

    public ShopOrderSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ShopOrderSet matches = new ShopOrderSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((ShopOrder) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ShopOrderPO(){
      newInstance(null);
   }

   public ShopOrderPO(ShopOrder... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public ShopOrderPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public ShopOrderPO createIdCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopOrder.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopOrderPO createIdCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(ShopOrder.PROPERTY_ID)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public ShopOrderPO createIdAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(ShopOrder.PROPERTY_ID)
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
         return ((ShopOrder) getCurrentMatch()).getId();
      }
      return null;
   }
   
   public ShopOrderPO withId(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((ShopOrder) getCurrentMatch()).setId(value);
      }
      return this;
   }
   
   public ShopCustomerPO createShopCustomerPO()
   {
      ShopCustomerPO result = new ShopCustomerPO(new ShopCustomer[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopOrder.PROPERTY_SHOPCUSTOMER, result);
      
      return result;
   }

   public ShopCustomerPO createShopCustomerPO(String modifier)
   {
      ShopCustomerPO result = new ShopCustomerPO(new ShopCustomer[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopOrder.PROPERTY_SHOPCUSTOMER, result);
      
      return result;
   }

   public ShopOrderPO createShopCustomerLink(ShopCustomerPO tgt)
   {
      return hasLinkConstraint(tgt, ShopOrder.PROPERTY_SHOPCUSTOMER);
   }

   public ShopOrderPO createShopCustomerLink(ShopCustomerPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopOrder.PROPERTY_SHOPCUSTOMER, modifier);
   }

   public ShopCustomer getShopCustomer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopOrder) this.getCurrentMatch()).getShopCustomer();
      }
      return null;
   }

   public ShopProductPO createProductsPO()
   {
      ShopProductPO result = new ShopProductPO(new ShopProduct[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopOrder.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public ShopProductPO createProductsPO(String modifier)
   {
      ShopProductPO result = new ShopProductPO(new ShopProduct[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopOrder.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public ShopOrderPO createProductsLink(ShopProductPO tgt)
   {
      return hasLinkConstraint(tgt, ShopOrder.PROPERTY_PRODUCTS);
   }

   public ShopOrderPO createProductsLink(ShopProductPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopOrder.PROPERTY_PRODUCTS, modifier);
   }

   public ShopProductSet getProducts()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopOrder) this.getCurrentMatch()).getProducts();
      }
      return null;
   }

   public ShopPO createShopPO()
   {
      ShopPO result = new ShopPO(new Shop[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(ShopOrder.PROPERTY_SHOP, result);
      
      return result;
   }

   public ShopPO createShopPO(String modifier)
   {
      ShopPO result = new ShopPO(new Shop[]{});
      
      result.setModifier(modifier);
      super.hasLink(ShopOrder.PROPERTY_SHOP, result);
      
      return result;
   }

   public ShopOrderPO createShopLink(ShopPO tgt)
   {
      return hasLinkConstraint(tgt, ShopOrder.PROPERTY_SHOP);
   }

   public ShopOrderPO createShopLink(ShopPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, ShopOrder.PROPERTY_SHOP, modifier);
   }

   public Shop getShop()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((ShopOrder) this.getCurrentMatch()).getShop();
      }
      return null;
   }

}
