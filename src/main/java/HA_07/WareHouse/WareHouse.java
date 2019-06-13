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
import HA_07.WareHouse.util.WareHouseSet;
import HA_07.WareHouse.util.WareHouseProductSet;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.util.PalettePlaceSet;
import HA_07.WareHouse.PalettePlace;

public  class WareHouse implements SendableEntity
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
      setWareHouse(null);
      withoutOrders(this.getOrders().toArray(new WareHouse[this.getOrders().size()]));
      withoutProducts(this.getProducts().toArray(new WareHouseProduct[this.getProducts().size()]));
      withoutPlaces(this.getPlaces().toArray(new PalettePlace[this.getPlaces().size()]));
      firePropertyChange("REMOVE_YOU", this, null);
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
   
   public WareHouse withName(String value)
   {
      setName(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getName());
      return result.substring(1);
   }


   
   /********************************************************************
    * <pre>
    *              many                       one
    * WareHouse ----------------------------------- WareHouse
    *              orders                   wareHouse
    * </pre>
    */
   
   public static final String PROPERTY_WAREHOUSE = "wareHouse";

   private WareHouse wareHouse = null;

   public WareHouse getWareHouse()
   {
      return this.wareHouse;
   }
   public WareHouseSet getWareHouseTransitive()
   {
      WareHouseSet result = new WareHouseSet().with(this);
      return result.getWareHouseTransitive();
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
            oldValue.withoutOrders(this);
         }
         
         this.wareHouse = value;
         
         if (value != null)
         {
            value.withOrders(this);
         }
         
         firePropertyChange(PROPERTY_WAREHOUSE, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public WareHouse withWareHouse(WareHouse value)
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

   
   /********************************************************************
    * <pre>
    *              one                       many
    * WareHouse ----------------------------------- WareHouse
    *              wareHouse                   orders
    * </pre>
    */
   
   public static final String PROPERTY_ORDERS = "orders";

   private WareHouseSet orders = null;
   
   public WareHouseSet getOrders()
   {
      if (this.orders == null)
      {
         return WareHouseSet.EMPTY_SET;
      }
   
      return this.orders;
   }
   public WareHouseSet getOrdersTransitive()
   {
      WareHouseSet result = new WareHouseSet().with(this);
      return result.getOrdersTransitive();
   }


   public WareHouse withOrders(WareHouse... value)
   {
      if(value==null){
         return this;
      }
      for (WareHouse item : value)
      {
         if (item != null)
         {
            if (this.orders == null)
            {
               this.orders = new WareHouseSet();
            }
            
            boolean changed = this.orders.add (item);

            if (changed)
            {
               item.withWareHouse(this);
               firePropertyChange(PROPERTY_ORDERS, null, item);
            }
         }
      }
      return this;
   } 

   public WareHouse withoutOrders(WareHouse... value)
   {
      for (WareHouse item : value)
      {
         if ((this.orders != null) && (item != null))
         {
            if (this.orders.remove(item))
            {
               item.setWareHouse(null);
               firePropertyChange(PROPERTY_ORDERS, item, null);
            }
         }
      }
      return this;
   }

   public WareHouse createOrders()
   {
      WareHouse value = new WareHouse();
      withOrders(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * WareHouse ----------------------------------- WareHouseProduct
    *              wareHouse                   products
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

   public WareHouse withProducts(WareHouseProduct... value)
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
               item.withWareHouse(this);
               firePropertyChange(PROPERTY_PRODUCTS, null, item);
            }
         }
      }
      return this;
   } 

   public WareHouse withoutProducts(WareHouseProduct... value)
   {
      for (WareHouseProduct item : value)
      {
         if ((this.products != null) && (item != null))
         {
            if (this.products.remove(item))
            {
               item.setWareHouse(null);
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

   
   /********************************************************************
    * <pre>
    *              one                       many
    * WareHouse ----------------------------------- PalettePlace
    *              wareHouse                   places
    * </pre>
    */
   
   public static final String PROPERTY_PLACES = "places";

   private PalettePlaceSet places = null;
   
   public PalettePlaceSet getPlaces()
   {
      if (this.places == null)
      {
         return PalettePlaceSet.EMPTY_SET;
      }
   
      return this.places;
   }

   public WareHouse withPlaces(PalettePlace... value)
   {
      if(value==null){
         return this;
      }
      for (PalettePlace item : value)
      {
         if (item != null)
         {
            if (this.places == null)
            {
               this.places = new PalettePlaceSet();
            }
            
            boolean changed = this.places.add (item);

            if (changed)
            {
               item.withWareHouse(this);
               firePropertyChange(PROPERTY_PLACES, null, item);
            }
         }
      }
      return this;
   } 

   public WareHouse withoutPlaces(PalettePlace... value)
   {
      for (PalettePlace item : value)
      {
         if ((this.places != null) && (item != null))
         {
            if (this.places.remove(item))
            {
               item.setWareHouse(null);
               firePropertyChange(PROPERTY_PLACES, item, null);
            }
         }
      }
      return this;
   }

   public PalettePlace createPlaces()
   {
      PalettePlace value = new PalettePlace();
      withPlaces(value);
      return value;
   } 
}
