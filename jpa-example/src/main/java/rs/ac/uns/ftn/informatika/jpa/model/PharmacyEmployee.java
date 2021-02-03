package rs.ac.uns.isaprojekat.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class PharmacyEmployee {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pharmacyEmployeeId;
	
	//@Column(name = "rating", nullable = false)
	protected Double rating;
	
	public PharmacyEmployee(Double rating) {
		super();
		this.rating = rating;
	}
	
	public Double getRating() {
		return rating;
	}
	
	public void setRating(Double rating) {
		this.rating = rating;
	}

}