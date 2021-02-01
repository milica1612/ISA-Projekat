package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid f8a58430-a21e-467c-ae05-6cd35ebd3e51 */
public class Recommendation {
   /** @pdOid ad9db18d-9275-443f-9f3e-75ce3bc88fdd */
   private Long recommendationId;
   
   /** @pdRoleInfo migr=no name=Medicine assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Medicine> medicine;
   /** @pdRoleInfo migr=no name=Consultation assc=association64 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Consultation> consultation;
   
   
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
   /** @pdGenerated default getter */
   public java.util.Collection<Consultation> getConsultation() {
      if (consultation == null)
         consultation = new java.util.HashSet<Consultation>();
      return consultation;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorConsultation() {
      if (consultation == null)
         consultation = new java.util.HashSet<Consultation>();
      return consultation.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newConsultation */
   public void setConsultation(java.util.Collection<Consultation> newConsultation) {
      removeAllConsultation();
      for (java.util.Iterator iter = newConsultation.iterator(); iter.hasNext();)
         addConsultation((Consultation)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newConsultation */
   public void addConsultation(Consultation newConsultation) {
      if (newConsultation == null)
         return;
      if (this.consultation == null)
         this.consultation = new java.util.HashSet<Consultation>();
      if (!this.consultation.contains(newConsultation))
         this.consultation.add(newConsultation);
   }
   
   /** @pdGenerated default remove
     * @param oldConsultation */
   public void removeConsultation(Consultation oldConsultation) {
      if (oldConsultation == null)
         return;
      if (this.consultation != null)
         if (this.consultation.contains(oldConsultation))
            this.consultation.remove(oldConsultation);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllConsultation() {
      if (consultation != null)
         consultation.clear();
   }

}