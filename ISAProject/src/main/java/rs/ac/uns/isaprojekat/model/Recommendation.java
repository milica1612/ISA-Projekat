package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Recommendation {
   private Long recommendationId;
   public Collection<Medicine> medicine;
   public Consultation consultation;
   
   public Recommendation(Long recommendationId, Consultation consultation) {
	super();
	this.recommendationId = recommendationId;
	this.medicine = new ArrayList<Medicine>();
	this.consultation = consultation;
   }

	public Long getRecommendationId() {
		return recommendationId;
	}
	
	public void setRecommendationId(Long recommendationId) {
		this.recommendationId = recommendationId;
	}
	
	public Collection<Medicine> getMedicine() {
		return medicine;
	}
	
	public void setMedicine(Collection<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	public Consultation getConsultation() {
		return consultation;
	}
	
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}	   
}