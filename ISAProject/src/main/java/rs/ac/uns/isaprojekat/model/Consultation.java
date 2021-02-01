package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid d365e2f3-624d-4abe-8d2e-7b56bc6a77a3 */
public class Consultation extends Appointment {
   /** @pdRoleInfo migr=no name=Pharmacist assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pharmacist> pharmacist;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pharmacist> getPharmacist() {
      if (pharmacist == null)
         pharmacist = new java.util.HashSet<Pharmacist>();
      return pharmacist;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacist() {
      if (pharmacist == null)
         pharmacist = new java.util.HashSet<Pharmacist>();
      return pharmacist.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacist */
   public void setPharmacist(java.util.Collection<Pharmacist> newPharmacist) {
      removeAllPharmacist();
      for (java.util.Iterator iter = newPharmacist.iterator(); iter.hasNext();)
         addPharmacist((Pharmacist)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacist */
   public void addPharmacist(Pharmacist newPharmacist) {
      if (newPharmacist == null)
         return;
      if (this.pharmacist == null)
         this.pharmacist = new java.util.HashSet<Pharmacist>();
      if (!this.pharmacist.contains(newPharmacist))
         this.pharmacist.add(newPharmacist);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacist */
   public void removePharmacist(Pharmacist oldPharmacist) {
      if (oldPharmacist == null)
         return;
      if (this.pharmacist != null)
         if (this.pharmacist.contains(oldPharmacist))
            this.pharmacist.remove(oldPharmacist);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacist() {
      if (pharmacist != null)
         pharmacist.clear();
   }

}