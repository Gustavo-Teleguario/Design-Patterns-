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
import HA_07.WareHouse.WareHouseProduct;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.WareHouseOrder;
import HA_07.WareHouse.WareHouse;

public class WareHouseProductCreator implements AggregatedEntityCreator
{
   public static final WareHouseProductCreator it = new WareHouseProductCreator();
   
   private final String[] properties = new String[]
   {
      WareHouseProduct.PROPERTY_ID,
      WareHouseProduct.PROPERTY_NAME,
      WareHouseProduct.PROPERTY_LOTS,
      WareHouseProduct.PROPERTY_ORDERS,
      WareHouseProduct.PROPERTY_WAREHOUSE,
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
      return new WareHouseProduct();
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

      if (WareHouseProduct.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((WareHouseProduct) target).getId();
      }

      if (WareHouseProduct.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((WareHouseProduct) target).getName();
      }

      if (WareHouseProduct.PROPERTY_LOTS.equalsIgnoreCase(attribute))
      {
         return ((WareHouseProduct) target).getLots();
      }

      if (WareHouseProduct.PROPERTY_ORDERS.equalsIgnoreCase(attribute))
      {
         return ((WareHouseProduct) target).getOrders();
      }

      if (WareHouseProduct.PROPERTY_WAREHOUSE.equalsIgnoreCase(attribute))
      {
         return ((WareHouseProduct) target).getWareHouse();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (WareHouseProduct.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).setName((String) value);
         return true;
      }

      if (WareHouseProduct.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).setId((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((WareHouseProduct)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (WareHouseProduct.PROPERTY_LOTS.equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).withLots((Lot) value);
         return true;
      }
      
      if ((WareHouseProduct.PROPERTY_LOTS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).withoutLots((Lot) value);
         return true;
      }

      if (WareHouseProduct.PROPERTY_ORDERS.equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).withOrders((WareHouseOrder) value);
         return true;
      }
      
      if ((WareHouseProduct.PROPERTY_ORDERS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).withoutOrders((WareHouseOrder) value);
         return true;
      }

      if (WareHouseProduct.PROPERTY_WAREHOUSE.equalsIgnoreCase(attrName))
      {
         ((WareHouseProduct) target).setWareHouse((WareHouse) value);
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
      ((WareHouseProduct) entity).removeYou();
   }
}
