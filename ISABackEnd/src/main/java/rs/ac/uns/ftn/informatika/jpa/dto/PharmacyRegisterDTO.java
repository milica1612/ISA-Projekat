package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public class PharmacyRegisterDTO {
	
	private String name;
	
	private Double rating;
	
	private Address address;
		
	private String description;
	
	private Pharmacy pharmacy;
	
	public PharmacyRegisterDTO() {}
	
	public PharmacyRegisterDTO(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	
	public PharmacyRegisterDTO(String name, Address address, String description) {
		super();
		this.name = name;
		this.address = new Address(address.getCity(), address.getCountry(), address.getStreet(), address.getStreetNumber(), null, null);
		this.description = description;
	}
	
	public PharmacyRegisterDTO(String name, Double rating, Address address, String description) {
		super();
		this.name = name;
		this.rating = rating;
		this.address = new Address(address.getCity(), address.getCountry(), address.getStreet(), address.getStreetNumber(), null, null);
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
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
