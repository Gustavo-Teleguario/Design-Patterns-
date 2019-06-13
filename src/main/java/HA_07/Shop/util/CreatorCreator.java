package HA_07.Shop.util;

import de.uniks.networkparser.IdMap;

class CreatorCreator{

   public static IdMap createIdMap(String session)
   {
      IdMap jsonIdMap = new IdMap().withSession(session);
      jsonIdMap.with(new ShopCreator());
      jsonIdMap.with(new ShopPOCreator());
      jsonIdMap.with(new ShopCustomerCreator());
      jsonIdMap.with(new ShopCustomerPOCreator());
      jsonIdMap.with(new ShopOrderCreator());
      jsonIdMap.with(new ShopOrderPOCreator());
      jsonIdMap.with(new ShopProductCreator());
      jsonIdMap.with(new ShopProductPOCreator());
      return jsonIdMap;
   }
}
