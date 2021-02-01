package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class ComplaintPharmacy {
   private String textPh;
   private Long compPhId;
   
   public Patient patient;
   public Pharmacy pharmacy;
   
public ComplaintPharmacy(String textPh, Long compPhId, Patient patient, Pharmacy pharmacy) {
	super();
	this.textPh = textPh;
	this.compPhId = compPhId;
	this.patient = patient;
	this.pharmacy = pharmacy;
}

public String getTextPh() {
	return textPh;
}

public void setTextPh(String textPh) {
	this.textPh = textPh;
}

public Long getCompPhId() {
	return compPhId;
}

public void setCompPhId(Long compPhId) {
	this.compPhId = compPhId;
}

public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}

public Pharmacy getPharmacy() {
	return pharmacy;
}

public void setPharmacy(Pharmacy pharmacy) {
	this.pharmacy = pharmacy;
}
   

}