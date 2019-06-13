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
import HA_07.WareHouse.WareHouse;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import HA_07.WareHouse.util.WareHouseSet;
import java.util.Collections;
import HA_07.WareHouse.util.WareHouseProductSet;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.util.PalettePlaceSet;
import HA_07.WareHouse.PalettePlace;

public class WareHouseSet extends SimpleSet<WareHouse>
{
	public Class<?> getTypClass() {
		return WareHouse.class;
	}

   public WareHouseSet()
   {
      // empty
   }

   public WareHouseSet(WareHouse... objects)
   {
      for (WareHouse obj : objects)
      {
         this.add(obj);
      }
   }

   public WareHouseSet(Collection<WareHouse> objects)
   {
      this.addAll(objects);
   }

   public static final WareHouseSet EMPTY_SET = new WareHouseSet().withFlag(WareHouseSet.READONLY);


   public WareHousePO createWareHousePO()
   {
      return new WareHousePO(this.toArray(new WareHouse[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.WareHouse.WareHouse";
   }


   @Override
   public WareHouseSet getNewList(boolean keyValue)
   {
      return new WareHouseSet();
   }


   @SuppressWarnings("unchecked")
   public WareHouseSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<WareHouse>)value);
      }
      else if (value != null)
      {
         this.add((WareHouse) value);
      }
      
      return this;
   }
   
   public WareHouseSet without(WareHouse value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of WareHouse objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public ObjectSet getName()
   {
      ObjectSet result = new ObjectSet();
      
      for (WareHouse obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouse objects and collect those WareHouse objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of WareHouse objects that match the parameter
    */
   public WareHouseSet createNameCondition(String value)
   {
      WareHouseSet result = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouse objects and collect those WareHouse objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of WareHouse objects that match the parameter
    */
   public WareHouseSet createNameCondition(String lower, String upper)
   {
      WareHouseSet result = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of WareHouse objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of WareHouse objects now with new attribute values.
    */
   public WareHouseSet withName(String value)
   {
      for (WareHouse obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouse objects and collect a set of the WareHouse objects reached via wareHouse. 
    * 
    * @return Set of WareHouse objects reachable via wareHouse
    */
   public WareHouseSet getWareHouse()
   {
      WareHouseSet result = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         result.with(obj.getWareHouse());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouse objects and collect all contained objects with reference wareHouse pointing to the object passed as parameter. 
    * 
    * @param value The object required as wareHouse neighbor of the collected results. 
    * 
    * @return Set of WareHouse objects referring to value via wareHouse
    */
   public WareHouseSet filterWareHouse(Object value)
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
      
      WareHouseSet answer = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         if (neighbors.contains(obj.getWareHouse()) || (neighbors.isEmpty() && obj.getWareHouse() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow wareHouse reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of WareHouse objects reachable via wareHouse transitively (including the start set)
    */
   public WareHouseSet getWareHouseTransitive()
   {
      WareHouseSet todo = new WareHouseSet().with(this);
      
      WareHouseSet result = new WareHouseSet();
      
      while ( ! todo.isEmpty())
      {
         WareHouse current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getWareHouse()))
            {
               todo.with(current.getWareHouse());
            }
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouse object passed as parameter to the WareHouse attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their WareHouse attributes.
    */
   public WareHouseSet withWareHouse(WareHouse value)
   {
      for (WareHouse obj : this)
      {
         obj.withWareHouse(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouse objects and collect a set of the WareHouse objects reached via orders. 
    * 
    * @return Set of WareHouse objects reachable via orders
    */
   public WareHouseSet getOrders()
   {
      WareHouseSet result = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         result.with(obj.getOrders());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouse objects and collect all contained objects with reference orders pointing to the object passed as parameter. 
    * 
    * @param value The object required as orders neighbor of the collected results. 
    * 
    * @return Set of WareHouse objects referring to value via orders
    */
   public WareHouseSet filterOrders(Object value)
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
      
      WareHouseSet answer = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getOrders()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow orders reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of WareHouse objects reachable via orders transitively (including the start set)
    */
   public WareHouseSet getOrdersTransitive()
   {
      WareHouseSet todo = new WareHouseSet().with(this);
      
      WareHouseSet result = new WareHouseSet();
      
      while ( ! todo.isEmpty())
      {
         WareHouse current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            todo.with(current.getOrders()).minus(result);
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouse object passed as parameter to the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Orders attributes.
    */
   public WareHouseSet withOrders(WareHouse value)
   {
      for (WareHouse obj : this)
      {
         obj.withOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the WareHouse object passed as parameter from the Orders attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public WareHouseSet withoutOrders(WareHouse value)
   {
      for (WareHouse obj : this)
      {
         obj.withoutOrders(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouse objects and collect a set of the WareHouseProduct objects reached via products. 
    * 
    * @return Set of WareHouseProduct objects reachable via products
    */
   public WareHouseProductSet getProducts()
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (WareHouse obj : this)
      {
         result.with(obj.getProducts());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouse objects and collect all contained objects with reference products pointing to the object passed as parameter. 
    * 
    * @param value The object required as products neighbor of the collected results. 
    * 
    * @return Set of WareHouseProduct objects referring to value via products
    */
   public WareHouseSet filterProducts(Object value)
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
      
      WareHouseSet answer = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getProducts()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouse object passed as parameter to the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Products attributes.
    */
   public WareHouseSet withProducts(WareHouseProduct value)
   {
      for (WareHouse obj : this)
      {
         obj.withProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the WareHouse object passed as parameter from the Products attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public WareHouseSet withoutProducts(WareHouseProduct value)
   {
      for (WareHouse obj : this)
      {
         obj.withoutProducts(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of WareHouse objects and collect a set of the PalettePlace objects reached via places. 
    * 
    * @return Set of PalettePlace objects reachable via places
    */
   public PalettePlaceSet getPlaces()
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (WareHouse obj : this)
      {
         result.with(obj.getPlaces());
      }
      
      return result;
   }

   /**
    * Loop through the current set of WareHouse objects and collect all contained objects with reference places pointing to the object passed as parameter. 
    * 
    * @param value The object required as places neighbor of the collected results. 
    * 
    * @return Set of PalettePlace objects referring to value via places
    */
   public WareHouseSet filterPlaces(Object value)
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
      
      WareHouseSet answer = new WareHouseSet();
      
      for (WareHouse obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPlaces()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the WareHouse object passed as parameter to the Places attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Places attributes.
    */
   public WareHouseSet withPlaces(PalettePlace value)
   {
      for (WareHouse obj : this)
      {
         obj.withPlaces(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the WareHouse object passed as parameter from the Places attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now without the old neighbor.
    */
   public WareHouseSet withoutPlaces(PalettePlace value)
   {
      for (WareHouse obj : this)
      {
         obj.withoutPlaces(value);
      }
      
      return this;
   }

}
