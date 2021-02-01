package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid e29ba727-cee8-4a86-b8ec-3f4eac90c8a8 */
public class Reservation {
   /** @pdOid 12ab68b6-74e6-4ed2-a95a-81a0cda957d5 */
   private Date deadline;
   /** @pdOid e3d63050-574e-4da0-b82d-32696ead1af2 */
   private Long reservationId;
   /** @pdOid 0bb769d1-7aa9-4eba-af8e-877bb528a343 */
   private Boolean recieved;
   
   /** @pdRoleInfo migr=no name=Patient assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   /** @pdRoleInfo migr=no name=MedicineItem assc=association47 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MedicineItem> medicineItem;
   
   
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
   public java.util.Collection<MedicineItem> getMedicineItem() {
      if (medicineItem == null)
         medicineItem = new java.util.HashSet<MedicineItem>();
      return medicineItem;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorMedicineItem() {
      if (medicineItem == null)
         medicineItem = new java.util.HashSet<MedicineItem>();
      return medicineItem.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newMedicineItem */
   public void setMedicineItem(java.util.Collection<MedicineItem> newMedicineItem) {
      removeAllMedicineItem();
      for (java.util.Iterator iter = newMedicineItem.iterator(); iter.hasNext();)
         addMedicineItem((MedicineItem)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newMedicineItem */
   public void addMedicineItem(MedicineItem newMedicineItem) {
      if (newMedicineItem == null)
         return;
      if (this.medicineItem == null)
         this.medicineItem = new java.util.HashSet<MedicineItem>();
      if (!this.medicineItem.contains(newMedicineItem))
         this.medicineItem.add(newMedicineItem);
   }
   
   /** @pdGenerated default remove
     * @param oldMedicineItem */
   public void removeMedicineItem(MedicineItem oldMedicineItem) {
      if (oldMedicineItem == null)
         return;
      if (this.medicineItem != null)
         if (this.medicineItem.contains(oldMedicineItem))
            this.medicineItem.remove(oldMedicineItem);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllMedicineItem() {
      if (medicineItem != null)
         medicineItem.clear();
   }

}