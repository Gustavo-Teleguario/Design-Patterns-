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
import HA_07.Shop.ShopOrder;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopCustomer;
import HA_07.Shop.ShopProduct;
import HA_07.Shop.Shop;

public class ShopOrderCreator implements AggregatedEntityCreator
{
   public static final ShopOrderCreator it = new ShopOrderCreator();
   
   private final String[] properties = new String[]
   {
      ShopOrder.PROPERTY_ID,
      ShopOrder.PROPERTY_SHOPCUSTOMER,
      ShopOrder.PROPERTY_PRODUCTS,
      ShopOrder.PROPERTY_SHOP,
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
      return new ShopOrder();
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

      if (ShopOrder.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((ShopOrder) target).getId();
      }

      if (ShopOrder.PROPERTY_SHOPCUSTOMER.equalsIgnoreCase(attribute))
      {
         return ((ShopOrder) target).getShopCustomer();
      }

      if (ShopOrder.PROPERTY_PRODUCTS.equalsIgnoreCase(attribute))
      {
         return ((ShopOrder) target).getProducts();
      }

      if (ShopOrder.PROPERTY_SHOP.equalsIgnoreCase(attribute))
      {
         return ((ShopOrder) target).getShop();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (ShopOrder.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((ShopOrder) target).setId((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((ShopOrder)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (ShopOrder.PROPERTY_SHOPCUSTOMER.equalsIgnoreCase(attrName))
      {
         ((ShopOrder) target).setShopCustomer((ShopCustomer) value);
         return true;
      }

      if (ShopOrder.PROPERTY_PRODUCTS.equalsIgnoreCase(attrName))
      {
         ((ShopOrder) target).withProducts((ShopProduct) value);
         return true;
      }
      
      if ((ShopOrder.PROPERTY_PRODUCTS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((ShopOrder) target).withoutProducts((ShopProduct) value);
         return true;
      }

      if (ShopOrder.PROPERTY_SHOP.equalsIgnoreCase(attrName))
      {
         ((ShopOrder) target).setShop((Shop) value);
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
      ((ShopOrder) entity).removeYou();
   }
}
