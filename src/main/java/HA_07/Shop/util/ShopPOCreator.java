package HA_07.Shop.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.Shop;

public class ShopPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ShopPO(new Shop[]{});
      } else {
          return new ShopPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.Shop.util.CreatorCreator.createIdMap(sessionID);
   }
}
