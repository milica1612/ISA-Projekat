package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class User {
   
   protected String firstName;
   protected String lastName;
   protected String userName;
   protected String password;
   protected String email;
   protected String phoneNumber;
   protected Long userId;
   
   public UserType userType;
   public Address address;
   
   public User(String firstName, String lastName, String userName, String password, String email,
		String phoneNumber, Long userId, UserType userType, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.userType = userType;
		this.address = address;
    }

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public UserType getUserType() {
		return userType;
	}
	
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}   
}