package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PharmacyAdministrator extends User {

	public Pharmacy pharmacy;

	public PharmacyAdministrator(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Pharmacy pharmacy) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
		this.pharmacy = pharmacy;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
  
}