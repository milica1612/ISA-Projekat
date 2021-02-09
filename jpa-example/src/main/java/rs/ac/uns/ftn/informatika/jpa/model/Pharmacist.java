package rs.ac.uns.ftn.informatika.jpa.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
public class Pharmacist extends PharmacyEmployee {

	@ManyToOne(fetch = FetchType.LAZY)
	public Pharmacy pharmacy;
	   
   
    public Pharmacist(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Pharmacy pharmacy) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
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