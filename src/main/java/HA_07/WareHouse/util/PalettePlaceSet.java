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
import HA_07.WareHouse.PalettePlace;
import de.uniks.networkparser.interfaces.Condition;
import java.util.Collection;
import de.uniks.networkparser.list.NumberList;
import de.uniks.networkparser.list.ObjectSet;
import HA_07.WareHouse.util.LotSet;
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.util.WareHouseSet;
import HA_07.WareHouse.WareHouse;

public class PalettePlaceSet extends SimpleSet<PalettePlace>
{
	public Class<?> getTypClass() {
		return PalettePlace.class;
	}

   public PalettePlaceSet()
   {
      // empty
   }

   public PalettePlaceSet(PalettePlace... objects)
   {
      for (PalettePlace obj : objects)
      {
         this.add(obj);
      }
   }

   public PalettePlaceSet(Collection<PalettePlace> objects)
   {
      this.addAll(objects);
   }

   public static final PalettePlaceSet EMPTY_SET = new PalettePlaceSet().withFlag(PalettePlaceSet.READONLY);


   public PalettePlacePO createPalettePlacePO()
   {
      return new PalettePlacePO(this.toArray(new PalettePlace[this.size()]));
   }


   public String getEntryType()
   {
      return "HA_07.WareHouse.PalettePlace";
   }


   @Override
   public PalettePlaceSet getNewList(boolean keyValue)
   {
      return new PalettePlaceSet();
   }


   @SuppressWarnings("unchecked")
   public PalettePlaceSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<PalettePlace>)value);
      }
      else if (value != null)
      {
         this.add((PalettePlace) value);
      }
      
      return this;
   }
   
   public PalettePlaceSet without(PalettePlace value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect a list of the column attribute values. 
    * 
    * @return List of double objects reachable via column attribute
    */
   public NumberList getColumn()
   {
      NumberList result = new NumberList();
      
      for (PalettePlace obj : this)
      {
         result.add(obj.getColumn());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect those PalettePlace objects where the column attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PalettePlace objects that match the parameter
    */
   public PalettePlaceSet createColumnCondition(double value)
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (value == obj.getColumn())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect those PalettePlace objects where the column attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PalettePlace objects that match the parameter
    */
   public PalettePlaceSet createColumnCondition(double lower, double upper)
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (lower <= obj.getColumn() && obj.getColumn() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and assign value to the column attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PalettePlace objects now with new attribute values.
    */
   public PalettePlaceSet withColumn(double value)
   {
      for (PalettePlace obj : this)
      {
         obj.setColumn(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect a list of the id attribute values. 
    * 
    * @return List of String objects reachable via id attribute
    */
   public ObjectSet getId()
   {
      ObjectSet result = new ObjectSet();
      
      for (PalettePlace obj : this)
      {
         result.add(obj.getId());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect those PalettePlace objects where the id attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PalettePlace objects that match the parameter
    */
   public PalettePlaceSet createIdCondition(String value)
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (value.equals(obj.getId()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect those PalettePlace objects where the id attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PalettePlace objects that match the parameter
    */
   public PalettePlaceSet createIdCondition(String lower, String upper)
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (lower.compareTo(obj.getId()) <= 0 && obj.getId().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and assign value to the id attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PalettePlace objects now with new attribute values.
    */
   public PalettePlaceSet withId(String value)
   {
      for (PalettePlace obj : this)
      {
         obj.setId(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect a list of the row attribute values. 
    * 
    * @return List of double objects reachable via row attribute
    */
   public NumberList getRow()
   {
      NumberList result = new NumberList();
      
      for (PalettePlace obj : this)
      {
         result.add(obj.getRow());
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect those PalettePlace objects where the row attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of PalettePlace objects that match the parameter
    */
   public PalettePlaceSet createRowCondition(double value)
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (value == obj.getRow())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and collect those PalettePlace objects where the row attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of PalettePlace objects that match the parameter
    */
   public PalettePlaceSet createRowCondition(double lower, double upper)
   {
      PalettePlaceSet result = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (lower <= obj.getRow() && obj.getRow() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of PalettePlace objects and assign value to the row attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of PalettePlace objects now with new attribute values.
    */
   public PalettePlaceSet withRow(double value)
   {
      for (PalettePlace obj : this)
      {
         obj.setRow(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of PalettePlace objects and collect a set of the Lot objects reached via lot. 
    * 
    * @return Set of Lot objects reachable via lot
    */
   public LotSet getLot()
   {
      LotSet result = new LotSet();
      
      for (PalettePlace obj : this)
      {
         result.with(obj.getLot());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PalettePlace objects and collect all contained objects with reference lot pointing to the object passed as parameter. 
    * 
    * @param value The object required as lot neighbor of the collected results. 
    * 
    * @return Set of Lot objects referring to value via lot
    */
   public PalettePlaceSet filterLot(Object value)
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
      
      PalettePlaceSet answer = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (neighbors.contains(obj.getLot()) || (neighbors.isEmpty() && obj.getLot() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PalettePlace object passed as parameter to the Lot attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their Lot attributes.
    */
   public PalettePlaceSet withLot(Lot value)
   {
      for (PalettePlace obj : this)
      {
         obj.withLot(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of PalettePlace objects and collect a set of the WareHouse objects reached via wareHouse. 
    * 
    * @return Set of WareHouse objects reachable via wareHouse
    */
   public WareHouseSet getWareHouse()
   {
      WareHouseSet result = new WareHouseSet();
      
      for (PalettePlace obj : this)
      {
         result.with(obj.getWareHouse());
      }
      
      return result;
   }

   /**
    * Loop through the current set of PalettePlace objects and collect all contained objects with reference wareHouse pointing to the object passed as parameter. 
    * 
    * @param value The object required as wareHouse neighbor of the collected results. 
    * 
    * @return Set of WareHouse objects referring to value via wareHouse
    */
   public PalettePlaceSet filterWareHouse(Object value)
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
      
      PalettePlaceSet answer = new PalettePlaceSet();
      
      for (PalettePlace obj : this)
      {
         if (neighbors.contains(obj.getWareHouse()) || (neighbors.isEmpty() && obj.getWareHouse() == null))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the PalettePlace object passed as parameter to the WareHouse attribute of each of it. 
    * 
    * @param value value    * @return The original set of ModelType objects now with the new neighbor attached to their WareHouse attributes.
    */
   public PalettePlaceSet withWareHouse(WareHouse value)
   {
      for (PalettePlace obj : this)
      {
         obj.withWareHouse(value);
      }
      
      return this;
   }

}
