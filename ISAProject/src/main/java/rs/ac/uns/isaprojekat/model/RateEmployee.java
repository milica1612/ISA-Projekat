package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class RateEmployee {
   private Long rateId;
   private int rating;
   public Patient patient;
   public PharmacyEmployee pharmacyEmployee;
   
   public RateEmployee(Long rateId, int rating, Patient patient, PharmacyEmployee pharmacyEmployee) {
		super();
		this.rateId = rateId;
		this.rating = rating;
		this.patient = patient;
		this.pharmacyEmployee = pharmacyEmployee;
   }
	
	public Long getRateId() {
		return rateId;
	}
	
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public PharmacyEmployee getPharmacyEmployee() {
		return pharmacyEmployee;
	}
	
	public void setPharmacyEmployee(PharmacyEmployee pharmacyEmployee) {
		this.pharmacyEmployee = pharmacyEmployee;
	}

}