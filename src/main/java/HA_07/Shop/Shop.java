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
import HA_07.Shop.util.ShopProductSet;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.util.ShopCustomerSet;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.ShopOrder;

public  class Shop implements SendableEntity
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
      withoutProducts(this.getProducts().toArray(new ShopProduct[this.getProducts().size()]));
      withoutCustomers(this.getCustomers().toArray(new ShopCustomer[this.getCustomers().size()]));
      withoutOrders(this.getOrders().toArray(new ShopOrder[this.getOrders().size()]));
      firePropertyChange("REMOVE_YOU", this, null);
   }

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Shop ----------------------------------- ShopProduct
    *              shop                   products
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

   public Shop withProducts(ShopProduct... value)
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
               item.withShop(this);
               firePropertyChange(PROPERTY_PRODUCTS, null, item);
            }
         }
      }
      return this;
   } 

   public Shop withoutProducts(ShopProduct... value)
   {
      for (ShopProduct item : value)
      {
         if ((this.products != null) && (item != null))
         {
            if (this.products.remove(item))
            {
               item.setShop(null);
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
    *              one                       many
    * Shop ----------------------------------- ShopCustomer
    *              shop                   customers
    * </pre>
    */
   
   public static final String PROPERTY_CUSTOMERS = "customers";

   private ShopCustomerSet customers = null;
   
   public ShopCustomerSet getCustomers()
   {
      if (this.customers == null)
      {
         return ShopCustomerSet.EMPTY_SET;
      }
   
      return this.customers;
   }

   public Shop withCustomers(ShopCustomer... value)
   {
      if(value==null){
         return this;
      }
      for (ShopCustomer item : value)
      {
         if (item != null)
         {
            if (this.customers == null)
            {
               this.customers = new ShopCustomerSet();
            }
            
            boolean changed = this.customers.add (item);

            if (changed)
            {
               item.withShop(this);
               firePropertyChange(PROPERTY_CUSTOMERS, null, item);
            }
         }
      }
      return this;
   } 

   public Shop withoutCustomers(ShopCustomer... value)
   {
      for (ShopCustomer item : value)
      {
         if ((this.customers != null) && (item != null))
         {
            if (this.customers.remove(item))
            {
               item.setShop(null);
               firePropertyChange(PROPERTY_CUSTOMERS, item, null);
            }
         }
      }
      return this;
   }

   public ShopCustomer createCustomers()
   {
      ShopCustomer value = new ShopCustomer();
      withCustomers(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Shop ----------------------------------- ShopOrder
    *              shop                   orders
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

   public Shop withOrders(ShopOrder... value)
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
               item.withShop(this);
               firePropertyChange(PROPERTY_ORDERS, null, item);
            }
         }
      }
      return this;
   } 

   public Shop withoutOrders(ShopOrder... value)
   {
      for (ShopOrder item : value)
      {
         if ((this.orders != null) && (item != null))
         {
            if (this.orders.remove(item))
            {
               item.setShop(null);
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
}
