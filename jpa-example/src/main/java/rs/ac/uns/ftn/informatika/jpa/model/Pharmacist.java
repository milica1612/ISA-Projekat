package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Pharmacist extends PharmacyEmployee {

	@ManyToOne(fetch = FetchType.LAZY)
	public Pharmacy pharmacy;
	   
    public Pharmacist(Double rating) {
		super(rating);
		// TODO Auto-generated constructor stub
	}
    
    public Pharmacist()
    {
    	
    }

    public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

}