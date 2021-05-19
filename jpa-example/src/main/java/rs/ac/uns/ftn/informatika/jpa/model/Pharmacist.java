package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="pharmacist")
public class Pharmacist extends User {
	
	private static final long serialVersionUID = -3373281718733941809L;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	public Pharmacy pharmacy;
	
	@Column(name = "rating")
	public Double rating;
	   	
    public Pharmacist(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, UserType userType, Address address, Double rating, Pharmacy pharmacy) {
		super(firstName, lastName, userName, password, email, phoneNumber, userType, address);
		this.pharmacy = pharmacy;
		this.rating = rating;
    }
    
    public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
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