package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class RateMedicine {
   private Long rateMedicineId;
   private int rating;
   public Patient patient;
   public Medicine medicine;
   
   public RateMedicine(Long rateMedicineId, int rating, Patient patient, Medicine medicine) {
		super();
		this.rateMedicineId = rateMedicineId;
		this.rating = rating;
		this.patient = patient;
		this.medicine = medicine;
   }

	public Long getRateMedicineId() {
		return rateMedicineId;
	}
	
	public void setRateMedicineId(Long rateMedicineId) {
		this.rateMedicineId = rateMedicineId;
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
	
	public Medicine getMedicine() {
		return medicine;
	}
	
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
}