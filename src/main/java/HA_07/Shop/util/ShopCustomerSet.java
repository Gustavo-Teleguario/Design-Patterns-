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
import HA_07.Shop.ShopCustomer;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.util.ShopSet;
import HA_07.Shop.Shop;

public class ShopCustomerSet extends SimpleSet<ShopCustomer>
{
	public Class<?> getTypClass() {
		return ShopCustomer.class;
	}

   public ShopCustomerSet()
   {
      // empty
   }

   public ShopCustomerSet(ShopCustomer... objects)
   {
      for (ShopCustomer obj : objects)
      {
         this.add(obj);
      }
   }

   public ShopCustomerSet(Collection<ShopCustomer> objects)
   {
      this.addAll(objects);
   }

   public static final ShopCustomerSet EMPTY_SET = new ShopCustomerSet().withFlag(ShopCustomerSet.READONLY);


   public ShopCustomerPO createShopCustomerPO()
   {
      return new ShopCustomerPO(this.toArray(new ShopCustomer[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.Shop.ShopCustomer";
   }


   @Override
   public ShopCustomerSet getNewList(boolean keyValue)
   {
      return new ShopCustomerSet();
   }


   @SuppressWarnings("unchecked")
   public ShopCustomerSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ShopCustomer>)value);
      }
      else if (value != null)
      {
         this.add((ShopCustomer) value);
      }
      
      return this;
   }
   
   public ShopCustomerSet without(ShopCustomer value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of ShopCustomer objects and collect a list of the addresse attribute values. 
    * 
    * @return List of String objects reachable via addresse attribute
    */
   public ObjectSet getAddresse()
   {
      ObjectSet result = new ObjectSet();
      
      for (ShopCustomer obj : this)
      {
         result.add(obj.getAddresse());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopCustomer objects and collect those ShopCustomer objects where the addresse attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopCustomer objects that match the parameter
    */
   public ShopCustomerSet createAddresseCondition(String value)
   {
      ShopCustomerSet result = new ShopCustomerSet();
      
      for (ShopCustomer obj : this)
      {
         if (value.equals(obj.getAddresse()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopCustomer objects and collect those ShopCustomer objects where the addresse attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopCustomer objects that match the parameter
    */
   public ShopCustomerSet createAddresseCondition(String lower, String upper)
   {
      ShopCustomerSet result = new ShopCustomerSet();
      
      for (ShopCustomer obj : this)
      {
         if (lower.compareTo(obj.getAddresse()) <= 0 && obj.getAddresse().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopCustomer objects and assign value to the addresse attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopCustomer objects now with new attribute values.
    */
   public ShopCustomerSet withAddresse(String value)
   {
      for (ShopCustomer obj : this)
      {
         obj.setAddresse(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ShopCustomer objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (ShopCustomer obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopCustomer objects and collect those ShopCustomer objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopCustomer objects that match the parameter
    */
   public ShopCustomerSet createNameCondition(String value)
   {
      ShopCustomerSet result = new ShopCustomerSet();
      
      for (ShopCustomer obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopCustomer objects and collect those ShopCustomer objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopCustomer objects that match the parameter
    */
   public ShopCustomerSet createNameCondition(String lower, String upper)
   {
      ShopCustomerSet result = new ShopCustomerSet();
      
      for (ShopCustomer obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopCustomer objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopCustomer objects now with new attribute values.
    */
   public ShopCustomerSet withName(String value)
   {
      for (ShopCustomer obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopCustomer objects and collect a set of the ShopOrder objects reached via orders. 
    * 
    * @return Set of ShopOrder objects reachable via orders
    */
   public ShopOrderSet getOrders()
   {
      ShopOrderSet result = new ShopOrderSet();
      
      for (ShopCustomer obj : this)
      {
         result.with(obj.getOrders());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopCustomer objects and collect all contained objects with reference orders pointing to the object passed as parameter. 
    * 
    * @param value The object required as orders neighbor of the collected results. 
    * 
    * @return Set of ShopOrder objects referring to value via orders
    */
   public ShopCustomerSet filterOrders(Object value)
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
      
      ShopCustomerSet answer = new ShopCustomerSet();
      
      for (ShopCustomer obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getOrders()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopCustomer object passed as parameter to the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Orders attributes.
    */
   public ShopCustomerSet withOrders(ShopOrder value)
   {
      for (ShopCustomer obj : this)
      {
         obj.withOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the ShopCustomer object passed as parameter from the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ShopCustomerSet withoutOrders(ShopOrder value)
   {
      for (ShopCustomer obj : this)
      {
         obj.withoutOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopCustomer objects and collect a set of the Shop objects reached via shop. 
    * 
    * @return Set of Shop objects reachable via shop
    */
   public ShopSet getShop()
   {
      ShopSet result = new ShopSet();
      
      for (ShopCustomer obj : this)
      {
         result.with(obj.getShop());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopCustomer objects and collect all contained objects with reference shop pointing to the object passed as parameter. 
    * 
    * @param value The object required as shop neighbor of the collected results. 
    * 
    * @return Set of Shop objects referring to value via shop
    */
   public ShopCustomerSet filterShop(Object value)
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
      
      ShopCustomerSet answer = new ShopCustomerSet();
      
      for (ShopCustomer obj : this)
      {
         if (neighbors.contains(obj.getShop()) || (neighbors.isEmpty() && obj.getShop() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopCustomer object passed as parameter to the Shop attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Shop attributes.
    */
   public ShopCustomerSet withShop(Shop value)
   {
      for (ShopCustomer obj : this)
      {
         obj.withShop(value);
      }
      
      return this;
   }

}
