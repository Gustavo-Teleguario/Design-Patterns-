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
import HA_07.WareHouse.Lot;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.list.NumberList;
import HA_07.WareHouse.util.WareHouseProductSet;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.util.PalettePlaceSet;
import HA_07.WareHouse.PalettePlace;

public class LotSet extends SimpleSet<Lot>
{
	public Class<?> getTypClass() {
		return Lot.class;
	}

   public LotSet()
   {
      // empty
   }

   public LotSet(Lot... objects)
   {
      for (Lot obj : objects)
      {
         this.add(obj);
      }
   }

   public LotSet(Collection<Lot> objects)
   {
      this.addAll(objects);
   }

   public static final LotSet EMPTY_SET = new LotSet().withFlag(LotSet.READONLY);


   public LotPO createLotPO()
   {
      return new LotPO(this.toArray(new Lot[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.WareHouse.Lot";
   }


   @Override
   public LotSet getNewList(boolean keyValue)
   {
      return new LotSet();
   }


   @SuppressWarnings("unchecked")
   public LotSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Lot>)value);
      }
      else if (value != null)
      {
         this.add((Lot) value);
      }
      
      return this;
   }
   
   public LotSet without(Lot value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Lot objects and collect a list of the id attribute values. 
    * 
    * @return List of String objects reachable via id attribute
    */
   public ObjectSet getId()
   {
      ObjectSet result = new ObjectSet();
      
      for (Lot obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Lot objects and collect those Lot objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Lot objects that match the parameter
    */
   public LotSet createIdCondition(String value)
   {
      LotSet result = new LotSet();
      
      for (Lot obj : this)
      {
         if (value.equals(obj.getId()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Lot objects and collect those Lot objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Lot objects that match the parameter
    */
   public LotSet createIdCondition(String lower, String upper)
   {
      LotSet result = new LotSet();
      
      for (Lot obj : this)
      {
         if (lower.compareTo(obj.getId()) <= 0 && obj.getId().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Lot objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Lot objects now with new attribute values.
    */
   public LotSet withId(String value)
   {
      for (Lot obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Lot objects and collect a list of the lotSize attribute values. 
    * 
    * @return List of double objects reachable via lotSize attribute
    */
   public NumberList getLotSize()
   {
      NumberList result = new NumberList();
      
      for (Lot obj : this)
      {
         result.add(obj.getLotSize());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Lot objects and collect those Lot objects where the lotSize attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Lot objects that match the parameter
    */
   public LotSet createLotSizeCondition(double value)
   {
      LotSet result = new LotSet();
      
      for (Lot obj : this)
      {
         if (value == obj.getLotSize())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Lot objects and collect those Lot objects where the lotSize attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Lot objects that match the parameter
    */
   public LotSet createLotSizeCondition(double lower, double upper)
   {
      LotSet result = new LotSet();
      
      for (Lot obj : this)
      {
         if (lower <= obj.getLotSize() && obj.getLotSize() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Lot objects and assign value to the lotSize attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Lot objects now with new attribute values.
    */
   public LotSet withLotSize(double value)
   {
      for (Lot obj : this)
      {
         obj.setLotSize(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Lot objects and collect a set of the WareHouseProduct objects reached via wareHouseProduct. 
    * 
    * @return Set of WareHouseProduct objects reachable via wareHouseProduct
    */
   public WareHouseProductSet getWareHouseProduct()
   {
      WareHouseProductSet result = new WareHouseProductSet();
      
      for (Lot obj : this)
      {
         result.with(obj.getWareHouseProduct());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Lot objects and collect all contained objects with reference wareHouseProduct pointing to the object passed as parameter. 
    * 
    * @param value The object required as wareHouseProduct neighbor of the collected results. 
    * 
    * @return Set of WareHouseProduct objects referring to value via wareHouseProduct
    */
   public LotSet filterWareHouseProduct(Object value)
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
      
      LotSet answer = new LotSet();
      
      for (Lot obj : this)
      {
         if (neighbors.contains(obj.getWareHouseProduct()) || (neighbors.isEmpty() && obj.getWareHouseProduct() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Lot object passed as parameter to the WareHouseProduct attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their WareHouseProduct attributes.
    */
   public LotSet withWareHouseProduct(WareHouseProduct value)
   {
      for (Lot obj : this)
      {
         obj.withWareHouseProduct(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Lot objects and collect a set of the PalettePlace objects reached via palettePlace. 
    * 
    * @return Set of PalettePlace objects reachable via palettePlace
    */
   public PalettePlaceSet getPalettePlace()
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (Lot obj : this)
      {
         result.with(obj.getPalettePlace());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Lot objects and collect all contained objects with reference palettePlace pointing to the object passed as parameter. 
    * 
    * @param value The object required as palettePlace neighbor of the collected results. 
    * 
    * @return Set of PalettePlace objects referring to value via palettePlace
    */
   public LotSet filterPalettePlace(Object value)
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
      
      LotSet answer = new LotSet();
      
      for (Lot obj : this)
      {
         if (neighbors.contains(obj.getPalettePlace()) || (neighbors.isEmpty() && obj.getPalettePlace() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Lot object passed as parameter to the PalettePlace attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their PalettePlace attributes.
    */
   public LotSet withPalettePlace(PalettePlace value)
   {
      for (Lot obj : this)
      {
         obj.withPalettePlace(value);
      }
      
      return this;
   }

}
