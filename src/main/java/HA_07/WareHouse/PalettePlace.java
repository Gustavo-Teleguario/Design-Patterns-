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
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.WareHouse;

public  class PalettePlace implements SendableEntity
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
      setLot(null);
      setWareHouse(null);
      firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_COLUMN = "column";
   
   private double column;

   public double getColumn()
   {
      return this.column;
   }
   
   public void setColumn(double value)
   {
      if (this.column != value) {
      
         double oldValue = this.column;
         this.column = value;
         this.firePropertyChange(PROPERTY_COLUMN, oldValue, value);
      }
   }
   
   public PalettePlace withColumn(double value)
   {
      setColumn(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getColumn());
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getRow());
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
   
   public PalettePlace withId(String value)
   {
      setId(value);
      return this;
   } 

   
   //==========================================================================
   
   public static final String PROPERTY_ROW = "row";
   
   private double row;

   public double getRow()
   {
      return this.row;
   }
   
   public void setRow(double value)
   {
      if (this.row != value) {
      
         double oldValue = this.row;
         this.row = value;
         this.firePropertyChange(PROPERTY_ROW, oldValue, value);
      }
   }
   
   public PalettePlace withRow(double value)
   {
      setRow(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * PalettePlace ----------------------------------- Lot
    *              palettePlace                   lot
    * </pre>
    */
   
   public static final String PROPERTY_LOT = "lot";

   private Lot lot = null;

   public Lot getLot()
   {
      return this.lot;
   }

   public boolean setLot(Lot value)
   {
      boolean changed = false;
      
      if (this.lot != value)
      {
         Lot oldValue = this.lot;
         
         if (this.lot != null)
         {
            this.lot = null;
            oldValue.setPalettePlace(null);
         }
         
         this.lot = value;
         
         if (value != null)
         {
            value.withPalettePlace(this);
         }
         
         firePropertyChange(PROPERTY_LOT, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public PalettePlace withLot(Lot value)
   {
      setLot(value);
      return this;
   } 

   public Lot createLot()
   {
      Lot value = new Lot();
      withLot(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * PalettePlace ----------------------------------- WareHouse
    *              places                   wareHouse
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
            oldValue.withoutPlaces(this);
         }
         
         this.wareHouse = value;
         
         if (value != null)
         {
            value.withPlaces(this);
         }
         
         firePropertyChange(PROPERTY_WAREHOUSE, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public PalettePlace withWareHouse(WareHouse value)
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
