package HA_07.WareHouse.util;

import de.uniks.networkparser.IdMap;

class CreatorCreator{

   public static IdMap createIdMap(String session)
   {
      IdMap jsonIdMap = new IdMap().withSession(session);
      jsonIdMap.with(new LotCreator());
      jsonIdMap.with(new LotPOCreator());
      jsonIdMap.with(new PalettePlaceCreator());
      jsonIdMap.with(new PalettePlacePOCreator());
      jsonIdMap.with(new WareHouseCreator());
      jsonIdMap.with(new WareHousePOCreator());
      jsonIdMap.with(new WareHouseOrderCreator());
      jsonIdMap.with(new WareHouseOrderPOCreator());
      jsonIdMap.with(new WareHouseProductCreator());
      jsonIdMap.with(new WareHouseProductPOCreator());
      return jsonIdMap;
   }
}
