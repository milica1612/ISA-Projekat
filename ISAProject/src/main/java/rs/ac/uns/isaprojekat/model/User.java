package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class User extends PharmacyEmployee {
   
   protected String firstName;
   protected String lastName;
   protected String userName;
   protected String password;
   protected String email;
   protected String phoneNumber;
   protected Long userId;
   
   public java.util.Collection<UserType> userType;
   public java.util.Collection<Address> address;
   
   public User(Double rating, String firstName, String lastName, String userName, String password, String email,
		String phoneNumber, Long userId, Collection<UserType> userType, Collection<Address> address) {
	super(rating);
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

public java.util.Collection<UserType> getUserType() {
      if (userType == null)
         userType = new java.util.HashSet<UserType>();
      return userType;
   }
   
   public java.util.Iterator getIteratorUserType() {
      if (userType == null)
         userType = new java.util.HashSet<UserType>();
      return userType.iterator();
   }
   
   public void setUserType(java.util.Collection<UserType> newUserType) {
      removeAllUserType();
      for (java.util.Iterator iter = newUserType.iterator(); iter.hasNext();)
         addUserType((UserType)iter.next());
   }
   
   public void addUserType(UserType newUserType) {
      if (newUserType == null)
         return;
      if (this.userType == null)
         this.userType = new java.util.HashSet<UserType>();
      if (!this.userType.contains(newUserType))
         this.userType.add(newUserType);
   }
   
   public void removeUserType(UserType oldUserType) {
      if (oldUserType == null)
         return;
      if (this.userType != null)
         if (this.userType.contains(oldUserType))
            this.userType.remove(oldUserType);
   }
   
   public void removeAllUserType() {
      if (userType != null)
         userType.clear();
   }
   public java.util.Collection<Address> getAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address;
   }
   
   public java.util.Iterator getIteratorAddress() {
      if (address == null)
         address = new java.util.HashSet<Address>();
      return address.iterator();
   }
   
   public void setAddress(java.util.Collection<Address> newAddress) {
      removeAllAddress();
      for (java.util.Iterator iter = newAddress.iterator(); iter.hasNext();)
         addAddress((Address)iter.next());
   }
   
   public void addAddress(Address newAddress) {
      if (newAddress == null)
         return;
      if (this.address == null)
         this.address = new java.util.HashSet<Address>();
      if (!this.address.contains(newAddress))
         this.address.add(newAddress);
   }
   
   public void removeAddress(Address oldAddress) {
      if (oldAddress == null)
         return;
      if (this.address != null)
         if (this.address.contains(oldAddress))
            this.address.remove(oldAddress);
   }
   
   public void removeAllAddress() {
      if (address != null)
         address.clear();
   }

}