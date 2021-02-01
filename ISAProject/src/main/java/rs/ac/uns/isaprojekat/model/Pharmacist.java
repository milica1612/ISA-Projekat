package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Pharmacist extends PharmacyEmployee {

	public Pharmacy[] pharmacy;
	   
    public Pharmacist(Double rating) {
		super(rating);
		// TODO Auto-generated constructor stub
	}

    public Pharmacy[] getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy[] pharmacy) {
		this.pharmacy = pharmacy;
	}

}