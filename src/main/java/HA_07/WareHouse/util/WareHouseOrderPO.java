package HA_07.WareHouse.util;

import org.sdmlib.models.pattern.PatternObject;
import HA_07.WareHouse.WareHouseOrder;
import org.sdmlib.models.pattern.AttributeConstraint;
import org.sdmlib.models.pattern.Pattern;
import HA_07.WareHouse.util.WareHouseProductPO;
import HA_07.WareHouse.WareHouseProduct;
import HA_07.WareHouse.util.WareHouseOrderPO;
import HA_07.WareHouse.util.WareHouseProductSet;

public class WareHouseOrderPO extends PatternObject<WareHouseOrderPO, WareHouseOrder>
{

    public WareHouseOrderSet allMatches()
   {
      this.setDoAllMatches(true);
      
      WareHouseOrderSet matches = new WareHouseOrderSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((WareHouseOrder) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public WareHouseOrderPO(){
      newInstance(null);
   }

   public WareHouseOrderPO(WareHouseOrder... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(null, hostGraphObject);
   }

   public WareHouseOrderPO(String modifier)
   {
      this.setModifier(modifier);
   }
   public WareHouseOrderPO createAddresseCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_ADDRESSE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseOrderPO createAddresseCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_ADDRESSE)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseOrderPO createAddresseAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_ADDRESSE)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public String getAddresse()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseOrder) getCurrentMatch()).getAddresse();
      }
      return null;
   }
   
   public WareHouseOrderPO withAddresse(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((WareHouseOrder) getCurrentMatch()).setAddresse(value);
      }
      return this;
   }
   
   public WareHouseOrderPO createIdCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_ID)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseOrderPO createIdCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_ID)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseOrderPO createIdAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_ID)
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
         return ((WareHouseOrder) getCurrentMatch()).getId();
      }
      return null;
   }
   
   public WareHouseOrderPO withId(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((WareHouseOrder) getCurrentMatch()).setId(value);
      }
      return this;
   }
   
   public WareHouseOrderPO createProductCondition(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_PRODUCT)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseOrderPO createProductCondition(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_PRODUCT)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public WareHouseOrderPO createProductAssignment(String value)
   {
      new AttributeConstraint()
      .withAttrName(WareHouseOrder.PROPERTY_PRODUCT)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(Pattern.CREATE)
      .withPattern(this.getPattern());
      
      super.filterAttr();
      
      return this;
   }
   
   public String getProduct()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseOrder) getCurrentMatch()).getProduct();
      }
      return null;
   }
   
   public WareHouseOrderPO withProduct(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((WareHouseOrder) getCurrentMatch()).setProduct(value);
      }
      return this;
   }
   
   public WareHouseProductPO createProductsPO()
   {
      WareHouseProductPO result = new WareHouseProductPO(new WareHouseProduct[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(WareHouseOrder.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public WareHouseProductPO createProductsPO(String modifier)
   {
      WareHouseProductPO result = new WareHouseProductPO(new WareHouseProduct[]{});
      
      result.setModifier(modifier);
      super.hasLink(WareHouseOrder.PROPERTY_PRODUCTS, result);
      
      return result;
   }

   public WareHouseOrderPO createProductsLink(WareHouseProductPO tgt)
   {
      return hasLinkConstraint(tgt, WareHouseOrder.PROPERTY_PRODUCTS);
   }

   public WareHouseOrderPO createProductsLink(WareHouseProductPO tgt, String modifier)
   {
      return hasLinkConstraint(tgt, WareHouseOrder.PROPERTY_PRODUCTS, modifier);
   }

   public WareHouseProductSet getProducts()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((WareHouseOrder) this.getCurrentMatch()).getProducts();
      }
      return null;
   }

}
