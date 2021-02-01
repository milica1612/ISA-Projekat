package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class LoyaltyCard {
   private int points;
   private Long cardId;
   
   public Patient patient;
   public java.util.Collection<LoyaltyCategory> loyaltyCategory;
   
   public LoyaltyCard(int points, Long cardId, Patient patient, Collection<LoyaltyCategory> loyaltyCategory) {
	super();
	this.points = points;
	this.cardId = cardId;
	this.patient = patient;
	this.loyaltyCategory = loyaltyCategory;
}

public int getPoints() {
	return points;
}

public void setPoints(int points) {
	this.points = points;
}

public Long getCardId() {
	return cardId;
}

public void setCardId(Long cardId) {
	this.cardId = cardId;
}

public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}

public java.util.Collection<LoyaltyCategory> getLoyaltyCategory() {
      if (loyaltyCategory == null)
         loyaltyCategory = new java.util.HashSet<LoyaltyCategory>();
      return loyaltyCategory;
   }
   
   public java.util.Iterator getIteratorLoyaltyCategory() {
      if (loyaltyCategory == null)
         loyaltyCategory = new java.util.HashSet<LoyaltyCategory>();
      return loyaltyCategory.iterator();
   }
   
   public void setLoyaltyCategory(java.util.Collection<LoyaltyCategory> newLoyaltyCategory) {
      removeAllLoyaltyCategory();
      for (java.util.Iterator iter = newLoyaltyCategory.iterator(); iter.hasNext();)
         addLoyaltyCategory((LoyaltyCategory)iter.next());
   }
   
   public void addLoyaltyCategory(LoyaltyCategory newLoyaltyCategory) {
      if (newLoyaltyCategory == null)
         return;
      if (this.loyaltyCategory == null)
         this.loyaltyCategory = new java.util.HashSet<LoyaltyCategory>();
      if (!this.loyaltyCategory.contains(newLoyaltyCategory))
         this.loyaltyCategory.add(newLoyaltyCategory);
   }
   
   public void removeLoyaltyCategory(LoyaltyCategory oldLoyaltyCategory) {
      if (oldLoyaltyCategory == null)
         return;
      if (this.loyaltyCategory != null)
         if (this.loyaltyCategory.contains(oldLoyaltyCategory))
            this.loyaltyCategory.remove(oldLoyaltyCategory);
   }
   
   public void removeAllLoyaltyCategory() {
      if (loyaltyCategory != null)
         loyaltyCategory.clear();
   }

}