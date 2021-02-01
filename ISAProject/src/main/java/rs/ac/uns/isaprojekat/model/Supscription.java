package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Supscription {
   private Long supscriptionId;
   private Boolean cancelled;
   
   public java.util.Collection<SaleAndPromotion> saleAndPromotion;
   public java.util.Collection<Patient> patient;
   
   public Supscription(Long supscriptionId, Boolean cancelled, Collection<SaleAndPromotion> saleAndPromotion,
		Collection<Patient> patient) {
	super();
	this.supscriptionId = supscriptionId;
	this.cancelled = cancelled;
	this.saleAndPromotion = saleAndPromotion;
	this.patient = patient;
}

public Long getSupscriptionId() {
	return supscriptionId;
}

public void setSupscriptionId(Long supscriptionId) {
	this.supscriptionId = supscriptionId;
}

public Boolean getCancelled() {
	return cancelled;
}

public void setCancelled(Boolean cancelled) {
	this.cancelled = cancelled;
}

public java.util.Collection<SaleAndPromotion> getSaleAndPromotion() {
      if (saleAndPromotion == null)
         saleAndPromotion = new java.util.HashSet<SaleAndPromotion>();
      return saleAndPromotion;
   }
   
   public java.util.Iterator getIteratorSaleAndPromotion() {
      if (saleAndPromotion == null)
         saleAndPromotion = new java.util.HashSet<SaleAndPromotion>();
      return saleAndPromotion.iterator();
   }
   
   public void setSaleAndPromotion(java.util.Collection<SaleAndPromotion> newSaleAndPromotion) {
      removeAllSaleAndPromotion();
      for (java.util.Iterator iter = newSaleAndPromotion.iterator(); iter.hasNext();)
         addSaleAndPromotion((SaleAndPromotion)iter.next());
   }
   
   public void addSaleAndPromotion(SaleAndPromotion newSaleAndPromotion) {
      if (newSaleAndPromotion == null)
         return;
      if (this.saleAndPromotion == null)
         this.saleAndPromotion = new java.util.HashSet<SaleAndPromotion>();
      if (!this.saleAndPromotion.contains(newSaleAndPromotion))
         this.saleAndPromotion.add(newSaleAndPromotion);
   }
   
   public void removeSaleAndPromotion(SaleAndPromotion oldSaleAndPromotion) {
      if (oldSaleAndPromotion == null)
         return;
      if (this.saleAndPromotion != null)
         if (this.saleAndPromotion.contains(oldSaleAndPromotion))
            this.saleAndPromotion.remove(oldSaleAndPromotion);
   }
   
   public void removeAllSaleAndPromotion() {
      if (saleAndPromotion != null)
         saleAndPromotion.clear();
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