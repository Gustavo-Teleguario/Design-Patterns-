package HA_07.Shop.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopOrder;

public class ShopOrderPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ShopOrderPO(new ShopOrder[]{});
      } else {
          return new ShopOrderPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.Shop.util.CreatorCreator.createIdMap(sessionID);
   }
}
