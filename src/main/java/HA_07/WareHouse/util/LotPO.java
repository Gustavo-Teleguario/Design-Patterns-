package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.WareHouse.Lot;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.WareHouse.util.WareHouseProductPO;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.util.LotPO;
import HA_07.WareHouse.util.PalettePlacePO;
import HA_07.WareHouse.PalettePlace;

public class LotPO extends PatternObject<LotPO, Lot>
{

    public LotSet allMatches()
   {
      this.setDoAllMatches(true);
      
      LotSet matches = new LotSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Lot) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public LotPO(){
      newInstance(null);
   }

   public LotPO(Lot... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public LotPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public LotPO createIdCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(Lot.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public LotPO createIdCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(Lot.PROPERTY_ID)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public LotPO createIdAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(Lot.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public String getId()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Lot) getCurrentMatch()).getId();
      }
      return null;
   }
   
   public LotPO withId(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Lot) getCurrentMatch()).setId(value);
      }
      return this;
   }
   
   public LotPO createLotSizeCondition(double value)
   {
      new AttributeConstraint()
      .withAttrName(Lot.PROPERTY_LOTSIZE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public LotPO createLotSizeCondition(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(Lot.PROPERTY_LOTSIZE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public LotPO createLotSizeAssignment(double value)
   {
      new AttributeConstraint()
      .withAttrName(Lot.PROPERTY_LOTSIZE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public double getLotSize()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Lot) getCurrentMatch()).getLotSize();
      }
      return 0;
   }
   
   public LotPO withLotSize(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Lot) getCurrentMatch()).setLotSize(value);
      }
      return this;
   }
   
   public WareHouseProductPO createWareHouseProductPO()
   {
      WareHouseProductPO result = new WareHouseProductPO(new WareHouseProduct[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Lot.PROPERTY_WAREHOUSEPRODUCT, result);
      
      return result;
   }

   public WareHouseProductPO createWareHouseProductPO(String modifier)
   {
      WareHouseProductPO result = new WareHouseProductPO(new WareHouseProduct[]{});
      
      result.setModifier(modifier);
      super.hasLink(Lot.PROPERTY_WAREHOUSEPRODUCT, result);
      
      return result;
   }

   public LotPO createWareHouseProductLink(WareHouseProductPO tgt)
   {
      return hasLinkConstraint(tgt, Lot.PROPERTY_WAREHOUSEPRODUCT);
   }

   public LotPO createWareHouseProductLink(WareHouseProductPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, Lot.PROPERTY_WAREHOUSEPRODUCT, modifier);
   }

   public WareHouseProduct getWareHouseProduct()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Lot) this.getCurrentMatch()).getWareHouseProduct();
      }
      return null;
   }

   public PalettePlacePO createPalettePlacePO()
   {
      PalettePlacePO result = new PalettePlacePO(new PalettePlace[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Lot.PROPERTY_PALETTEPLACE, result);
      
      return result;
   }

   public PalettePlacePO createPalettePlacePO(String modifier)
   {
      PalettePlacePO result = new PalettePlacePO(new PalettePlace[]{});
      
      result.setModifier(modifier);
      super.hasLink(Lot.PROPERTY_PALETTEPLACE, result);
      
      return result;
   }

   public LotPO createPalettePlaceLink(PalettePlacePO tgt)
   {
      return hasLinkConstraint(tgt, Lot.PROPERTY_PALETTEPLACE);
   }

   public LotPO createPalettePlaceLink(PalettePlacePO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, Lot.PROPERTY_PALETTEPLACE, modifier);
   }

   public PalettePlace getPalettePlace()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Lot) this.getCurrentMatch()).getPalettePlace();
      }
      return null;
   }

}
