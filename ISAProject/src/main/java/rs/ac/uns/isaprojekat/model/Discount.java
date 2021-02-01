package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Discount {
   private int percent;
   private Long discountId;
   public LoyaltyCategory loyaltyCategory;
   
public Discount(int percent, Long discountId, LoyaltyCategory loyaltyCategory) {
	super();
	this.percent = percent;
	this.discountId = discountId;
	this.loyaltyCategory = loyaltyCategory;
}
public int getPercent() {
	return percent;
}
public void setPercent(int percent) {
	this.percent = percent;
}
public Long getDiscountId() {
	return discountId;
}
public void setDiscountId(Long discountId) {
	this.discountId = discountId;
}
public LoyaltyCategory getLoyaltyCategory() {
	return loyaltyCategory;
}
public void setLoyaltyCategory(LoyaltyCategory loyaltyCategory) {
	this.loyaltyCategory = loyaltyCategory;
}
   
   

}