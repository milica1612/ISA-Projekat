package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pharmacist extends PharmacyEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phharmacyId;
	public Pharmacy pharmacy;
	   
    public Pharmacist(Double rating) {
		super(rating);
		// TODO Auto-generated constructor stub
	}

    public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

}