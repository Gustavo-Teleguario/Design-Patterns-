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
import HA_07.WareHouse.WareHouseProduct;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import java.util.Collections;
import HA_07.WareHouse.util.LotSet;
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.util.WareHouseOrderSet;
import HA_07.WareHouse.WareHouseOrder;
import HA_07.WareHouse.util.WareHouseSet;
import HA_07.WareHouse.WareHouse;

public class WareHouseProductSet extends SimpleSet<WareHouseProduct>
{
	public Class<?> getTypClass() {
		return WareHouseProduct.class;
	}

   public WareHouseProductSet()
   {
      // empty
   }

   public WareHouseProductSet(WareHouseProduct... objects)
   {
      for (WareHouseProduct obj : objects)
      {
         this.add(obj);
      }
   }

   public WareHouseProductSet(Collection<WareHouseProduct> objects)
   {
      this.addAll(objects);
   }

   public static final WareHouseProductSet EMPTY_SET = new WareHouseProductSet().withFlag(WareHouseProductSet.READONLY);


   public WareHouseProductPO createWareHouseProductPO()
   {
      return new WareHouseProductPO(this.toArray(new WareHouseProduct[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.WareHouse.WareHouseProduct";
   }


   @Override
   public WareHouseProductSet getNewList(boolean keyValue)
   {
      return new WareHouseProductSet();
   }


   @SuppressWarnings("unchecked")
   public WareHouseProductSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<WareHouseProduct>)value);
      }
      else if (value != null)
      {
         this.add((WareHouseProduct) value);
      }
      
      return this;
   }
   
   public WareHouseProductSet without(WareHouseProduct value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and collect a list of the id attribute values. 
    * 
    * @return List of String objects reachable via id attribute
    */
   public ObjectSet getId()
   {
      ObjectSet result = new ObjectSet();
      
      for (WareHouseProduct obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and collect those WareHouseProduct objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of WareHouseProduct objects that match the parameter
    */
   public WareHouseProductSet createIdCondition(String value)
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if (value.equals(obj.getId()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and collect those WareHouseProduct objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of WareHouseProduct objects that match the parameter
    */
   public WareHouseProductSet createIdCondition(String lower, String upper)
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if (lower.compareTo(obj.getId()) <= 0 && obj.getId().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of WareHouseProduct objects now with new attribute values.
    */
   public WareHouseProductSet withId(String value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (WareHouseProduct obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and collect those WareHouseProduct objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of WareHouseProduct objects that match the parameter
    */
   public WareHouseProductSet createNameCondition(String value)
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and collect those WareHouseProduct objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of WareHouseProduct objects that match the parameter
    */
   public WareHouseProductSet createNameCondition(String lower, String upper)
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouseProduct objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of WareHouseProduct objects now with new attribute values.
    */
   public WareHouseProductSet withName(String value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouseProduct objects and collect a set of the Lot objects reached via lots. 
    * 
    * @return Set of Lot objects reachable via lots
    */
   public LotSet getLots()
   {
      LotSet result = new LotSet();
      
      for (WareHouseProduct obj : this)
      {
         result.with(obj.getLots());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouseProduct objects and collect all contained objects with reference lots pointing to the object passed as parameter. 
    * 
    * @param value The object required as lots neighbor of the collected results. 
    * 
    * @return Set of Lot objects referring to value via lots
    */
   public WareHouseProductSet filterLots(Object value)
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
      
      WareHouseProductSet answer = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getLots()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouseProduct object passed as parameter to the Lots attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Lots attributes.
    */
   public WareHouseProductSet withLots(Lot value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.withLots(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the WareHouseProduct object passed as parameter from the Lots attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public WareHouseProductSet withoutLots(Lot value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.withoutLots(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouseProduct objects and collect a set of the WareHouseOrder objects reached via orders. 
    * 
    * @return Set of WareHouseOrder objects reachable via orders
    */
   public WareHouseOrderSet getOrders()
   {
      WareHouseOrderSet result = new WareHouseOrderSet();
      
      for (WareHouseProduct obj : this)
      {
         result.with(obj.getOrders());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouseProduct objects and collect all contained objects with reference orders pointing to the object passed as parameter. 
    * 
    * @param value The object required as orders neighbor of the collected results. 
    * 
    * @return Set of WareHouseOrder objects referring to value via orders
    */
   public WareHouseProductSet filterOrders(Object value)
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
      
      WareHouseProductSet answer = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getOrders()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouseProduct object passed as parameter to the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Orders attributes.
    */
   public WareHouseProductSet withOrders(WareHouseOrder value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.withOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the WareHouseProduct object passed as parameter from the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public WareHouseProductSet withoutOrders(WareHouseOrder value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.withoutOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouseProduct objects and collect a set of the WareHouse objects reached via wareHouse. 
    * 
    * @return Set of WareHouse objects reachable via wareHouse
    */
   public WareHouseSet getWareHouse()
   {
      WareHouseSet result = new WareHouseSet();
      
      for (WareHouseProduct obj : this)
      {
         result.with(obj.getWareHouse());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouseProduct objects and collect all contained objects with reference wareHouse pointing to the object passed as parameter. 
    * 
    * @param value The object required as wareHouse neighbor of the collected results. 
    * 
    * @return Set of WareHouse objects referring to value via wareHouse
    */
   public WareHouseProductSet filterWareHouse(Object value)
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
      
      WareHouseProductSet answer = new WareHouseProductSet();
      
      for (WareHouseProduct obj : this)
      {
         if (neighbors.contains(obj.getWareHouse()) || (neighbors.isEmpty() && obj.getWareHouse() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouseProduct object passed as parameter to the WareHouse attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their WareHouse attributes.
    */
   public WareHouseProductSet withWareHouse(WareHouse value)
   {
      for (WareHouseProduct obj : this)
      {
         obj.withWareHouse(value);
      }
      
      return this;
   }

}
