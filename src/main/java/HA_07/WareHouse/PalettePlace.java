package HA_07.WareHouse;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class PalettePlace 
{

   public static final String PROPERTY_column = "column";

   private double column;

   public double getColumn()
   {
      return column;
   }

   public PalettePlace setColumn(double value)
   {
      if (value != this.column)
      {
         double oldValue = this.column;
         this.column = value;
         firePropertyChange("column", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public PalettePlace setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_row = "row";

   private double row;

   public double getRow()
   {
      return row;
   }

   public PalettePlace setRow(double value)
   {
      if (value != this.row)
      {
         double oldValue = this.row;
         this.row = value;
         firePropertyChange("row", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_wareHouse = "wareHouse";

   private WareHouse wareHouse = null;

   public WareHouse getWareHouse()
   {
      return this.wareHouse;
   }

   public PalettePlace setWareHouse(WareHouse value)
   {
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
         firePropertyChange("wareHouse", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_lot = "lot";

   private Lot lot = null;

   public Lot getLot()
   {
      return this.lot;
   }

   public PalettePlace setLot(Lot value)
   {
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
            value.setPalettePlace(this);
         }
         firePropertyChange("lot", oldValue, value);
      }
      return this;
   }



   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getId());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setWareHouse(null);
      this.setLot(null);

   }


}