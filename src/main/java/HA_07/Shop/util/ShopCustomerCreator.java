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

import de.uniks.networkparser.interfaces.AggregatedEntityCreator;
import HA_07.Shop.ShopCustomer;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.Shop;

public class ShopCustomerCreator implements AggregatedEntityCreator
{
   public static final ShopCustomerCreator it = new ShopCustomerCreator();
   
   private final String[] properties = new String[]
   {
      ShopCustomer.PROPERTY_ADDRESSE,
      ShopCustomer.PROPERTY_NAME,
      ShopCustomer.PROPERTY_ORDERS,
      ShopCustomer.PROPERTY_SHOP,
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
      return new ShopCustomer();
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

      if (ShopCustomer.PROPERTY_ADDRESSE.equalsIgnoreCase(attribute))
      {
         return ((ShopCustomer) target).getAddresse();
      }

      if (ShopCustomer.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((ShopCustomer) target).getName();
      }

      if (ShopCustomer.PROPERTY_ORDERS.equalsIgnoreCase(attribute))
      {
         return ((ShopCustomer) target).getOrders();
      }

      if (ShopCustomer.PROPERTY_SHOP.equalsIgnoreCase(attribute))
      {
         return ((ShopCustomer) target).getShop();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (ShopCustomer.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((ShopCustomer) target).setName((String) value);
         return true;
      }

      if (ShopCustomer.PROPERTY_ADDRESSE.equalsIgnoreCase(attrName))
      {
         ((ShopCustomer) target).setAddresse((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((ShopCustomer)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (ShopCustomer.PROPERTY_ORDERS.equalsIgnoreCase(attrName))
      {
         ((ShopCustomer) target).withOrders((ShopOrder) value);
         return true;
      }
      
      if ((ShopCustomer.PROPERTY_ORDERS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((ShopCustomer) target).withoutOrders((ShopOrder) value);
         return true;
      }

      if (ShopCustomer.PROPERTY_SHOP.equalsIgnoreCase(attrName))
      {
         ((ShopCustomer) target).setShop((Shop) value);
         return true;
      }
      
      return false;
   }
   public static IdMap createIdMap(String sessionID)
   {
      return HA_07.Shop.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
      public void removeObject(Object entity)
   {
      ((ShopCustomer) entity).removeYou();
   }
}
