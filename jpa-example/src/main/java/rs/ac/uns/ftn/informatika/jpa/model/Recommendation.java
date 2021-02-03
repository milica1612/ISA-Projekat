package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Recommendation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;
    
	@OneToMany(fetch = FetchType.LAZY)
	public Set<Medicine> medicine;
	
	@OneToOne(fetch = FetchType.LAZY)
    public Consultation consultation;
   
    public Recommendation(Long recommendationId, Consultation consultation) {
		super();
		this.recommendationId = recommendationId;
		this.medicine = new HashSet<Medicine>();
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
	
	public void setMedicine(Set<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	public Consultation getConsultation() {
		return consultation;
	}
	
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}	   
}