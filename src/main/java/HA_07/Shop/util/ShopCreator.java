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
import HA_07.Shop.Shop;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.ShopOrder;

public class ShopCreator implements AggregatedEntityCreator
{
   public static final ShopCreator it = new ShopCreator();
   
   private final String[] properties = new String[]
   {
      Shop.PROPERTY_PRODUCTS,
      Shop.PROPERTY_CUSTOMERS,
      Shop.PROPERTY_ORDERS,
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
      return new Shop();
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

      if (Shop.PROPERTY_PRODUCTS.equalsIgnoreCase(attribute))
      {
         return ((Shop) target).getProducts();
      }

      if (Shop.PROPERTY_CUSTOMERS.equalsIgnoreCase(attribute))
      {
         return ((Shop) target).getCustomers();
      }

      if (Shop.PROPERTY_ORDERS.equalsIgnoreCase(attribute))
      {
         return ((Shop) target).getOrders();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((Shop)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Shop.PROPERTY_PRODUCTS.equalsIgnoreCase(attrName))
      {
         ((Shop) target).withProducts((ShopProduct) value);
         return true;
      }
      
      if ((Shop.PROPERTY_PRODUCTS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Shop) target).withoutProducts((ShopProduct) value);
         return true;
      }

      if (Shop.PROPERTY_CUSTOMERS.equalsIgnoreCase(attrName))
      {
         ((Shop) target).withCustomers((ShopCustomer) value);
         return true;
      }
      
      if ((Shop.PROPERTY_CUSTOMERS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Shop) target).withoutCustomers((ShopCustomer) value);
         return true;
      }

      if (Shop.PROPERTY_ORDERS.equalsIgnoreCase(attrName))
      {
         ((Shop) target).withOrders((ShopOrder) value);
         return true;
      }
      
      if ((Shop.PROPERTY_ORDERS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Shop) target).withoutOrders((ShopOrder) value);
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
      ((Shop) entity).removeYou();
   }
}
