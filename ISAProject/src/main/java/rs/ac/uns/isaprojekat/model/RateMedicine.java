package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class RateMedicine {
   private Long rateMedicineId;
   private int rating;
   
   public java.util.Collection<Patient> patient;
   public java.util.Collection<Medicine> medicine;
   
   public RateMedicine(Long rateMedicineId, int rating, Collection<Patient> patient, Collection<Medicine> medicine) {
	super();
	this.rateMedicineId = rateMedicineId;
	this.rating = rating;
	this.patient = patient;
	this.medicine = medicine;
}

public Long getRateMedicineId() {
	return rateMedicineId;
}

public void setRateMedicineId(Long rateMedicineId) {
	this.rateMedicineId = rateMedicineId;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
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
   public java.util.Collection<Medicine> getMedicine() {
      if (medicine == null)
         medicine = new java.util.HashSet<Medicine>();
      return medicine;
   }
   
   public java.util.Iterator getIteratorMedicine() {
      if (medicine == null)
         medicine = new java.util.HashSet<Medicine>();
      return medicine.iterator();
   }
   
   public void setMedicine(java.util.Collection<Medicine> newMedicine) {
      removeAllMedicine();
      for (java.util.Iterator iter = newMedicine.iterator(); iter.hasNext();)
         addMedicine((Medicine)iter.next());
   }
   
   public void addMedicine(Medicine newMedicine) {
      if (newMedicine == null)
         return;
      if (this.medicine == null)
         this.medicine = new java.util.HashSet<Medicine>();
      if (!this.medicine.contains(newMedicine))
         this.medicine.add(newMedicine);
   }
   
   public void removeMedicine(Medicine oldMedicine) {
      if (oldMedicine == null)
         return;
      if (this.medicine != null)
         if (this.medicine.contains(oldMedicine))
            this.medicine.remove(oldMedicine);
   }

   public void removeAllMedicine() {
      if (medicine != null)
         medicine.clear();
   }

}