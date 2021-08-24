package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.List;
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
	@Column(name = "pharmacy_id", unique = true, nullable = false)
	private Long pharmacyId;

	@Column(name = "name")
	protected String name;

	@Column(name = "rating")
	protected Double rating;

	@Column(name = "description")
	protected String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Pharmacist> pharmacist;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Set<MedicineItem> medicineItem;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Dermatologist> dermatologist;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Set<PharmacyAdministrator> phAdministrators;
	
	@OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Promotion> promotions;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	private Address address;

	public Pharmacy() {
	}

	public Pharmacy(Long pharmacyId, String name, Double rating) {
		super();
		this.pharmacyId = pharmacyId;
		this.name = name;
		this.rating = rating;
		this.pharmacist = new HashSet<Pharmacist>();
		this.dermatologist = new HashSet<Dermatologist>();
		this.phAdministrators = new HashSet<PharmacyAdministrator>();
		this.medicineItem = new HashSet<MedicineItem>();
	}

	public Pharmacy(String name, Double rating) {
		super();
		this.name = name;
		this.rating = rating;
		this.pharmacist = new HashSet<Pharmacist>();
		this.dermatologist = new HashSet<Dermatologist>();
		this.phAdministrators = new HashSet<PharmacyAdministrator>();
		this.medicineItem = new HashSet<MedicineItem>();
	}

	public Set<PharmacyAdministrator> getPhAdministrators() {
		return phAdministrators;
	}

	public void setPhAdministrators(Set<PharmacyAdministrator> phAdministrators) {
		this.phAdministrators = phAdministrators;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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