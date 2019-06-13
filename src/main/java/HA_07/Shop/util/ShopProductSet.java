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
import HA_07.Shop.ShopProduct;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.list.NumberList;
import java.util.Collections;
import HA_07.Shop.util.ShopOrderSet;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.util.ShopSet;
import HA_07.Shop.Shop;

public class ShopProductSet extends SimpleSet<ShopProduct>
{
	public Class<?> getTypClass() {
		return ShopProduct.class;
	}

   public ShopProductSet()
   {
      // empty
   }

   public ShopProductSet(ShopProduct... objects)
   {
      for (ShopProduct obj : objects)
      {
         this.add(obj);
      }
   }

   public ShopProductSet(Collection<ShopProduct> objects)
   {
      this.addAll(objects);
   }

   public static final ShopProductSet EMPTY_SET = new ShopProductSet().withFlag(ShopProductSet.READONLY);


   public ShopProductPO createShopProductPO()
   {
      return new ShopProductPO(this.toArray(new ShopProduct[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.Shop.ShopProduct";
   }


   @Override
   public ShopProductSet getNewList(boolean keyValue)
   {
      return new ShopProductSet();
   }


   @SuppressWarnings("unchecked")
   public ShopProductSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<ShopProduct>)value);
      }
      else if (value != null)
      {
         this.add((ShopProduct) value);
      }
      
      return this;
   }
   
   public ShopProductSet without(ShopProduct value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect a list of the id attribute values. 
    * 
    * @return List of String objects reachable via id attribute
    */
   public ObjectSet getId()
   {
      ObjectSet result = new ObjectSet();
      
      for (ShopProduct obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createIdCondition(String value)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (value.equals(obj.getId()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createIdCondition(String lower, String upper)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (lower.compareTo(obj.getId()) <= 0 && obj.getId().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopProduct objects now with new attribute values.
    */
   public ShopProductSet withId(String value)
   {
      for (ShopProduct obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect a list of the inStock attribute values. 
    * 
    * @return List of double objects reachable via inStock attribute
    */
   public NumberList getInStock()
   {
      NumberList result = new NumberList();
      
      for (ShopProduct obj : this)
      {
         result.add(obj.getInStock());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the inStock attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createInStockCondition(double value)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (value == obj.getInStock())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the inStock attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createInStockCondition(double lower, double upper)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (lower <= obj.getInStock() && obj.getInStock() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and assign value to the inStock attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopProduct objects now with new attribute values.
    */
   public ShopProductSet withInStock(double value)
   {
      for (ShopProduct obj : this)
      {
         obj.setInStock(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (ShopProduct obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createNameCondition(String value)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createNameCondition(String lower, String upper)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopProduct objects now with new attribute values.
    */
   public ShopProductSet withName(String value)
   {
      for (ShopProduct obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect a list of the price attribute values. 
    * 
    * @return List of double objects reachable via price attribute
    */
   public NumberList getPrice()
   {
      NumberList result = new NumberList();
      
      for (ShopProduct obj : this)
      {
         result.add(obj.getPrice());
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the price attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createPriceCondition(double value)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (value == obj.getPrice())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and collect those ShopProduct objects where the price attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of ShopProduct objects that match the parameter
    */
   public ShopProductSet createPriceCondition(double lower, double upper)
   {
      ShopProductSet result = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (lower <= obj.getPrice() && obj.getPrice() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of ShopProduct objects and assign value to the price attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of ShopProduct objects now with new attribute values.
    */
   public ShopProductSet withPrice(double value)
   {
      for (ShopProduct obj : this)
      {
         obj.setPrice(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopProduct objects and collect a set of the ShopOrder objects reached via orders. 
    * 
    * @return Set of ShopOrder objects reachable via orders
    */
   public ShopOrderSet getOrders()
   {
      ShopOrderSet result = new ShopOrderSet();
      
      for (ShopProduct obj : this)
      {
         result.with(obj.getOrders());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopProduct objects and collect all contained objects with reference orders pointing to the object passed as parameter. 
    * 
    * @param value The object required as orders neighbor of the collected results. 
    * 
    * @return Set of ShopOrder objects referring to value via orders
    */
   public ShopProductSet filterOrders(Object value)
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
      
      ShopProductSet answer = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getOrders()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopProduct object passed as parameter to the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Orders attributes.
    */
   public ShopProductSet withOrders(ShopOrder value)
   {
      for (ShopProduct obj : this)
      {
         obj.withOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the ShopProduct object passed as parameter from the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public ShopProductSet withoutOrders(ShopOrder value)
   {
      for (ShopProduct obj : this)
      {
         obj.withoutOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of ShopProduct objects and collect a set of the Shop objects reached via shop. 
    * 
    * @return Set of Shop objects reachable via shop
    */
   public ShopSet getShop()
   {
      ShopSet result = new ShopSet();
      
      for (ShopProduct obj : this)
      {
         result.with(obj.getShop());
      }
      
      return result;
   }

   /**
    * Loop through the current set of ShopProduct objects and collect all contained objects with reference shop pointing to the object passed as parameter. 
    * 
    * @param value The object required as shop neighbor of the collected results. 
    * 
    * @return Set of Shop objects referring to value via shop
    */
   public ShopProductSet filterShop(Object value)
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
      
      ShopProductSet answer = new ShopProductSet();
      
      for (ShopProduct obj : this)
      {
         if (neighbors.contains(obj.getShop()) || (neighbors.isEmpty() && obj.getShop() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the ShopProduct object passed as parameter to the Shop attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Shop attributes.
    */
   public ShopProductSet withShop(Shop value)
   {
      for (ShopProduct obj : this)
      {
         obj.withShop(value);
      }
      
      return this;
   }

}
