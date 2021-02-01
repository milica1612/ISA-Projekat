package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 39d871f3-0785-4968-8ad8-27c5df276636 */
public class Supplier extends User {
   /** @pdRoleInfo migr=no name=MedicineItem assc=association25 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<MedicineItem> medicineItem;
   
   
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