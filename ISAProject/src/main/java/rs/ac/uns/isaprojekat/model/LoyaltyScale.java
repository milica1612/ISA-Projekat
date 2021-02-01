package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class LoyaltyScale {
   private Long scaleId;
   private int from;
   private int to;   
   public LoyaltyCategory loyaltyCategory;
   
public LoyaltyScale(Long scaleId, int from, int to, LoyaltyCategory loyaltyCategory) {
	super();
	this.scaleId = scaleId;
	this.from = from;
	this.to = to;
	this.loyaltyCategory = loyaltyCategory;
}
public Long getScaleId() {
	return scaleId;
}
public void setScaleId(Long scaleId) {
	this.scaleId = scaleId;
}
public int getFrom() {
	return from;
}
public void setFrom(int from) {
	this.from = from;
}
public int getTo() {
	return to;
}
public void setTo(int to) {
	this.to = to;
}
public LoyaltyCategory getLoyaltyCategory() {
	return loyaltyCategory;
}
public void setLoyaltyCategory(LoyaltyCategory loyaltyCategory) {
	this.loyaltyCategory = loyaltyCategory;
}

}