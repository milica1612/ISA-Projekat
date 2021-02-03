package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PharmacyEmployee extends User {
	
	
	@Column(name = "rating", nullable = false)
	protected Double rating;
	
	public PharmacyEmployee(Double rating) {
		super();
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