package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.WareHouse;

public class WareHousePOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new WareHousePO(new WareHouse[]{});
      } else {
          return new WareHousePO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.WareHouse.util.CreatorCreator.createIdMap(sessionID);
   }
}
