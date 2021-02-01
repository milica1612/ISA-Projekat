package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 0ec18951-701b-4e4b-b601-89e8239cc0d5 */
public class EPrescription {
   /** @pdOid abf2cf0e-8e67-49ad-86dd-e10ffd98c0e5 */
   private Long prescriptionId;
   /** @pdOid f8f3ea02-b9e3-4580-8f42-c403e95feee3 */
   private Date date;
   
   /** @pdRoleInfo migr=no name=Medicine assc=association66 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Medicine> medicine;
   
   
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

}