package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 2a9f3e52-1166-4ecf-a949-8eaa0b123b4c */
public class Supscription {
   /** @pdOid 5c0403df-7428-4356-bf9c-f6a779a73491 */
   private Long supscriptionId;
   /** @pdOid fb0eab2a-1c03-49a0-bc06-042efa38e9a8 */
   private Boolean cancelled;
   
   /** @pdRoleInfo migr=no name=SaleAndPromotion assc=association49 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<SaleAndPromotion> saleAndPromotion;
   /** @pdRoleInfo migr=no name=Patient assc=association48 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<SaleAndPromotion> getSaleAndPromotion() {
      if (saleAndPromotion == null)
         saleAndPromotion = new java.util.HashSet<SaleAndPromotion>();
      return saleAndPromotion;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSaleAndPromotion() {
      if (saleAndPromotion == null)
         saleAndPromotion = new java.util.HashSet<SaleAndPromotion>();
      return saleAndPromotion.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSaleAndPromotion */
   public void setSaleAndPromotion(java.util.Collection<SaleAndPromotion> newSaleAndPromotion) {
      removeAllSaleAndPromotion();
      for (java.util.Iterator iter = newSaleAndPromotion.iterator(); iter.hasNext();)
         addSaleAndPromotion((SaleAndPromotion)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSaleAndPromotion */
   public void addSaleAndPromotion(SaleAndPromotion newSaleAndPromotion) {
      if (newSaleAndPromotion == null)
         return;
      if (this.saleAndPromotion == null)
         this.saleAndPromotion = new java.util.HashSet<SaleAndPromotion>();
      if (!this.saleAndPromotion.contains(newSaleAndPromotion))
         this.saleAndPromotion.add(newSaleAndPromotion);
   }
   
   /** @pdGenerated default remove
     * @param oldSaleAndPromotion */
   public void removeSaleAndPromotion(SaleAndPromotion oldSaleAndPromotion) {
      if (oldSaleAndPromotion == null)
         return;
      if (this.saleAndPromotion != null)
         if (this.saleAndPromotion.contains(oldSaleAndPromotion))
            this.saleAndPromotion.remove(oldSaleAndPromotion);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSaleAndPromotion() {
      if (saleAndPromotion != null)
         saleAndPromotion.clear();
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