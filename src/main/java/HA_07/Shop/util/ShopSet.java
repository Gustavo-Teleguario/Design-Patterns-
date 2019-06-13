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
import HA_07.Shop.Shop;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import HA_07.Shop.util.ShopProductSet;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.util.ShopCustomerSet;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.ShopOrder;

public class ShopSet extends SimpleSet<Shop>
{
	public Class<?> getTypClass() {
		return Shop.class;
	}

   public ShopSet()
   {
      // empty
   }

   public ShopSet(Shop... objects)
   {
      for (Shop obj : objects)
      {
         this.add(obj);
      }
   }

   public ShopSet(Collection<Shop> objects)
   {
      this.addAll(objects);
   }

   public static final ShopSet EMPTY_SET = new ShopSet().withFlag(ShopSet.READONLY);


   public ShopPO createShopPO()
   {
      return new ShopPO(this.toArray(new Shop[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.Shop.Shop";
   }


   @Override
   public ShopSet getNewList(boolean keyValue)
   {
      return new ShopSet();
   }


   @SuppressWarnings("unchecked")
   public ShopSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Shop>)value);
      }
      else if (value != null)
      {
         this.add((Shop) value);
      }
      
      return this;
   }
   
   public ShopSet without(Shop value)
   {
      this.remove(value);
      return this;
   }

   /**
    * Loop through the current set of Shop objects and collect a set of the ShopProduct objects reached via products. 
    * 
    * @return Set of ShopProduct objects reachable via products
    */
   public ShopProductSet getProducts()
   {
      ShopProductSet result = new ShopProductSet();
      
      for (Shop obj : this)
      {
         result.with(obj.getProducts());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Shop objects and collect all contained objects with reference products pointing to the object passed as parameter. 
    * 
    * @param value The object required as products neighbor of the collected results. 
    * 
    * @return Set of ShopProduct objects referring to value via products
    */
   public ShopSet filterProducts(Object value)
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
      
      ShopSet answer = new ShopSet();
      
      for (Shop obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getProducts()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Shop object passed as parameter to the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Products attributes.
    */
   public ShopSet withProducts(ShopProduct value)
   {
      for (Shop obj : this)
      {
         obj.withProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Shop object passed as parameter from the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ShopSet withoutProducts(ShopProduct value)
   {
      for (Shop obj : this)
      {
         obj.withoutProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Shop objects and collect a set of the ShopCustomer objects reached via customers. 
    * 
    * @return Set of ShopCustomer objects reachable via customers
    */
   public ShopCustomerSet getCustomers()
   {
      ShopCustomerSet result = new ShopCustomerSet();
      
      for (Shop obj : this)
      {
         result.with(obj.getCustomers());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Shop objects and collect all contained objects with reference customers pointing to the object passed as parameter. 
    * 
    * @param value The object required as customers neighbor of the collected results. 
    * 
    * @return Set of ShopCustomer objects referring to value via customers
    */
   public ShopSet filterCustomers(Object value)
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
      
      ShopSet answer = new ShopSet();
      
      for (Shop obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getCustomers()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Shop object passed as parameter to the Customers attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Customers attributes.
    */
   public ShopSet withCustomers(ShopCustomer value)
   {
      for (Shop obj : this)
      {
         obj.withCustomers(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Shop object passed as parameter from the Customers attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ShopSet withoutCustomers(ShopCustomer value)
   {
      for (Shop obj : this)
      {
         obj.withoutCustomers(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Shop objects and collect a set of the ShopOrder objects reached via orders. 
    * 
    * @return Set of ShopOrder objects reachable via orders
    */
   public ShopOrderSet getOrders()
   {
      ShopOrderSet result = new ShopOrderSet();
      
      for (Shop obj : this)
      {
         result.with(obj.getOrders());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Shop objects and collect all contained objects with reference orders pointing to the object passed as parameter. 
    * 
    * @param value The object required as orders neighbor of the collected results. 
    * 
    * @return Set of ShopOrder objects referring to value via orders
    */
   public ShopSet filterOrders(Object value)
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
      
      ShopSet answer = new ShopSet();
      
      for (Shop obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getOrders()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Shop object passed as parameter to the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Orders attributes.
    */
   public ShopSet withOrders(ShopOrder value)
   {
      for (Shop obj : this)
      {
         obj.withOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Shop object passed as parameter from the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ShopSet withoutOrders(ShopOrder value)
   {
      for (Shop obj : this)
      {
         obj.withoutOrders(value);
      }
      
      return this;
   }

}
