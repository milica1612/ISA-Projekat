package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient extends User {

	private static final long serialVersionUID = 6497460964207145259L;

	@Column(name = "penalty")
	private int penalty;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Allergy allergy;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "patients")
	private List<Pharmacy> pharmacies;
	
	public Patient() {
		super();
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public Allergy getAllergy() {
		return allergy;
	}

	public void setAllergy(Allergy allergy) {
		this.allergy = allergy;
	}

	public List<Pharmacy> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<Pharmacy> pharmacies) {
		this.pharmacies = pharmacies;
	}

}