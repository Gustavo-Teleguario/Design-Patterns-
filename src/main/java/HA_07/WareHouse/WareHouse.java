package HA_07.WareHouse;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class WareHouse 
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public WareHouse setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }


   public static final java.util.ArrayList<WareHouse> EMPTY_orders = new java.util.ArrayList<WareHouse>()
   { @Override public boolean add(WareHouse value){ throw new UnsupportedOperationException("No direct add! Use xy.withOrders(obj)"); }};


   public static final String PROPERTY_orders = "orders";

   private java.util.ArrayList<WareHouse> orders = null;

   public java.util.ArrayList<WareHouse> getOrders()
   {
      if (this.orders == null)
      {
         return EMPTY_orders;
      }

      return this.orders;
   }

   public WareHouse withOrders(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withOrders(i);
            }
         }
         else if (item instanceof WareHouse)
         {
            if (this.orders == null)
            {
               this.orders = new java.util.ArrayList<WareHouse>();
            }
            if ( ! this.orders.contains(item))
            {
               this.orders.add((WareHouse)item);
               ((WareHouse)item).setWareHouse(this);
               firePropertyChange("orders", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public WareHouse withoutOrders(Object... value)
   {
      if (this.orders == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutOrders(i);
            }
         }
         else if (item instanceof WareHouse)
         {
            if (this.orders.contains(item))
            {
               this.orders.remove((WareHouse)item);
               ((WareHouse)item).setWareHouse(null);
               firePropertyChange("orders", item, null);
            }
         }
      }
      return this;
   }


   public static final String PROPERTY_wareHouse = "wareHouse";

   private WareHouse wareHouse = null;

   public WareHouse getWareHouse()
   {
      return this.wareHouse;
   }

   public WareHouse setWareHouse(WareHouse value)
   {
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
         firePropertyChange("wareHouse", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<WareHouseProduct> EMPTY_products = new java.util.ArrayList<WareHouseProduct>()
   { @Override public boolean add(WareHouseProduct value){ throw new UnsupportedOperationException("No direct add! Use xy.withProducts(obj)"); }};


   public static final String PROPERTY_products = "products";

   private java.util.ArrayList<WareHouseProduct> products = null;

   public java.util.ArrayList<WareHouseProduct> getProducts()
   {
      if (this.products == null)
      {
         return EMPTY_products;
      }

      return this.products;
   }

   public WareHouse withProducts(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withProducts(i);
            }
         }
         else if (item instanceof WareHouseProduct)
         {
            if (this.products == null)
            {
               this.products = new java.util.ArrayList<WareHouseProduct>();
            }
            if ( ! this.products.contains(item))
            {
               this.products.add((WareHouseProduct)item);
               ((WareHouseProduct)item).setWareHouse(this);
               firePropertyChange("products", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public WareHouse withoutProducts(Object... value)
   {
      if (this.products == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutProducts(i);
            }
         }
         else if (item instanceof WareHouseProduct)
         {
            if (this.products.contains(item))
            {
               this.products.remove((WareHouseProduct)item);
               ((WareHouseProduct)item).setWareHouse(null);
               firePropertyChange("products", item, null);
            }
         }
      }
      return this;
   }


   public static final java.util.ArrayList<PalettePlace> EMPTY_places = new java.util.ArrayList<PalettePlace>()
   { @Override public boolean add(PalettePlace value){ throw new UnsupportedOperationException("No direct add! Use xy.withPlaces(obj)"); }};


   public static final String PROPERTY_places = "places";

   private java.util.ArrayList<PalettePlace> places = null;

   public java.util.ArrayList<PalettePlace> getPlaces()
   {
      if (this.places == null)
      {
         return EMPTY_places;
      }

      return this.places;
   }

   public WareHouse withPlaces(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPlaces(i);
            }
         }
         else if (item instanceof PalettePlace)
         {
            if (this.places == null)
            {
               this.places = new java.util.ArrayList<PalettePlace>();
            }
            if ( ! this.places.contains(item))
            {
               this.places.add((PalettePlace)item);
               ((PalettePlace)item).setWareHouse(this);
               firePropertyChange("places", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public WareHouse withoutPlaces(Object... value)
   {
      if (this.places == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPlaces(i);
            }
         }
         else if (item instanceof PalettePlace)
         {
            if (this.places.contains(item))
            {
               this.places.remove((PalettePlace)item);
               ((PalettePlace)item).setWareHouse(null);
               firePropertyChange("places", item, null);
            }
         }
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

      result.append(" ").append(this.getName());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setWareHouse(null);

      this.withoutOrders(this.getOrders().clone());


      this.withoutProducts(this.getProducts().clone());


      this.withoutPlaces(this.getPlaces().clone());


   }


}