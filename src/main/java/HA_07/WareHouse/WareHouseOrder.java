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
   
package HA_07.WareHouse;

import de.uniks.networkparser.interfaces.SendableEntity;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import de.uniks.networkparser.EntityUtil;
import HA_07.WareHouse.util.WareHouseProductSet;
import HA_07.WareHouse.WareHouseProduct;

public  class WareHouseOrder implements SendableEntity
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
      withoutProducts(this.getProducts().toArray(new WareHouseProduct[this.getProducts().size()]));
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
   
   public WareHouseOrder withAddresse(String value)
   {
      setAddresse(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getAddresse());
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getProduct());
      return result.substring(1);
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
   
   public WareHouseOrder withId(String value)
   {
      setId(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_PRODUCT = "product";
   
   private String product;

   public String getProduct()
   {
      return this.product;
   }
   
   public void setProduct(String value)
   {
      if ( ! EntityUtil.stringEquals(this.product, value)) {
      
         String oldValue = this.product;
         this.product = value;
         this.firePropertyChange(PROPERTY_PRODUCT, oldValue, value);
      }
   }
   
   public WareHouseOrder withProduct(String value)
   {
      setProduct(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       many
    * WareHouseOrder ----------------------------------- WareHouseProduct
    *              orders                   products
    * </pre>
    */
   
   public static final String PROPERTY_PRODUCTS = "products";

   private WareHouseProductSet products = null;
   
   public WareHouseProductSet getProducts()
   {
      if (this.products == null)
      {
         return WareHouseProductSet.EMPTY_SET;
      }
   
      return this.products;
   }

   public WareHouseOrder withProducts(WareHouseProduct... value)
   {
      if(value==null){
         return this;
      }
      for (WareHouseProduct item : value)
      {
         if (item != null)
         {
            if (this.products == null)
            {
               this.products = new WareHouseProductSet();
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

   public WareHouseOrder withoutProducts(WareHouseProduct... value)
   {
      for (WareHouseProduct item : value)
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

   public WareHouseProduct createProducts()
   {
      WareHouseProduct value = new WareHouseProduct();
      withProducts(value);
      return value;
   } 
}
