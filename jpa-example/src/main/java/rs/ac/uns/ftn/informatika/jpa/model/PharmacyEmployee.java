package rs.ac.uns.ftn.informatika.jpa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pharmacyemployee")
public class PharmacyEmployee extends User {
	
	@Column(name = "rating")
	public Double rating;

	public PharmacyEmployee(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, UserType userType, Address address, Double rating) {
		super(firstName, lastName, userName, password, email, phoneNumber, userType, address);
		this.rating = rating;
	}

	
	public PharmacyEmployee()
	{
		
	}
	
	public Double getRating() {
		return rating;
	}
	
	public void setRating(Double rating) {
		this.rating = rating;
	}

}