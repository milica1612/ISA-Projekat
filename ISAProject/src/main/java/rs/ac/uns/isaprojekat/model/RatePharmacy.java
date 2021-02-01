package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 5b6b7755-f9d3-4196-a863-71f121c6f52d */
public class RatePharmacy {
   /** @pdOid 5bd9b0d6-3407-43f4-9eaa-55d293c280fd */
   private Long ratePhId;
   /** @pdOid afbae172-d3e2-47f3-ab06-7300abe127de */
   private int rating;
   
   /** @pdRoleInfo migr=no name=Pharmacy assc=association57 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pharmacy> pharmacy;
   /** @pdRoleInfo migr=no name=Patient assc=association58 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pharmacy> getPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacy */
   public void setPharmacy(java.util.Collection<Pharmacy> newPharmacy) {
      removeAllPharmacy();
      for (java.util.Iterator iter = newPharmacy.iterator(); iter.hasNext();)
         addPharmacy((Pharmacy)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacy */
   public void addPharmacy(Pharmacy newPharmacy) {
      if (newPharmacy == null)
         return;
      if (this.pharmacy == null)
         this.pharmacy = new java.util.HashSet<Pharmacy>();
      if (!this.pharmacy.contains(newPharmacy))
         this.pharmacy.add(newPharmacy);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacy */
   public void removePharmacy(Pharmacy oldPharmacy) {
      if (oldPharmacy == null)
         return;
      if (this.pharmacy != null)
         if (this.pharmacy.contains(oldPharmacy))
            this.pharmacy.remove(oldPharmacy);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacy() {
      if (pharmacy != null)
         pharmacy.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Patient> getPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPatient */
   public void setPatient(java.util.Collection<Patient> newPatient) {
      removeAllPatient();
      for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
         addPatient((Patient)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPatient */
   public void addPatient(Patient newPatient) {
      if (newPatient == null)
         return;
      if (this.patient == null)
         this.patient = new java.util.HashSet<Patient>();
      if (!this.patient.contains(newPatient))
         this.patient.add(newPatient);
   }
   
   /** @pdGenerated default remove
     * @param oldPatient */
   public void removePatient(Patient oldPatient) {
      if (oldPatient == null)
         return;
      if (this.patient != null)
         if (this.patient.contains(oldPatient))
            this.patient.remove(oldPatient);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPatient() {
      if (patient != null)
         patient.clear();
   }

}