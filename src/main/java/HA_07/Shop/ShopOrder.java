/*
   Copyright (c) 2019 Qumatz
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package HA_07.Shop;

import de.uniks.networkparser.interfaces.SendableEntity;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.util.ShopProductSet;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.Shop;

public  class ShopOrder implements SendableEntity
{

   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = null;
   
   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null) {
   		listeners.firePropertyChange(propertyName, oldValue, newValue);
   		return true;
   	}
   	return false;
   }
   
   public boolean addPropertyChangeListener(PropertyChangeListener listener) 
   {
   	if (listeners == null) {
   		listeners = new PropertyChangeSupport(this);
   	}
   	listeners.addPropertyChangeListener(listener);
   	return true;
   }
   
   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
   	if (listeners == null) {
   		listeners = new PropertyChangeSupport(this);
   	}
   	listeners.addPropertyChangeListener(propertyName, listener);
   	return true;
   }
   
   public boolean removePropertyChangeListener(PropertyChangeListener listener) {
   	if (listeners != null) {
   		listeners.removePropertyChangeListener(listener);
   	}
   	return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener) {
   	if (listeners != null) {
   		listeners.removePropertyChangeListener(propertyName, listener);
   	}
   	return true;
   }

   
   //==========================================================================
   
   
   public void removeYou()
   {
      setShopCustomer(null);
      withoutProducts(this.getProducts().toArray(new ShopProduct[this.getProducts().size()]));
      setShop(null);
      firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_ID = "id";
   
   private String id;

   public String getId()
   {
      return this.id;
   }
   
   public void setId(String value)
   {
      if ( ! EntityUtil.stringEquals(this.id, value)) {
      
         String oldValue = this.id;
         this.id = value;
         this.firePropertyChange(PROPERTY_ID, oldValue, value);
      }
   }
   
   public ShopOrder withId(String value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
      return result.substring(1);
   }


   
   /********************************************************************
    * <pre>
    *              many                       one
    * ShopOrder ----------------------------------- ShopCustomer
    *              orders                   shopCustomer
    * </pre>
    */
   
   public static final String PROPERTY_SHOPCUSTOMER = "shopCustomer";

   private ShopCustomer shopCustomer = null;

   public ShopCustomer getShopCustomer()
   {
      return this.shopCustomer;
   }

   public boolean setShopCustomer(ShopCustomer value)
   {
      boolean changed = false;
      
      if (this.shopCustomer != value)
      {
         ShopCustomer oldValue = this.shopCustomer;
         
         if (this.shopCustomer != null)
         {
            this.shopCustomer = null;
            oldValue.withoutOrders(this);
         }
         
         this.shopCustomer = value;
         
         if (value != null)
         {
            value.withOrders(this);
         }
         
         firePropertyChange(PROPERTY_SHOPCUSTOMER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public ShopOrder withShopCustomer(ShopCustomer value)
   {
      setShopCustomer(value);
      return this;
   } 

   public ShopCustomer createShopCustomer()
   {
      ShopCustomer value = new ShopCustomer();
      withShopCustomer(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       many
    * ShopOrder ----------------------------------- ShopProduct
    *              orders                   products
    * </pre>
    */
   
   public static final String PROPERTY_PRODUCTS = "products";

   private ShopProductSet products = null;
   
   public ShopProductSet getProducts()
   {
      if (this.products == null)
      {
         return ShopProductSet.EMPTY_SET;
      }
   
      return this.products;
   }

   public ShopOrder withProducts(ShopProduct... value)
   {
      if(value==null){
         return this;
      }
      for (ShopProduct item : value)
      {
         if (item != null)
         {
            if (this.products == null)
            {
               this.products = new ShopProductSet();
            }
            
            boolean changed = this.products.add (item);

            if (changed)
            {
               item.withOrders(this);
               firePropertyChange(PROPERTY_PRODUCTS, null, item);
            }
         }
      }
      return this;
   } 

   public ShopOrder withoutProducts(ShopProduct... value)
   {
      for (ShopProduct item : value)
      {
         if ((this.products != null) && (item != null))
         {
            if (this.products.remove(item))
            {
               item.withoutOrders(this);
               firePropertyChange(PROPERTY_PRODUCTS, item, null);
            }
         }
      }
      return this;
   }

   public ShopProduct createProducts()
   {
      ShopProduct value = new ShopProduct();
      withProducts(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * ShopOrder ----------------------------------- Shop
    *              orders                   shop
    * </pre>
    */
   
   public static final String PROPERTY_SHOP = "shop";

   private Shop shop = null;

   public Shop getShop()
   {
      return this.shop;
   }

   public boolean setShop(Shop value)
   {
      boolean changed = false;
      
      if (this.shop != value)
      {
         Shop oldValue = this.shop;
         
         if (this.shop != null)
         {
            this.shop = null;
            oldValue.withoutOrders(this);
         }
         
         this.shop = value;
         
         if (value != null)
         {
            value.withOrders(this);
         }
         
         firePropertyChange(PROPERTY_SHOP, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public ShopOrder withShop(Shop value)
   {
      setShop(value);
      return this;
   } 

   public Shop createShop()
   {
      Shop value = new Shop();
      withShop(value);
      return value;
   } 
}
