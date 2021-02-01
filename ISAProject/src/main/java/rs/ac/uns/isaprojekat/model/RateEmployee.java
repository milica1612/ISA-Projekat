package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid c699cb95-265e-4eb8-8625-071570f36a7b */
public class RateEmployee {
   /** @pdOid 551231d4-44a8-4c8f-a432-92bdd1d5f05c */
   private Long rateId;
   /** @pdOid a1acb9e4-81dd-4b96-a319-62fe67f19099 */
   private int rating;
   
   /** @pdRoleInfo migr=no name=Patient assc=association55 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   /** @pdRoleInfo migr=no name=PharmacyEmployee assc=association56 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<PharmacyEmployee> pharmacyEmployee;
   
   
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
   /** @pdGenerated default getter */
   public java.util.Collection<PharmacyEmployee> getPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacyEmployee */
   public void setPharmacyEmployee(java.util.Collection<PharmacyEmployee> newPharmacyEmployee) {
      removeAllPharmacyEmployee();
      for (java.util.Iterator iter = newPharmacyEmployee.iterator(); iter.hasNext();)
         addPharmacyEmployee((PharmacyEmployee)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacyEmployee */
   public void addPharmacyEmployee(PharmacyEmployee newPharmacyEmployee) {
      if (newPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee == null)
         this.pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      if (!this.pharmacyEmployee.contains(newPharmacyEmployee))
         this.pharmacyEmployee.add(newPharmacyEmployee);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacyEmployee */
   public void removePharmacyEmployee(PharmacyEmployee oldPharmacyEmployee) {
      if (oldPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee != null)
         if (this.pharmacyEmployee.contains(oldPharmacyEmployee))
            this.pharmacyEmployee.remove(oldPharmacyEmployee);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacyEmployee() {
      if (pharmacyEmployee != null)
         pharmacyEmployee.clear();
   }

}