package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Diagnosis {
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long diagnosisId;
   
   public Dermatologist dermatologist;
   public Patient patient;
	   
	public Diagnosis(Long diagnosisId, Dermatologist dermatologist, Patient patient) {
		super();
		this.diagnosisId = diagnosisId;
		this.dermatologist = dermatologist;
		this.patient = patient;
	}
	
	public Long getDiagnosisId() {
		return diagnosisId;
	}
	
	public void setDiagnosisId(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	
	public Dermatologist getDermatologist() {
		return dermatologist;
	}
	
	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}