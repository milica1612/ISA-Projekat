package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
public class PharmacyAdministrator extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)      
	public Pharmacy pharmacy;

	public PharmacyAdministrator(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Pharmacy pharmacy, Boolean enabled) {
		super();
		this.pharmacy = pharmacy;
	}

	public PharmacyAdministrator(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, UserType userType, Address address, Pharmacy pharmacy) {
		super(firstName, lastName, userName, password, email, phoneNumber, userType, address);
		this.pharmacy = pharmacy;
	}
	
	
	public PharmacyAdministrator()
	{
		
	}
	

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
  
}