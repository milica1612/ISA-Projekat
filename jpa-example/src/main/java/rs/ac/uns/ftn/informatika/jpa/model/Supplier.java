package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Supplier extends User {

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
		// TODO Auto-generated constructor stub
	}
	
	
}