package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class MedicineItem {
   private int quantity;
   
   public java.util.Collection<Medicine> medicine;
  
   public MedicineItem(int quantity, Collection<Medicine> medicine) {
	super();
	this.quantity = quantity;
	this.medicine = medicine;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
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
}