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
   
package HA_07.WareHouse.util;

import de.uniks.networkparser.list.SimpleSet;
import HA_07.WareHouse.WareHouseOrder;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import HA_07.WareHouse.util.WareHouseProductSet;
import HA_07.WareHouse.WareHouseProduct;

public class WareHouseOrderSet extends SimpleSet<WareHouseOrder>
{
	public Class<?> getTypClass() {
		return WareHouseOrder.class;
	}

   public WareHouseOrderSet()
   {
      // empty
   }

   public WareHouseOrderSet(WareHouseOrder... objects)
   {
      for (WareHouseOrder obj : objects)
      {
         this.add(obj);
      }
   }

   public WareHouseOrderSet(Collection<WareHouseOrder> objects)
   {
      this.addAll(objects);
   }

   public static final WareHouseOrderSet EMPTY_SET = new WareHouseOrderSet().withFlag(WareHouseOrderSet.READONLY);


   public WareHouseOrderPO createWareHouseOrderPO()
   {
      return new WareHouseOrderPO(this.toArray(new WareHouseOrder[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.WareHouse.WareHouseOrder";
   }


   @Override
   public WareHouseOrderSet getNewList(boolean keyValue)
   {
      return new WareHouseOrderSet();
   }


   @SuppressWarnings("unchecked")
   public WareHouseOrderSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<WareHouseOrder>)value);
      }
      else if (value != null)
      {
         this.add((WareHouseOrder) value);
      }
      
      return this;
   }
   
   public WareHouseOrderSet without(WareHouseOrder value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect a list of the addresse attribute values. 
    * 
    * @return List of String objects reachable via addresse attribute
    */
   public ObjectSet getAddresse()
   {
      ObjectSet result = new ObjectSet();
      
      for (WareHouseOrder obj : this)
      {
         result.add(obj.getAddresse());
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect those WareHouseOrder objects where the addresse attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of WareHouseOrder objects that match the parameter
    */
   public WareHouseOrderSet createAddresseCondition(String value)
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if (value.equals(obj.getAddresse()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect those WareHouseOrder objects where the addresse attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of WareHouseOrder objects that match the parameter
    */
   public WareHouseOrderSet createAddresseCondition(String lower, String upper)
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if (lower.compareTo(obj.getAddresse()) <= 0 && obj.getAddresse().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and assign value to the addresse attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of WareHouseOrder objects now with new attribute values.
    */
   public WareHouseOrderSet withAddresse(String value)
   {
      for (WareHouseOrder obj : this)
      {
         obj.setAddresse(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect a list of the id attribute values. 
    * 
    * @return List of String objects reachable via id attribute
    */
   public ObjectSet getId()
   {
      ObjectSet result = new ObjectSet();
      
      for (WareHouseOrder obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect those WareHouseOrder objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of WareHouseOrder objects that match the parameter
    */
   public WareHouseOrderSet createIdCondition(String value)
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if (value.equals(obj.getId()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect those WareHouseOrder objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of WareHouseOrder objects that match the parameter
    */
   public WareHouseOrderSet createIdCondition(String lower, String upper)
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if (lower.compareTo(obj.getId()) <= 0 && obj.getId().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of WareHouseOrder objects now with new attribute values.
    */
   public WareHouseOrderSet withId(String value)
   {
      for (WareHouseOrder obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect a list of the product attribute values. 
    * 
    * @return List of String objects reachable via product attribute
    */
   public ObjectSet getProduct()
   {
      ObjectSet result = new ObjectSet();
      
      for (WareHouseOrder obj : this)
      {
         result.add(obj.getProduct());
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect those WareHouseOrder objects where the product attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of WareHouseOrder objects that match the parameter
    */
   public WareHouseOrderSet createProductCondition(String value)
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if (value.equals(obj.getProduct()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and collect those WareHouseOrder objects where the product attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of WareHouseOrder objects that match the parameter
    */
   public WareHouseOrderSet createProductCondition(String lower, String upper)
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if (lower.compareTo(obj.getProduct()) <= 0 && obj.getProduct().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseOrder objects and assign value to the product attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of WareHouseOrder objects now with new attribute values.
    */
   public WareHouseOrderSet withProduct(String value)
   {
      for (WareHouseOrder obj : this)
      {
         obj.setProduct(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouseOrder objects and collect a set of the WareHouseProduct objects reached via products. 
    * 
    * @return Set of WareHouseProduct objects reachable via products
    */
   public WareHouseProductSet getProducts()
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (WareHouseOrder obj : this)
      {
         result.with(obj.getProducts());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouseOrder objects and collect all contained objects with reference products pointing to the object passed as parameter. 
    * 
    * @param value The object required as products neighbor of the collected results. 
    * 
    * @return Set of WareHouseProduct objects referring to value via products
    */
   public WareHouseOrderSet filterProducts(Object value)
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
      
      WareHouseOrderSet answer = new WareHouseOrderSet();
      
      for (WareHouseOrder obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getProducts()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouseOrder object passed as parameter to the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Products attributes.
    */
   public WareHouseOrderSet withProducts(WareHouseProduct value)
   {
      for (WareHouseOrder obj : this)
      {
         obj.withProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the WareHouseOrder object passed as parameter from the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public WareHouseOrderSet withoutProducts(WareHouseProduct value)
   {
      for (WareHouseOrder obj : this)
      {
         obj.withoutProducts(value);
      }
      
      return this;
   }

}
