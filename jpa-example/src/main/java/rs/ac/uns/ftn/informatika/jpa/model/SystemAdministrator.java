package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SystemAdministrator extends User {
	
	public SystemAdministrator(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Boolean enabled, Date lastResetPasswordDate) {
		super(firstName, lastName, userName, password, email, phoneNumber, enabled, userId, userType, address, lastResetPasswordDate);
		// TODO Auto-generated constructor stub
	}
	public SystemAdministrator()
	{
		
	}
	
}