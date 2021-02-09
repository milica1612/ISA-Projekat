package rs.ac.uns.ftn.informatika.jpa.dto;

public class PharmacistDTO {
	
	private String firstName;
	private String lastName;
	private double reiting;
	private String pharmacyName;
	
	public PharmacistDTO() {}

	public PharmacistDTO(String firstName, String lastName, double reiting, String pharmacyName) {
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

	public String getPharmacyName() {
		return pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}

}
