package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.WareHouseOrder;

public class WareHouseOrderPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new WareHouseOrderPO(new WareHouseOrder[]{});
      } else {
          return new WareHouseOrderPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.WareHouse.util.CreatorCreator.createIdMap(sessionID);
   }
}
