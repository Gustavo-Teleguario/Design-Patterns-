package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.WareHouseProduct;

public class WareHouseProductPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new WareHouseProductPO(new WareHouseProduct[]{});
      } else {
          return new WareHouseProductPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.WareHouse.util.CreatorCreator.createIdMap(sessionID);
   }
}
