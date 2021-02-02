package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Recommendation {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
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