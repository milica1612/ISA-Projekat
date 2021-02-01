package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Supplier extends User {
   public Supplier(Double rating, String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, Collection<UserType> userType, Collection<Address> address) {
		super(rating, firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
		// TODO Auto-generated constructor stub
	}
	
	public java.util.Collection<MedicineItem> medicineItem;
	   
	  
	
	public java.util.Collection<MedicineItem> getMedicineItem() {
	      if (medicineItem == null)
	         medicineItem = new java.util.HashSet<MedicineItem>();
	      return medicineItem;
	   }
	   
	   public java.util.Iterator getIteratorMedicineItem() {
	      if (medicineItem == null)
	         medicineItem = new java.util.HashSet<MedicineItem>();
	      return medicineItem.iterator();
	   }
	   
	   public void setMedicineItem(java.util.Collection<MedicineItem> newMedicineItem) {
	      removeAllMedicineItem();
	      for (java.util.Iterator iter = newMedicineItem.iterator(); iter.hasNext();)
	         addMedicineItem((MedicineItem)iter.next());
	   }
	   
	   public void addMedicineItem(MedicineItem newMedicineItem) {
	      if (newMedicineItem == null)
	         return;
	      if (this.medicineItem == null)
	         this.medicineItem = new java.util.HashSet<MedicineItem>();
	      if (!this.medicineItem.contains(newMedicineItem))
	         this.medicineItem.add(newMedicineItem);
	   }
	   
	   public void removeMedicineItem(MedicineItem oldMedicineItem) {
	      if (oldMedicineItem == null)
	         return;
	      if (this.medicineItem != null)
	         if (this.medicineItem.contains(oldMedicineItem))
	            this.medicineItem.remove(oldMedicineItem);
	   }
	   
	   public void removeAllMedicineItem() {
	      if (medicineItem != null)
	         medicineItem.clear();
	   }

}