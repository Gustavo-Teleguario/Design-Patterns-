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
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.Shop;

public  class ShopCustomer implements SendableEntity
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
      withoutOrders(this.getOrders().toArray(new ShopOrder[this.getOrders().size()]));
      setShop(null);
      firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_ADDRESSE = "addresse";
   
   private String addresse;

   public String getAddresse()
   {
      return this.addresse;
   }
   
   public void setAddresse(String value)
   {
      if ( ! EntityUtil.stringEquals(this.addresse, value)) {
      
         String oldValue = this.addresse;
         this.addresse = value;
         this.firePropertyChange(PROPERTY_ADDRESSE, oldValue, value);
      }
   }
   
   public ShopCustomer withAddresse(String value)
   {
      setAddresse(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getAddresse());
      result.append(" ").append(this.getName());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_NAME = "name";
   
   private String name;

   public String getName()
   {
      return this.name;
   }
   
   public void setName(String value)
   {
      if ( ! EntityUtil.stringEquals(this.name, value)) {
      
         String oldValue = this.name;
         this.name = value;
         this.firePropertyChange(PROPERTY_NAME, oldValue, value);
      }
   }
   
   public ShopCustomer withName(String value)
   {
      setName(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * ShopCustomer ----------------------------------- ShopOrder
    *              shopCustomer                   orders
    * </pre>
    */
   
   public static final String PROPERTY_ORDERS = "orders";

   private ShopOrderSet orders = null;
   
   public ShopOrderSet getOrders()
   {
      if (this.orders == null)
      {
         return ShopOrderSet.EMPTY_SET;
      }
   
      return this.orders;
   }

   public ShopCustomer withOrders(ShopOrder... value)
   {
      if(value==null){
         return this;
      }
      for (ShopOrder item : value)
      {
         if (item != null)
         {
            if (this.orders == null)
            {
               this.orders = new ShopOrderSet();
            }
            
            boolean changed = this.orders.add (item);

            if (changed)
            {
               item.withShopCustomer(this);
               firePropertyChange(PROPERTY_ORDERS, null, item);
            }
         }
      }
      return this;
   } 

   public ShopCustomer withoutOrders(ShopOrder... value)
   {
      for (ShopOrder item : value)
      {
         if ((this.orders != null) && (item != null))
         {
            if (this.orders.remove(item))
            {
               item.setShopCustomer(null);
               firePropertyChange(PROPERTY_ORDERS, item, null);
            }
         }
      }
      return this;
   }

   public ShopOrder createOrders()
   {
      ShopOrder value = new ShopOrder();
      withOrders(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * ShopCustomer ----------------------------------- Shop
    *              customers                   shop
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
            oldValue.withoutCustomers(this);
         }
         
         this.shop = value;
         
         if (value != null)
         {
            value.withCustomers(this);
         }
         
         firePropertyChange(PROPERTY_SHOP, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public ShopCustomer withShop(Shop value)
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
