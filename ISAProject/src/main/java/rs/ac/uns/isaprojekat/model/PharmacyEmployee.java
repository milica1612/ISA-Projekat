package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class PharmacyEmployee {
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