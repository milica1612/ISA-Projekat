package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Recommendation {
   private Long recommendationId;
   public java.util.Collection<Medicine> medicine;
   public java.util.Collection<Consultation> consultation;
   
   public Recommendation(Long recommendationId, Collection<Medicine> medicine, Collection<Consultation> consultation) {
	super();
	this.recommendationId = recommendationId;
	this.medicine = medicine;
	this.consultation = consultation;
}

public Long getRecommendationId() {
	return recommendationId;
}

public void setRecommendationId(Long recommendationId) {
	this.recommendationId = recommendationId;
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
   public java.util.Collection<Consultation> getConsultation() {
      if (consultation == null)
         consultation = new java.util.HashSet<Consultation>();
      return consultation;
   }
   
   public java.util.Iterator getIteratorConsultation() {
      if (consultation == null)
         consultation = new java.util.HashSet<Consultation>();
      return consultation.iterator();
   }
   
   public void setConsultation(java.util.Collection<Consultation> newConsultation) {
      removeAllConsultation();
      for (java.util.Iterator iter = newConsultation.iterator(); iter.hasNext();)
         addConsultation((Consultation)iter.next());
   }
   
   public void addConsultation(Consultation newConsultation) {
      if (newConsultation == null)
         return;
      if (this.consultation == null)
         this.consultation = new java.util.HashSet<Consultation>();
      if (!this.consultation.contains(newConsultation))
         this.consultation.add(newConsultation);
   }
   
   public void removeConsultation(Consultation oldConsultation) {
      if (oldConsultation == null)
         return;
      if (this.consultation != null)
         if (this.consultation.contains(oldConsultation))
            this.consultation.remove(oldConsultation);
   }
   
   public void removeAllConsultation() {
      if (consultation != null)
         consultation.clear();
   }

}