package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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