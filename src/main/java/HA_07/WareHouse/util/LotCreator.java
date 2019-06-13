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

import de.uniks.networkparser.interfaces.AggregatedEntityCreator;
import HA_07.WareHouse.Lot;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.PalettePlace;

public class LotCreator implements AggregatedEntityCreator
{
   public static final LotCreator it = new LotCreator();
   
   private final String[] properties = new String[]
   {
      Lot.PROPERTY_ID,
      Lot.PROPERTY_LOTSIZE,
      Lot.PROPERTY_WAREHOUSEPRODUCT,
      Lot.PROPERTY_PALETTEPLACE,
   };
   
   private final String[] upProperties = new String[]
   {
   };
   
   private final String[] downProperties = new String[]
   {
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public String[] getUpProperties()
   {
      return upProperties;
   }
   
   @Override
   public String[] getDownProperties()
   {
      return downProperties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Lot();
   }
   
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Lot.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((Lot) target).getId();
      }

      if (Lot.PROPERTY_LOTSIZE.equalsIgnoreCase(attribute))
      {
         return ((Lot) target).getLotSize();
      }

      if (Lot.PROPERTY_WAREHOUSEPRODUCT.equalsIgnoreCase(attribute))
      {
         return ((Lot) target).getWareHouseProduct();
      }

      if (Lot.PROPERTY_PALETTEPLACE.equalsIgnoreCase(attribute))
      {
         return ((Lot) target).getPalettePlace();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Lot.PROPERTY_LOTSIZE.equalsIgnoreCase(attrName))
      {
         ((Lot) target).setLotSize(Double.parseDouble(value.toString()));
         return true;
      }

      if (Lot.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((Lot) target).setId((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((Lot)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Lot.PROPERTY_WAREHOUSEPRODUCT.equalsIgnoreCase(attrName))
      {
         ((Lot) target).setWareHouseProduct((WareHouseProduct) value);
         return true;
      }

      if (Lot.PROPERTY_PALETTEPLACE.equalsIgnoreCase(attrName))
      {
         ((Lot) target).setPalettePlace((PalettePlace) value);
         return true;
      }
      
      return false;
   }
   public static IdMap createIdMap(String sessionID)
   {
      return HA_07.WareHouse.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
      public void removeObject(Object entity)
   {
      ((Lot) entity).removeYou();
   }
}
