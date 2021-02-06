package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.Entity;



@Entity
public class Supplier extends User {

	public Supplier() {
		
	}

	public Supplier(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
		// TODO Auto-generated constructor stub
	}
	
	
}