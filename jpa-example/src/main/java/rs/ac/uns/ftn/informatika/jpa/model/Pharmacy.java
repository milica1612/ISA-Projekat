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
   
	@Column(name = "name")
	protected String name;
	
	@Column(name = "rating")
    protected Double rating;
	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<Pharmacist> pharmacist;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<MedicineItem> medicineItem;
	@ManyToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Dermatologist> dermatologist;
   
    public Pharmacy(Long pharmacyId, String name, Double rating) {
		super();
		this.pharmacyId = pharmacyId;
		this.name = name;
		this.rating = rating;
		this.pharmacist = new HashSet<Pharmacist>();
		this.medicineItem = new HashSet<MedicineItem>();
		this.dermatologist = new HashSet<Dermatologist>();
	}
    
    public Pharmacy()
    {
    	
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

	public Set<MedicineItem> getMedicineItem() {
		return medicineItem;
	}

	public void setMedicineItem(Set<MedicineItem> medicineItem) {
		this.medicineItem = medicineItem;
	}
	
	

}