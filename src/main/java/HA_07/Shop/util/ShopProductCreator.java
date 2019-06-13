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
import HA_07.Shop.ShopProduct;
import de.uniks.networkparser.list.ObjectSet;
import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopOrder;
import HA_07.Shop.Shop;

public class ShopProductCreator implements AggregatedEntityCreator
{
   public static final ShopProductCreator it = new ShopProductCreator();
   
   private final String[] properties = new String[]
   {
      ShopProduct.PROPERTY_ID,
      ShopProduct.PROPERTY_INSTOCK,
      ShopProduct.PROPERTY_NAME,
      ShopProduct.PROPERTY_PRICE,
      ShopProduct.PROPERTY_ORDERS,
      ShopProduct.PROPERTY_SHOP,
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
      return new ShopProduct();
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

      if (ShopProduct.PROPERTY_ID.equalsIgnoreCase(attribute))
      {
         return ((ShopProduct) target).getId();
      }

      if (ShopProduct.PROPERTY_INSTOCK.equalsIgnoreCase(attribute))
      {
         return ((ShopProduct) target).getInStock();
      }

      if (ShopProduct.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((ShopProduct) target).getName();
      }

      if (ShopProduct.PROPERTY_PRICE.equalsIgnoreCase(attribute))
      {
         return ((ShopProduct) target).getPrice();
      }

      if (ShopProduct.PROPERTY_ORDERS.equalsIgnoreCase(attribute))
      {
         return ((ShopProduct) target).getOrders();
      }

      if (ShopProduct.PROPERTY_SHOP.equalsIgnoreCase(attribute))
      {
         return ((ShopProduct) target).getShop();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (ShopProduct.PROPERTY_PRICE.equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).setPrice(Double.parseDouble(value.toString()));
         return true;
      }

      if (ShopProduct.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).setName((String) value);
         return true;
      }

      if (ShopProduct.PROPERTY_INSTOCK.equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).setInStock(Double.parseDouble(value.toString()));
         return true;
      }

      if (ShopProduct.PROPERTY_ID.equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).setId((String) value);
         return true;
      }

      if(SendableEntityCreator.REMOVE_YOU.equals(type)) {
           ((ShopProduct)target).removeYou();
           return true;
      }
      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (ShopProduct.PROPERTY_ORDERS.equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).withOrders((ShopOrder) value);
         return true;
      }
      
      if ((ShopProduct.PROPERTY_ORDERS + SendableEntityCreator.REMOVE).equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).withoutOrders((ShopOrder) value);
         return true;
      }

      if (ShopProduct.PROPERTY_SHOP.equalsIgnoreCase(attrName))
      {
         ((ShopProduct) target).setShop((Shop) value);
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
      ((ShopProduct) entity).removeYou();
   }
}
