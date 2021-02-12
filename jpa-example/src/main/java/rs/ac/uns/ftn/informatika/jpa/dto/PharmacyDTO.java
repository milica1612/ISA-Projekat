package rs.ac.uns.ftn.informatika.jpa.dto;

public class PharmacyDTO {
	private String name;
	private String address;
	private double reiting;
	private String description;
	
	public PharmacyDTO() {}
	
	public PharmacyDTO(String name, String address, double reiting, String description) {
		super();
		this.name = name;
		this.address = address;
		this.reiting = reiting;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getReiting() {
		return reiting;
	}
	public void setReiting(double reiting) {
		this.reiting = reiting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
