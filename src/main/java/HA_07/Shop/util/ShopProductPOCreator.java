package HA_07.Shop.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.Shop.ShopProduct;

public class ShopProductPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ShopProductPO(new ShopProduct[]{});
      } else {
          return new ShopProductPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.Shop.util.CreatorCreator.createIdMap(sessionID);
   }
}
