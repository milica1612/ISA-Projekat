package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	

	@Column(name = "description")
    protected String description;
	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Pharmacist> pharmacist = new HashSet<Pharmacist>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<MedicineItem> medicineItem = new HashSet<MedicineItem>();
	@ManyToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Dermatologist> dermatologist =  new HashSet<Dermatologist>();
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<PharmacyAdministrator> phAdministrators = new HashSet<PharmacyAdministrator>();
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="adress_id", referencedColumnName = "addressId", nullable=false)
	private Address adress;
   
    public Pharmacy(Long pharmacyId, String name, Double rating) {
		super();
		this.pharmacyId = pharmacyId;
		this.name = name;
		this.rating = rating;
		this.pharmacist = new HashSet<Pharmacist>();
		this.medicineItem = new HashSet<MedicineItem>();
		this.dermatologist = new HashSet<Dermatologist>();
	}
    
    public Pharmacy(String name, Double rating) {
		super();
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
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PharmacyAdministrator> getPhAdministrators() {
		return phAdministrators;
	}

	public void setPhAdministrators(Set<PharmacyAdministrator> phAdministrators) {
		this.phAdministrators = phAdministrators;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	
}