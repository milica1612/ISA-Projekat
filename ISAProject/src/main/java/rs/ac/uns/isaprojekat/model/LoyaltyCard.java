package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class LoyaltyCard {
   private int points;
   private Long cardId;
   
   public Patient patient;
   public LoyaltyCategory loyaltyCategory;
   
   public LoyaltyCard(int points, Long cardId, Patient patient, LoyaltyCategory loyaltyCategory) {
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

public LoyaltyCategory getLoyaltyCategory() {
	return loyaltyCategory;
}

public void setLoyaltyCategory(LoyaltyCategory loyaltyCategory) {
	this.loyaltyCategory = loyaltyCategory;
}



}