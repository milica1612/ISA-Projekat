package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class MedicineSpecification {
   private Double dosage;
   private Long medSpecId;
   
   public java.util.Collection<Contraindication> contraindication;
   public java.util.Collection<Ingridient> ingridient;
   
   public MedicineSpecification(Double dosage, Long medSpecId, Collection<Contraindication> contraindication,
		Collection<Ingridient> ingridient) {
	super();
	this.dosage = dosage;
	this.medSpecId = medSpecId;
	this.contraindication = contraindication;
	this.ingridient = ingridient;
}

public Double getDosage() {
	return dosage;
}

public void setDosage(Double dosage) {
	this.dosage = dosage;
}

public Long getMedSpecId() {
	return medSpecId;
}

public void setMedSpecId(Long medSpecId) {
	this.medSpecId = medSpecId;
}

public java.util.Collection<Contraindication> getContraindication() {
      if (contraindication == null)
         contraindication = new java.util.HashSet<Contraindication>();
      return contraindication;
   }
   
   public java.util.Iterator getIteratorContraindication() {
      if (contraindication == null)
         contraindication = new java.util.HashSet<Contraindication>();
      return contraindication.iterator();
   }
   
   public void setContraindication(java.util.Collection<Contraindication> newContraindication) {
      removeAllContraindication();
      for (java.util.Iterator iter = newContraindication.iterator(); iter.hasNext();)
         addContraindication((Contraindication)iter.next());
   }
   
   public void addContraindication(Contraindication newContraindication) {
      if (newContraindication == null)
         return;
      if (this.contraindication == null)
         this.contraindication = new java.util.HashSet<Contraindication>();
      if (!this.contraindication.contains(newContraindication))
         this.contraindication.add(newContraindication);
   }
   
   public void removeContraindication(Contraindication oldContraindication) {
      if (oldContraindication == null)
         return;
      if (this.contraindication != null)
         if (this.contraindication.contains(oldContraindication))
            this.contraindication.remove(oldContraindication);
   }
   
   public void removeAllContraindication() {
      if (contraindication != null)
         contraindication.clear();
   }
   public java.util.Collection<Ingridient> getIngridient() {
      if (ingridient == null)
         ingridient = new java.util.HashSet<Ingridient>();
      return ingridient;
   }
   
   public java.util.Iterator getIteratorIngridient() {
      if (ingridient == null)
         ingridient = new java.util.HashSet<Ingridient>();
      return ingridient.iterator();
   }
   
   public void setIngridient(java.util.Collection<Ingridient> newIngridient) {
      removeAllIngridient();
      for (java.util.Iterator iter = newIngridient.iterator(); iter.hasNext();)
         addIngridient((Ingridient)iter.next());
   }
   
   public void addIngridient(Ingridient newIngridient) {
      if (newIngridient == null)
         return;
      if (this.ingridient == null)
         this.ingridient = new java.util.HashSet<Ingridient>();
      if (!this.ingridient.contains(newIngridient))
         this.ingridient.add(newIngridient);
   }
   
   public void removeIngridient(Ingridient oldIngridient) {
      if (oldIngridient == null)
         return;
      if (this.ingridient != null)
         if (this.ingridient.contains(oldIngridient))
            this.ingridient.remove(oldIngridient);
   }
   
   public void removeAllIngridient() {
      if (ingridient != null)
         ingridient.clear();
   }
}