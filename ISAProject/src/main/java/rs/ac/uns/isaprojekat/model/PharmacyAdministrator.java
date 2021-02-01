package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 77688db1-da14-4f3c-8c34-7fc1afaf3197 */
public class PharmacyAdministrator extends User {
   /** @pdRoleInfo migr=no name=Pharmacy assc=association37 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pharmacy> pharmacy;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Pharmacy> getPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacy */
   public void setPharmacy(java.util.Collection<Pharmacy> newPharmacy) {
      removeAllPharmacy();
      for (java.util.Iterator iter = newPharmacy.iterator(); iter.hasNext();)
         addPharmacy((Pharmacy)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacy */
   public void addPharmacy(Pharmacy newPharmacy) {
      if (newPharmacy == null)
         return;
      if (this.pharmacy == null)
         this.pharmacy = new java.util.HashSet<Pharmacy>();
      if (!this.pharmacy.contains(newPharmacy))
         this.pharmacy.add(newPharmacy);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacy */
   public void removePharmacy(Pharmacy oldPharmacy) {
      if (oldPharmacy == null)
         return;
      if (this.pharmacy != null)
         if (this.pharmacy.contains(oldPharmacy))
            this.pharmacy.remove(oldPharmacy);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacy() {
      if (pharmacy != null)
         pharmacy.clear();
   }

}