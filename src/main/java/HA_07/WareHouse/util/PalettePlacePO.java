package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.WareHouse.PalettePlace;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.WareHouse.util.LotPO;
import HA_07.WareHouse.Lot;
import HA_07.WareHouse.util.PalettePlacePO;
import HA_07.WareHouse.util.WareHousePO;
import HA_07.WareHouse.WareHouse;

public class PalettePlacePO extends PatternObject<PalettePlacePO, PalettePlace>
{

    public PalettePlaceSet allMatches()
   {
      this.setDoAllMatches(true);
      
      PalettePlaceSet matches = new PalettePlaceSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((PalettePlace) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public PalettePlacePO(){
      newInstance(null);
   }

   public PalettePlacePO(PalettePlace... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public PalettePlacePO(String modifier)
   {
      this.setModifier(modifier);
   }
   public PalettePlacePO createColumnCondition(double value)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_COLUMN)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public PalettePlacePO createColumnCondition(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_COLUMN)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public PalettePlacePO createColumnAssignment(double value)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_COLUMN)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public double getColumn()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PalettePlace) getCurrentMatch()).getColumn();
      }
      return 0;
   }
   
   public PalettePlacePO withColumn(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PalettePlace) getCurrentMatch()).setColumn(value);
      }
      return this;
   }
   
   public PalettePlacePO createIdCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public PalettePlacePO createIdCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_ID)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public PalettePlacePO createIdAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_ID)
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
         return ((PalettePlace) getCurrentMatch()).getId();
      }
      return null;
   }
   
   public PalettePlacePO withId(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PalettePlace) getCurrentMatch()).setId(value);
      }
      return this;
   }
   
   public PalettePlacePO createRowCondition(double value)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_ROW)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public PalettePlacePO createRowCondition(double lower, double upper)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_ROW)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public PalettePlacePO createRowAssignment(double value)
   {
      new AttributeConstraint()
      .withAttrName(PalettePlace.PROPERTY_ROW)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public double getRow()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PalettePlace) getCurrentMatch()).getRow();
      }
      return 0;
   }
   
   public PalettePlacePO withRow(double value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((PalettePlace) getCurrentMatch()).setRow(value);
      }
      return this;
   }
   
   public LotPO createLotPO()
   {
      LotPO result = new LotPO(new Lot[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(PalettePlace.PROPERTY_LOT, result);
      
      return result;
   }

   public LotPO createLotPO(String modifier)
   {
      LotPO result = new LotPO(new Lot[]{});
      
      result.setModifier(modifier);
      super.hasLink(PalettePlace.PROPERTY_LOT, result);
      
      return result;
   }

   public PalettePlacePO createLotLink(LotPO tgt)
   {
      return hasLinkConstraint(tgt, PalettePlace.PROPERTY_LOT);
   }

   public PalettePlacePO createLotLink(LotPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, PalettePlace.PROPERTY_LOT, modifier);
   }

   public Lot getLot()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PalettePlace) this.getCurrentMatch()).getLot();
      }
      return null;
   }

   public WareHousePO createWareHousePO()
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(PalettePlace.PROPERTY_WAREHOUSE, result);
      
      return result;
   }

   public WareHousePO createWareHousePO(String modifier)
   {
      WareHousePO result = new WareHousePO(new WareHouse[]{});
      
      result.setModifier(modifier);
      super.hasLink(PalettePlace.PROPERTY_WAREHOUSE, result);
      
      return result;
   }

   public PalettePlacePO createWareHouseLink(WareHousePO tgt)
   {
      return hasLinkConstraint(tgt, PalettePlace.PROPERTY_WAREHOUSE);
   }

   public PalettePlacePO createWareHouseLink(WareHousePO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, PalettePlace.PROPERTY_WAREHOUSE, modifier);
   }

   public WareHouse getWareHouse()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((PalettePlace) this.getCurrentMatch()).getWareHouse();
      }
      return null;
   }

}
