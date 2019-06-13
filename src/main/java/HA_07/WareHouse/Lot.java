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
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.PalettePlace;

public  class Lot implements SendableEntity
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
      setWareHouseProduct(null);
      setPalettePlace(null);
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
   
   public Lot withId(String value)
   {
      setId(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getLotSize());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_LOTSIZE = "lotSize";
   
   private double lotSize;

   public double getLotSize()
   {
      return this.lotSize;
   }
   
   public void setLotSize(double value)
   {
      if (this.lotSize != value) {
      
         double oldValue = this.lotSize;
         this.lotSize = value;
         this.firePropertyChange(PROPERTY_LOTSIZE, oldValue, value);
      }
   }
   
   public Lot withLotSize(double value)
   {
      setLotSize(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Lot ----------------------------------- WareHouseProduct
    *              lots                   wareHouseProduct
    * </pre>
    */
   
   public static final String PROPERTY_WAREHOUSEPRODUCT = "wareHouseProduct";

   private WareHouseProduct wareHouseProduct = null;

   public WareHouseProduct getWareHouseProduct()
   {
      return this.wareHouseProduct;
   }

   public boolean setWareHouseProduct(WareHouseProduct value)
   {
      boolean changed = false;
      
      if (this.wareHouseProduct != value)
      {
         WareHouseProduct oldValue = this.wareHouseProduct;
         
         if (this.wareHouseProduct != null)
         {
            this.wareHouseProduct = null;
            oldValue.withoutLots(this);
         }
         
         this.wareHouseProduct = value;
         
         if (value != null)
         {
            value.withLots(this);
         }
         
         firePropertyChange(PROPERTY_WAREHOUSEPRODUCT, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Lot withWareHouseProduct(WareHouseProduct value)
   {
      setWareHouseProduct(value);
      return this;
   } 

   public WareHouseProduct createWareHouseProduct()
   {
      WareHouseProduct value = new WareHouseProduct();
      withWareHouseProduct(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Lot ----------------------------------- PalettePlace
    *              lot                   palettePlace
    * </pre>
    */
   
   public static final String PROPERTY_PALETTEPLACE = "palettePlace";

   private PalettePlace palettePlace = null;

   public PalettePlace getPalettePlace()
   {
      return this.palettePlace;
   }

   public boolean setPalettePlace(PalettePlace value)
   {
      boolean changed = false;
      
      if (this.palettePlace != value)
      {
         PalettePlace oldValue = this.palettePlace;
         
         if (this.palettePlace != null)
         {
            this.palettePlace = null;
            oldValue.setLot(null);
         }
         
         this.palettePlace = value;
         
         if (value != null)
         {
            value.withLot(this);
         }
         
         firePropertyChange(PROPERTY_PALETTEPLACE, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Lot withPalettePlace(PalettePlace value)
   {
      setPalettePlace(value);
      return this;
   } 

   public PalettePlace createPalettePlace()
   {
      PalettePlace value = new PalettePlace();
      withPalettePlace(value);
      return value;
   } 
}
