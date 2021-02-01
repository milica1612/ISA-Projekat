package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class RatePharmacy {
   private Long ratePhId;
   private int rating;
   
   public java.util.Collection<Pharmacy> pharmacy;
   public java.util.Collection<Patient> patient;
   
   public RatePharmacy(Long ratePhId, int rating, Collection<Pharmacy> pharmacy, Collection<Patient> patient) {
	super();
	this.ratePhId = ratePhId;
	this.rating = rating;
	this.pharmacy = pharmacy;
	this.patient = patient;
}

public Long getRatePhId() {
	return ratePhId;
}

public void setRatePhId(Long ratePhId) {
	this.ratePhId = ratePhId;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public java.util.Collection<Pharmacy> getPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy;
   }
   
   public java.util.Iterator getIteratorPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy.iterator();
   }
   
   public void setPharmacy(java.util.Collection<Pharmacy> newPharmacy) {
      removeAllPharmacy();
      for (java.util.Iterator iter = newPharmacy.iterator(); iter.hasNext();)
         addPharmacy((Pharmacy)iter.next());
   }
   
   public void addPharmacy(Pharmacy newPharmacy) {
      if (newPharmacy == null)
         return;
      if (this.pharmacy == null)
         this.pharmacy = new java.util.HashSet<Pharmacy>();
      if (!this.pharmacy.contains(newPharmacy))
         this.pharmacy.add(newPharmacy);
   }
   
   public void removePharmacy(Pharmacy oldPharmacy) {
      if (oldPharmacy == null)
         return;
      if (this.pharmacy != null)
         if (this.pharmacy.contains(oldPharmacy))
            this.pharmacy.remove(oldPharmacy);
   }
   
   public void removeAllPharmacy() {
      if (pharmacy != null)
         pharmacy.clear();
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

}