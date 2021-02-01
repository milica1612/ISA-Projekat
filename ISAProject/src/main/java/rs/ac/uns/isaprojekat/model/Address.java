package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Address {
   private String street;
   private String streetNumber;
   private String city;
   private String country;
   private Long addressId;
   private Double longitude;
   private Double latitude;
   
   
public Address(String street, String streetNumber, String city, String country, Long addressId, Double longitude,
		Double latitude) {
	super();
	this.street = street;
	this.streetNumber = streetNumber;
	this.city = city;
	this.country = country;
	this.addressId = addressId;
	this.longitude = longitude;
	this.latitude = latitude;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getStreetNumber() {
	return streetNumber;
}
public void setStreetNumber(String streetNumber) {
	this.streetNumber = streetNumber;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public Long getAddressId() {
	return addressId;
}
public void setAddressId(Long addressId) {
	this.addressId = addressId;
}
public Double getLongitude() {
	return longitude;
}
public void setLongitude(Double longitude) {
	this.longitude = longitude;
}
public Double getLatitude() {
	return latitude;
}
public void setLatitude(Double latitude) {
	this.latitude = latitude;
}
   
   

}