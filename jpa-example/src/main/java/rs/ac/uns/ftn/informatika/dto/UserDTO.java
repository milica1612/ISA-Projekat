package rs.ac.uns.ftn.informatika.dto;

import javax.persistence.Column;

import rs.ac.uns.ftn.informatika.jpa.model.UserType;

public class UserDTO {

	private String firstName;	
    private String lastName;

    public UserDTO() {}
	
	public UserDTO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

}
