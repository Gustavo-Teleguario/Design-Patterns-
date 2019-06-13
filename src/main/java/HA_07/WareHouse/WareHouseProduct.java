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
import HA_07.WareHouse.util.LotSet;
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.util.WareHouseOrderSet;
import HA_07.WareHouse.WareHouseOrder;
import HA_07.WareHouse.WareHouse;

public  class WareHouseProduct implements SendableEntity
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
      withoutLots(this.getLots().toArray(new Lot[this.getLots().size()]));
      withoutOrders(this.getOrders().toArray(new WareHouseOrder[this.getOrders().size()]));
      setWareHouse(null);
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
   
   public WareHouseProduct withId(String value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
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
   
   public WareHouseProduct withName(String value)
   {
      setName(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * WareHouseProduct ----------------------------------- Lot
    *              wareHouseProduct                   lots
    * </pre>
    */
   
   public static final String PROPERTY_LOTS = "lots";

   private LotSet lots = null;
   
   public LotSet getLots()
   {
      if (this.lots == null)
      {
         return LotSet.EMPTY_SET;
      }
   
      return this.lots;
   }

   public WareHouseProduct withLots(Lot... value)
   {
      if(value==null){
         return this;
      }
      for (Lot item : value)
      {
         if (item != null)
         {
            if (this.lots == null)
            {
               this.lots = new LotSet();
            }
            
            boolean changed = this.lots.add (item);

            if (changed)
            {
               item.withWareHouseProduct(this);
               firePropertyChange(PROPERTY_LOTS, null, item);
            }
         }
      }
      return this;
   } 

   public WareHouseProduct withoutLots(Lot... value)
   {
      for (Lot item : value)
      {
         if ((this.lots != null) && (item != null))
         {
            if (this.lots.remove(item))
            {
               item.setWareHouseProduct(null);
               firePropertyChange(PROPERTY_LOTS, item, null);
            }
         }
      }
      return this;
   }

   public Lot createLots()
   {
      Lot value = new Lot();
      withLots(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       many
    * WareHouseProduct ----------------------------------- WareHouseOrder
    *              products                   orders
    * </pre>
    */
   
   public static final String PROPERTY_ORDERS = "orders";

   private WareHouseOrderSet orders = null;
   
   public WareHouseOrderSet getOrders()
   {
      if (this.orders == null)
      {
         return WareHouseOrderSet.EMPTY_SET;
      }
   
      return this.orders;
   }

   public WareHouseProduct withOrders(WareHouseOrder... value)
   {
      if(value==null){
         return this;
      }
      for (WareHouseOrder item : value)
      {
         if (item != null)
         {
            if (this.orders == null)
            {
               this.orders = new WareHouseOrderSet();
            }
            
            boolean changed = this.orders.add (item);

            if (changed)
            {
               item.withProducts(this);
               firePropertyChange(PROPERTY_ORDERS, null, item);
            }
         }
      }
      return this;
   } 

   public WareHouseProduct withoutOrders(WareHouseOrder... value)
   {
      for (WareHouseOrder item : value)
      {
         if ((this.orders != null) && (item != null))
         {
            if (this.orders.remove(item))
            {
               item.withoutProducts(this);
               firePropertyChange(PROPERTY_ORDERS, item, null);
            }
         }
      }
      return this;
   }

   public WareHouseOrder createOrders()
   {
      WareHouseOrder value = new WareHouseOrder();
      withOrders(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * WareHouseProduct ----------------------------------- WareHouse
    *              products                   wareHouse
    * </pre>
    */
   
   public static final String PROPERTY_WAREHOUSE = "wareHouse";

   private WareHouse wareHouse = null;

   public WareHouse getWareHouse()
   {
      return this.wareHouse;
   }

   public boolean setWareHouse(WareHouse value)
   {
      boolean changed = false;
      
      if (this.wareHouse != value)
      {
         WareHouse oldValue = this.wareHouse;
         
         if (this.wareHouse != null)
         {
            this.wareHouse = null;
            oldValue.withoutProducts(this);
         }
         
         this.wareHouse = value;
         
         if (value != null)
         {
            value.withProducts(this);
         }
         
         firePropertyChange(PROPERTY_WAREHOUSE, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public WareHouseProduct withWareHouse(WareHouse value)
   {
      setWareHouse(value);
      return this;
   } 

   public WareHouse createWareHouse()
   {
      WareHouse value = new WareHouse();
      withWareHouse(value);
      return value;
   } 
}
