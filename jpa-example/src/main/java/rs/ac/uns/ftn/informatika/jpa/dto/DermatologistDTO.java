package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.List;

public class DermatologistDTO {
	private String firstName;
	private String lastName;
	private double raiting;
	private List<String> pharmacyName;
	
	public DermatologistDTO() {}
	
	public DermatologistDTO(String firstName, String lastName, double raiting, List<String> pharmacyName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.raiting = raiting;
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
	public double getRaiting() {
		return raiting;
	}
	public void setRaiting(double raiting) {
		this.raiting = raiting;
	}
	public List<String> getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(List<String> pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
}
