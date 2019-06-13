package HA_07.Shop.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopCustomer;

public class ShopCustomerPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ShopCustomerPO(new ShopCustomer[]{});
      } else {
          return new ShopCustomerPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.Shop.util.CreatorCreator.createIdMap(sessionID);
   }
}
