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
import HA_07.WareHouse.WareHouseOrder;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.WareHouseProduct;

public class WareHouseOrderCreator implements AggregatedEntityCreator
{
   public static final WareHouseOrderCreator it = new WareHouseOrderCreator();
   
   private final String[] properties = new String[]
   {
      WareHouseOrder.PROPERTY_ADDRESSE,
      WareHouseOrder.PROPERTY_ID,
      WareHouseOrder.PROPERTY_PRODUCT,
      WareHouseOrder.PROPERTY_PRODUCTS,
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
      return new WareHouseOrder();
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

      if (WareHouseOrder.PROPERTY_ADDRESSE.equalsIgnoreCase(attribute))
      {
         return ((WareHouseOrder) target).getAddresse();
      }

      if (WareHouseOrder.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((WareHouseOrder) target).getId();
      }

      if (WareHouseOrder.PROPERTY_PRODUCT.equalsIgnoreCase(attribute))
      {
         return ((WareHouseOrder) target).getProduct();
      }

      if (WareHouseOrder.PROPERTY_PRODUCTS.equalsIgnoreCase(attribute))
      {
         return ((WareHouseOrder) target).getProducts();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (WareHouseOrder.PROPERTY_PRODUCT.equalsIgnoreCase(attrName))
      {
         ((WareHouseOrder) target).setProduct((String) value);
         return true;
      }

      if (WareHouseOrder.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((WareHouseOrder) target).setId((String) value);
         return true;
      }

      if (WareHouseOrder.PROPERTY_ADDRESSE.equalsIgnoreCase(attrName))
      {
         ((WareHouseOrder) target).setAddresse((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((WareHouseOrder)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (WareHouseOrder.PROPERTY_PRODUCTS.equalsIgnoreCase(attrName))
      {
         ((WareHouseOrder) target).withProducts((WareHouseProduct) value);
         return true;
      }
      
      if ((WareHouseOrder.PROPERTY_PRODUCTS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((WareHouseOrder) target).withoutProducts((WareHouseProduct) value);
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
      ((WareHouseOrder) entity).removeYou();
   }
}
