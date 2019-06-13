package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.Lot;

public class LotPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new LotPO(new Lot[]{});
      } else {
          return new LotPO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.WareHouse.util.CreatorCreator.createIdMap(sessionID);
   }
}
