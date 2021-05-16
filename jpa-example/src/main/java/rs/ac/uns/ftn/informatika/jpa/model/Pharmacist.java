package rs.ac.uns.ftn.informatika.jpa.model;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
public class Pharmacist extends PharmacyEmployee {
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Pharmacy pharmacy;
	   
    public Pharmacist(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, UserType userType, Address address, Double rating) {
		super(firstName, lastName, userName, password, email, phoneNumber, userType, address, rating);
		this.pharmacy = pharmacy;
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