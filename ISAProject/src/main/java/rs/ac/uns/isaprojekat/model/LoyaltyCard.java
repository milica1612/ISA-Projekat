package rs.ac.uns.isaprojekat.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class LoyaltyCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
	
	@Column(name = "points", nullable = false)
    private int points;
	
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