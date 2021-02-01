package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 14defa88-3f21-482e-b224-2cb5355a8b09 */
public class RateMedicine {
   /** @pdOid a306f2d3-114d-416f-a6ef-e0f24528aa47 */
   private Long rateMedicineId;
   /** @pdOid f1d3e507-45a5-4482-b4e8-9c46a45e4092 */
   private int rating;
   
   /** @pdRoleInfo migr=no name=Patient assc=association59 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   /** @pdRoleInfo migr=no name=Medicine assc=association60 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Medicine> medicine;
   
   
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
   public java.util.Collection<Medicine> getMedicine() {
      if (medicine == null)
         medicine = new java.util.HashSet<Medicine>();
      return medicine;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMedicine() {
      if (medicine == null)
         medicine = new java.util.HashSet<Medicine>();
      return medicine.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMedicine */
   public void setMedicine(java.util.Collection<Medicine> newMedicine) {
      removeAllMedicine();
      for (java.util.Iterator iter = newMedicine.iterator(); iter.hasNext();)
         addMedicine((Medicine)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMedicine */
   public void addMedicine(Medicine newMedicine) {
      if (newMedicine == null)
         return;
      if (this.medicine == null)
         this.medicine = new java.util.HashSet<Medicine>();
      if (!this.medicine.contains(newMedicine))
         this.medicine.add(newMedicine);
   }
   
   /** @pdGenerated default remove
     * @param oldMedicine */
   public void removeMedicine(Medicine oldMedicine) {
      if (oldMedicine == null)
         return;
      if (this.medicine != null)
         if (this.medicine.contains(oldMedicine))
            this.medicine.remove(oldMedicine);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMedicine() {
      if (medicine != null)
         medicine.clear();
   }

}