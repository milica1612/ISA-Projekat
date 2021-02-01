package rs.ac.uns.isaprojekat.model;

/***********************************************************************
 * Module:  Allergy.java
 * Author:  Korisnik
 * Purpose: Defines the Class Allergy
 ***********************************************************************/

import java.util.*;

/** @pdOid c9bef142-ab31-47bd-a44f-812751eabc3c */
public class Allergy {
   /** @pdOid a0bb2f00-58c6-4168-b7d1-fbda85f9e377 */
   private Long allergyId;
   
   /** @pdRoleInfo migr=no name=Medicine assc=association27 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
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