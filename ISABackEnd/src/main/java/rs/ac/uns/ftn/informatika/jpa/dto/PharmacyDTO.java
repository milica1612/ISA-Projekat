package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Address;

public class PharmacyDTO {
	
	private String name;
	
	private Address address;
		
	private String description;
	
	public PharmacyDTO() {}
	
	public PharmacyDTO(String name, Address address, String description) {
		super();
		this.name = name;
		this.address = new Address(address.getCity(), address.getCountry(), address.getStreet(), address.getStreetNumber(), null, null);
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
		
}
