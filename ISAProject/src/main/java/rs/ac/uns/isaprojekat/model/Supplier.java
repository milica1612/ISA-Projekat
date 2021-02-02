package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Supplier extends User {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	public Collection<MedicineItem> medicineItem;
	   
	public Supplier(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
			// TODO Auto-generated constructor stub
	}
	
	public Collection<MedicineItem> getMedicineItem() {
	      if (medicineItem == null)
	         medicineItem = new HashSet<MedicineItem>();
	      return medicineItem;
	   }
	   
	public Iterator getIteratorMedicineItem() {
	      if (medicineItem == null)
	         medicineItem = new HashSet<MedicineItem>();
	      return medicineItem.iterator();
	   }
	   
	   public void setMedicineItem(Collection<MedicineItem> newMedicineItem) {
	      removeAllMedicineItem();
	      for (Iterator iter = newMedicineItem.iterator(); iter.hasNext();)
	         addMedicineItem((MedicineItem)iter.next());
	   }
	   
	   public void addMedicineItem(MedicineItem newMedicineItem) {
	      if (newMedicineItem == null)
	         return;
	      if (this.medicineItem == null)
	         this.medicineItem = new HashSet<MedicineItem>();
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