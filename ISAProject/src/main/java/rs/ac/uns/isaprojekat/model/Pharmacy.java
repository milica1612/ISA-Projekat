package rs.ac.uns.isaprojekat.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pharmacyId;
   
	@Column(name = "name", nullable = false)
	protected String name;
	
	@Column(name = "rating", nullable = false)
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