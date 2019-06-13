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
   
package HA_07.Shop.util;

import de.uniks.networkparser.list.SimpleSet;
import HA_07.Shop.ShopOrder;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import HA_07.Shop.util.ShopCustomerSet;
import HA_07.Shop.ShopCustomer;
import java.util.Collections;
import HA_07.Shop.util.ShopProductSet;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.util.ShopSet;
import HA_07.Shop.Shop;

public class ShopOrderSet extends SimpleSet<ShopOrder>
{
	public Class<?> getTypClass() {
		return ShopOrder.class;
	}

   public ShopOrderSet()
   {
      // empty
   }

   public ShopOrderSet(ShopOrder... objects)
   {
      for (ShopOrder obj : objects)
      {
         this.add(obj);
      }
   }

   public ShopOrderSet(Collection<ShopOrder> objects)
   {
      this.addAll(objects);
   }

   public static final ShopOrderSet EMPTY_SET = new ShopOrderSet().withFlag(ShopOrderSet.READONLY);


   public ShopOrderPO createShopOrderPO()
   {
      return new ShopOrderPO(this.toArray(new ShopOrder[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.Shop.ShopOrder";
   }


   @Override
   public ShopOrderSet getNewList(boolean keyValue)
   {
      return new ShopOrderSet();
   }


   @SuppressWarnings("unchecked")
   public ShopOrderSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ShopOrder>)value);
      }
      else if (value != null)
      {
         this.add((ShopOrder) value);
      }
      
      return this;
   }
   
   public ShopOrderSet without(ShopOrder value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of ShopOrder objects and collect a list of the id attribute values. 
    * 
    * @return List of String objects reachable via id attribute
    */
   public ObjectSet getId()
   {
      ObjectSet result = new ObjectSet();
      
      for (ShopOrder obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopOrder objects and collect those ShopOrder objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopOrder objects that match the parameter
    */
   public ShopOrderSet createIdCondition(String value)
   {
      ShopOrderSet result = new ShopOrderSet();
      
      for (ShopOrder obj : this)
      {
         if (value.equals(obj.getId()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopOrder objects and collect those ShopOrder objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopOrder objects that match the parameter
    */
   public ShopOrderSet createIdCondition(String lower, String upper)
   {
      ShopOrderSet result = new ShopOrderSet();
      
      for (ShopOrder obj : this)
      {
         if (lower.compareTo(obj.getId()) <= 0 && obj.getId().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopOrder objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopOrder objects now with new attribute values.
    */
   public ShopOrderSet withId(String value)
   {
      for (ShopOrder obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopOrder objects and collect a set of the ShopCustomer objects reached via shopCustomer. 
    * 
    * @return Set of ShopCustomer objects reachable via shopCustomer
    */
   public ShopCustomerSet getShopCustomer()
   {
      ShopCustomerSet result = new ShopCustomerSet();
      
      for (ShopOrder obj : this)
      {
         result.with(obj.getShopCustomer());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopOrder objects and collect all contained objects with reference shopCustomer pointing to the object passed as parameter. 
    * 
    * @param value The object required as shopCustomer neighbor of the collected results. 
    * 
    * @return Set of ShopCustomer objects referring to value via shopCustomer
    */
   public ShopOrderSet filterShopCustomer(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      ShopOrderSet answer = new ShopOrderSet();
      
      for (ShopOrder obj : this)
      {
         if (neighbors.contains(obj.getShopCustomer()) || (neighbors.isEmpty() && obj.getShopCustomer() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopOrder object passed as parameter to the ShopCustomer attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their ShopCustomer attributes.
    */
   public ShopOrderSet withShopCustomer(ShopCustomer value)
   {
      for (ShopOrder obj : this)
      {
         obj.withShopCustomer(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopOrder objects and collect a set of the ShopProduct objects reached via products. 
    * 
    * @return Set of ShopProduct objects reachable via products
    */
   public ShopProductSet getProducts()
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopOrder obj : this)
      {
         result.with(obj.getProducts());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopOrder objects and collect all contained objects with reference products pointing to the object passed as parameter. 
    * 
    * @param value The object required as products neighbor of the collected results. 
    * 
    * @return Set of ShopProduct objects referring to value via products
    */
   public ShopOrderSet filterProducts(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      ShopOrderSet answer = new ShopOrderSet();
      
      for (ShopOrder obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getProducts()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopOrder object passed as parameter to the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Products attributes.
    */
   public ShopOrderSet withProducts(ShopProduct value)
   {
      for (ShopOrder obj : this)
      {
         obj.withProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the ShopOrder object passed as parameter from the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ShopOrderSet withoutProducts(ShopProduct value)
   {
      for (ShopOrder obj : this)
      {
         obj.withoutProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopOrder objects and collect a set of the Shop objects reached via shop. 
    * 
    * @return Set of Shop objects reachable via shop
    */
   public ShopSet getShop()
   {
      ShopSet result = new ShopSet();
      
      for (ShopOrder obj : this)
      {
         result.with(obj.getShop());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopOrder objects and collect all contained objects with reference shop pointing to the object passed as parameter. 
    * 
    * @param value The object required as shop neighbor of the collected results. 
    * 
    * @return Set of Shop objects referring to value via shop
    */
   public ShopOrderSet filterShop(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      ShopOrderSet answer = new ShopOrderSet();
      
      for (ShopOrder obj : this)
      {
         if (neighbors.contains(obj.getShop()) || (neighbors.isEmpty() && obj.getShop() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopOrder object passed as parameter to the Shop attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Shop attributes.
    */
   public ShopOrderSet withShop(Shop value)
   {
      for (ShopOrder obj : this)
      {
         obj.withShop(value);
      }
      
      return this;
   }

}
