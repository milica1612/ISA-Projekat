package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.List;

public class DermatologistDTO {
	private String firstName;
	private String lastName;
	private double reiting;
	private List<String> pharmacyName;
	
	public DermatologistDTO() {}
	
	public DermatologistDTO(String firstName, String lastName, double reiting, List<String> pharmacyName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.reiting = reiting;
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
	public double getReiting() {
		return reiting;
	}
	public void setReiting(double reiting) {
		this.reiting = reiting;
	}
	public List<String> getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(List<String> pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
}
