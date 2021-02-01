package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Pharmacy {
   private Long pharmacyId;
   protected String name;
   protected Double rating;
   public Pharmacist pharmacist;
   public MedicineItem medicineItem;
   public Dermatologist dermatologist;
   
   public Pharmacy(Long pharmacyId, String name, Double rating, Pharmacist pharmacist, MedicineItem medicineItem,
		Dermatologist dermatologist) {
		super();
		this.pharmacyId = pharmacyId;
		this.name = name;
		this.rating = rating;
		this.pharmacist = pharmacist;
		this.medicineItem = medicineItem;
		this.dermatologist = dermatologist;
	}
	public Long getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Pharmacist getPharmacist() {
		return pharmacist;
	}
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}
	public MedicineItem getMedicineItem() {
		return medicineItem;
	}
	public void setMedicineItem(MedicineItem medicineItem) {
		this.medicineItem = medicineItem;
	}
	public Dermatologist getDermatologist() {
		return dermatologist;
	}
	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}

}