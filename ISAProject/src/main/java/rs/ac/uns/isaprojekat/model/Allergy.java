package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Allergy {
   private Long allergyId;
   private Collection<Medicine> medicine;
   
   public Allergy(Long allergyId) {
	super();
	this.allergyId = allergyId;
	this.medicine = new ArrayList<Medicine>();
}

public Long getAllergyId() {
	return allergyId;
}

public void setAllergyId(Long allergyId) {
	this.allergyId = allergyId;
}
   
   public java.util.Collection<Medicine> getMedicine() {
      if (medicine == null)
         medicine = new HashSet<Medicine>();
      return medicine;
   }
   
   public java.util.Iterator getIteratorMedicine() {
      if (medicine == null)
         medicine = new HashSet<Medicine>();
      return medicine.iterator();
   }
   
   public void setMedicine(java.util.Collection<Medicine> newMedicine) {
      removeAllMedicine();
      for (Iterator iter = newMedicine.iterator(); iter.hasNext();)
         addMedicine((Medicine)iter.next());
   }
   
   public void addMedicine(Medicine newMedicine) {
      if (newMedicine == null)
         return;
      if (this.medicine == null)
         this.medicine = new HashSet<Medicine>();
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

}