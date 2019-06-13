package HA_07.Shop.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.Shop.Shop;
import HA_07.Shop.util.ShopProductPO;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.util.ShopPO;
import HA_07.Shop.util.ShopProductSet;
import HA_07.Shop.util.ShopCustomerPO;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.util.ShopCustomerSet;
import HA_07.Shop.util.ShopOrderPO;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.util.ShopOrderSet;

public class ShopPO extends PatternObject<ShopPO, Shop>
{

    public ShopSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ShopSet matches = new ShopSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Shop) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ShopPO(){
      newInstance(null);
   }

   public ShopPO(Shop... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public ShopPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public ShopProductPO createProductsPO()
   {
      ShopProductPO result = new ShopProductPO(new ShopProduct[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Shop.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public ShopProductPO createProductsPO(String modifier)
   {
      ShopProductPO result = new ShopProductPO(new ShopProduct[]{});
      
      result.setModifier(modifier);
      super.hasLink(Shop.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public ShopPO createProductsLink(ShopProductPO tgt)
   {
      return hasLinkConstraint(tgt, Shop.PROPERTY_PRODUCTS);
   }

   public ShopPO createProductsLink(ShopProductPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, Shop.PROPERTY_PRODUCTS, modifier);
   }

   public ShopProductSet getProducts()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Shop) this.getCurrentMatch()).getProducts();
      }
      return null;
   }

   public ShopCustomerPO createCustomersPO()
   {
      ShopCustomerPO result = new ShopCustomerPO(new ShopCustomer[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Shop.PROPERTY_CUSTOMERS, result);
      
      return result;
   }

   public ShopCustomerPO createCustomersPO(String modifier)
   {
      ShopCustomerPO result = new ShopCustomerPO(new ShopCustomer[]{});
      
      result.setModifier(modifier);
      super.hasLink(Shop.PROPERTY_CUSTOMERS, result);
      
      return result;
   }

   public ShopPO createCustomersLink(ShopCustomerPO tgt)
   {
      return hasLinkConstraint(tgt, Shop.PROPERTY_CUSTOMERS);
   }

   public ShopPO createCustomersLink(ShopCustomerPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, Shop.PROPERTY_CUSTOMERS, modifier);
   }

   public ShopCustomerSet getCustomers()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Shop) this.getCurrentMatch()).getCustomers();
      }
      return null;
   }

   public ShopOrderPO createOrdersPO()
   {
      ShopOrderPO result = new ShopOrderPO(new ShopOrder[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Shop.PROPERTY_ORDERS, result);
      
      return result;
   }

   public ShopOrderPO createOrdersPO(String modifier)
   {
      ShopOrderPO result = new ShopOrderPO(new ShopOrder[]{});
      
      result.setModifier(modifier);
      super.hasLink(Shop.PROPERTY_ORDERS, result);
      
      return result;
   }

   public ShopPO createOrdersLink(ShopOrderPO tgt)
   {
      return hasLinkConstraint(tgt, Shop.PROPERTY_ORDERS);
   }

   public ShopPO createOrdersLink(ShopOrderPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, Shop.PROPERTY_ORDERS, modifier);
   }

   public ShopOrderSet getOrders()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Shop) this.getCurrentMatch()).getOrders();
      }
      return null;
   }

}
