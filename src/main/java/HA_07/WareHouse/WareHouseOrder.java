package HA_07.WareHouse;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class WareHouseOrder 
{

   public static final String PROPERTY_addresse = "addresse";

   private String addresse;

   public String getAddresse()
   {
      return addresse;
   }

   public WareHouseOrder setAddresse(String value)
   {
      if (value == null ? this.addresse != null : ! value.equals(this.addresse))
      {
         String oldValue = this.addresse;
         this.addresse = value;
         firePropertyChange("addresse", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_id = "id";

   private String id;

   public String getId()
   {
      return id;
   }

   public WareHouseOrder setId(String value)
   {
      if (value == null ? this.id != null : ! value.equals(this.id))
      {
         String oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_product = "product";

   private String product;

   public String getProduct()
   {
      return product;
   }

   public WareHouseOrder setProduct(String value)
   {
      if (value == null ? this.product != null : ! value.equals(this.product))
      {
         String oldValue = this.product;
         this.product = value;
         firePropertyChange("product", oldValue, value);
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

   public WareHouseOrder withProducts(Object... value)
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
               ((WareHouseProduct)item).withOrders(this);
               firePropertyChange("products", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public WareHouseOrder withoutProducts(Object... value)
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
               ((WareHouseProduct)item).withoutOrders(this);
               firePropertyChange("products", item, null);
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

      result.append(" ").append(this.getAddresse());
      result.append(" ").append(this.getId());
      result.append(" ").append(this.getProduct());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.withoutProducts(this.getProducts().clone());


   }


}