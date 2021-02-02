package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Pharmacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pharmacyId;
   
	@Column(name = "name", nullable = false)
	protected String name;
	
	@Column(name = "rating", nullable = false)
    protected Double rating;
	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<Pharmacist> pharmacist;
    //public MedicineItem medicineItem;
	@ManyToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Dermatologist> dermatologist;
   
    public Pharmacy(Long pharmacyId, String name, Double rating, MedicineItem medicineItem) {
		super();
		this.pharmacyId = pharmacyId;
		this.name = name;
		this.rating = rating;
		this.pharmacist = new HashSet<Pharmacist>();
		//this.medicineItem = medicineItem;
		this.dermatologist = new HashSet<Dermatologist>();
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
	public Set<Pharmacist> getPharmacist() {
		return pharmacist;
	}
	public void setPharmacist(Set<Pharmacist> pharmacist) {
		this.pharmacist = pharmacist;
	}
	public Set<Dermatologist> getDermatologist() {
		return dermatologist;
	}
	public void setDermatologist(Set<Dermatologist> dermatologist) {
		this.dermatologist = dermatologist;
	}
	

}