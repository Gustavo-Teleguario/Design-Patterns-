package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.IdMap;
import HA_07.WareHouse.PalettePlace;

public class PalettePlacePOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new PalettePlacePO(new PalettePlace[]{});
      } else {
          return new PalettePlacePO();
      }
   }
   
   public static IdMap createIdMap(String sessionID) {
      return HA_07.WareHouse.util.CreatorCreator.createIdMap(sessionID);
   }
}
