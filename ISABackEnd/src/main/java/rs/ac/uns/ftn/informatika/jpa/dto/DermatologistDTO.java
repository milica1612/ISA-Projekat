package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.List;

public class DermatologistDTO {
	private String firstName;
	private String lastName;
	private double rating;
	private List<String> pharmacyName;
	
	public DermatologistDTO() {}
	
	public DermatologistDTO(String firstName, String lastName, double rating, List<String> pharmacyName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rating = rating;
		this.pharmacyName = pharmacyName;
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
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<String> getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(List<String> pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
}
