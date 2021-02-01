package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 6c7adbf6-89a9-43e5-be82-07610c2bf4c2 */
public class LoyaltyCard {
   /** @pdOid 28a713b0-aa15-495b-9eff-df7875b53222 */
   private int points;
   /** @pdOid 8be2d33f-3c69-4bcc-b659-8d7cfda63f17 */
   private Long cardId;
   
   /** @pdRoleInfo migr=no name=Patient assc=association31 mult=0..1 */
   public Patient patient;
   /** @pdRoleInfo migr=no name=LoyaltyCategory assc=association33 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<LoyaltyCategory> loyaltyCategory;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<LoyaltyCategory> getLoyaltyCategory() {
      if (loyaltyCategory == null)
         loyaltyCategory = new java.util.HashSet<LoyaltyCategory>();
      return loyaltyCategory;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLoyaltyCategory() {
      if (loyaltyCategory == null)
         loyaltyCategory = new java.util.HashSet<LoyaltyCategory>();
      return loyaltyCategory.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLoyaltyCategory */
   public void setLoyaltyCategory(java.util.Collection<LoyaltyCategory> newLoyaltyCategory) {
      removeAllLoyaltyCategory();
      for (java.util.Iterator iter = newLoyaltyCategory.iterator(); iter.hasNext();)
         addLoyaltyCategory((LoyaltyCategory)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLoyaltyCategory */
   public void addLoyaltyCategory(LoyaltyCategory newLoyaltyCategory) {
      if (newLoyaltyCategory == null)
         return;
      if (this.loyaltyCategory == null)
         this.loyaltyCategory = new java.util.HashSet<LoyaltyCategory>();
      if (!this.loyaltyCategory.contains(newLoyaltyCategory))
         this.loyaltyCategory.add(newLoyaltyCategory);
   }
   
   /** @pdGenerated default remove
     * @param oldLoyaltyCategory */
   public void removeLoyaltyCategory(LoyaltyCategory oldLoyaltyCategory) {
      if (oldLoyaltyCategory == null)
         return;
      if (this.loyaltyCategory != null)
         if (this.loyaltyCategory.contains(oldLoyaltyCategory))
            this.loyaltyCategory.remove(oldLoyaltyCategory);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLoyaltyCategory() {
      if (loyaltyCategory != null)
         loyaltyCategory.clear();
   }

}