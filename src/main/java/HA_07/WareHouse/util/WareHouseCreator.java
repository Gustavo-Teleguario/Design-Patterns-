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
import HA_07.WareHouse.WareHouse;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.PalettePlace;

public class WareHouseCreator implements AggregatedEntityCreator
{
   public static final WareHouseCreator it = new WareHouseCreator();
   
   private final String[] properties = new String[]
   {
      WareHouse.PROPERTY_NAME,
      WareHouse.PROPERTY_WAREHOUSE,
      WareHouse.PROPERTY_ORDERS,
      WareHouse.PROPERTY_PRODUCTS,
      WareHouse.PROPERTY_PLACES,
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
      return new WareHouse();
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

      if (WareHouse.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((WareHouse) target).getName();
      }

      if (WareHouse.PROPERTY_WAREHOUSE.equalsIgnoreCase(attribute))
      {
         return ((WareHouse) target).getWareHouse();
      }

      if (WareHouse.PROPERTY_ORDERS.equalsIgnoreCase(attribute))
      {
         return ((WareHouse) target).getOrders();
      }

      if (WareHouse.PROPERTY_PRODUCTS.equalsIgnoreCase(attribute))
      {
         return ((WareHouse) target).getProducts();
      }

      if (WareHouse.PROPERTY_PLACES.equalsIgnoreCase(attribute))
      {
         return ((WareHouse) target).getPlaces();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (WareHouse.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).setName((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((WareHouse)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (WareHouse.PROPERTY_WAREHOUSE.equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).setWareHouse((WareHouse) value);
         return true;
      }

      if (WareHouse.PROPERTY_ORDERS.equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).withOrders((WareHouse) value);
         return true;
      }
      
      if ((WareHouse.PROPERTY_ORDERS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).withoutOrders((WareHouse) value);
         return true;
      }

      if (WareHouse.PROPERTY_PRODUCTS.equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).withProducts((WareHouseProduct) value);
         return true;
      }
      
      if ((WareHouse.PROPERTY_PRODUCTS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).withoutProducts((WareHouseProduct) value);
         return true;
      }

      if (WareHouse.PROPERTY_PLACES.equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).withPlaces((PalettePlace) value);
         return true;
      }
      
      if ((WareHouse.PROPERTY_PLACES + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((WareHouse) target).withoutPlaces((PalettePlace) value);
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
      ((WareHouse) entity).removeYou();
   }
}
