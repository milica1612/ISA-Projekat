package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class ComplaintEmployee {
   private String textEmp;
   private Long compEmpId;
   
   public java.util.Collection<Patient> patient;
   public java.util.Collection<PharmacyEmployee> pharmacyEmployee;
   
   public ComplaintEmployee(String textEmp, Long compEmpId, Collection<Patient> patient,
		Collection<PharmacyEmployee> pharmacyEmployee) {
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

public java.util.Collection<Patient> getPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient;
   }

   public java.util.Iterator getIteratorPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient.iterator();
   }
   
   public void setPatient(java.util.Collection<Patient> newPatient) {
      removeAllPatient();
      for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
         addPatient((Patient)iter.next());
   }
   
   public void addPatient(Patient newPatient) {
      if (newPatient == null)
         return;
      if (this.patient == null)
         this.patient = new java.util.HashSet<Patient>();
      if (!this.patient.contains(newPatient))
         this.patient.add(newPatient);
   }
   
   public void removePatient(Patient oldPatient) {
      if (oldPatient == null)
         return;
      if (this.patient != null)
         if (this.patient.contains(oldPatient))
            this.patient.remove(oldPatient);
   }
   
   public void removeAllPatient() {
      if (patient != null)
         patient.clear();
   }

   public java.util.Collection<PharmacyEmployee> getPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee;
   }
   
   public java.util.Iterator getIteratorPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee.iterator();
   }
   
   public void setPharmacyEmployee(java.util.Collection<PharmacyEmployee> newPharmacyEmployee) {
      removeAllPharmacyEmployee();
      for (java.util.Iterator iter = newPharmacyEmployee.iterator(); iter.hasNext();)
         addPharmacyEmployee((PharmacyEmployee)iter.next());
   }
   
   public void addPharmacyEmployee(PharmacyEmployee newPharmacyEmployee) {
      if (newPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee == null)
         this.pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      if (!this.pharmacyEmployee.contains(newPharmacyEmployee))
         this.pharmacyEmployee.add(newPharmacyEmployee);
   }
   
   public void removePharmacyEmployee(PharmacyEmployee oldPharmacyEmployee) {
      if (oldPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee != null)
         if (this.pharmacyEmployee.contains(oldPharmacyEmployee))
            this.pharmacyEmployee.remove(oldPharmacyEmployee);
   }
   
   public void removeAllPharmacyEmployee() {
      if (pharmacyEmployee != null)
         pharmacyEmployee.clear();
   }

}