package rs.ac.uns.ftn.informatika.jpa.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
public class Pharmacist extends PharmacyEmployee {
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Pharmacy pharmacy;
	
	
	public Pharmacist()
    {
    	
    }
	
    public Pharmacist(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Pharmacy pharmacy, Boolean enabled, Date lastResetPasswordDate) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address, enabled, lastResetPasswordDate);
		this.pharmacy = pharmacy;
    }

    public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

}