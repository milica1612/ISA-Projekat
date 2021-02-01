package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class ComplaintEmployee {
   private String textEmp;
   private Long compEmpId;
   
   public Patient patient;
   public PharmacyEmployee pharmacyEmployee;
   
public ComplaintEmployee(String textEmp, Long compEmpId, Patient patient, PharmacyEmployee pharmacyEmployee) {
	super();
	this.textEmp = textEmp;
	this.compEmpId = compEmpId;
	this.patient = patient;
	this.pharmacyEmployee = pharmacyEmployee;
}

public String getTextEmp() {
	return textEmp;
}

public void setTextEmp(String textEmp) {
	this.textEmp = textEmp;
}

public Long getCompEmpId() {
	return compEmpId;
}

public void setCompEmpId(Long compEmpId) {
	this.compEmpId = compEmpId;
}

public Patient getPatient() {
	return patient;
}

public void setPatient(Patient patient) {
	this.patient = patient;
}

public PharmacyEmployee getPharmacyEmployee() {
	return pharmacyEmployee;
}

public void setPharmacyEmployee(PharmacyEmployee pharmacyEmployee) {
	this.pharmacyEmployee = pharmacyEmployee;
}
   

}