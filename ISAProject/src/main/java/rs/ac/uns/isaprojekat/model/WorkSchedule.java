package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 95dd6198-4bc0-48a0-94c1-3ee06cdeec8d */
public class WorkSchedule {
   /** @pdOid c4cbf3e0-c921-4dd2-82f4-650028e77e9c */
   private Date startTime;
   /** @pdOid ec610771-bad7-405e-8130-d52e0e6d3111 */
   private Date endTime;
   /** @pdOid dd46ef4b-45f8-4124-b609-3a4e277b2883 */
   private Long workScheduleId;
   
   /** @pdRoleInfo migr=no name=PharmacyEmployee assc=association18 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<PharmacyEmployee> pharmacyEmployee;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<PharmacyEmployee> getPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacyEmployee */
   public void setPharmacyEmployee(java.util.Collection<PharmacyEmployee> newPharmacyEmployee) {
      removeAllPharmacyEmployee();
      for (java.util.Iterator iter = newPharmacyEmployee.iterator(); iter.hasNext();)
         addPharmacyEmployee((PharmacyEmployee)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacyEmployee */
   public void addPharmacyEmployee(PharmacyEmployee newPharmacyEmployee) {
      if (newPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee == null)
         this.pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      if (!this.pharmacyEmployee.contains(newPharmacyEmployee))
         this.pharmacyEmployee.add(newPharmacyEmployee);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacyEmployee */
   public void removePharmacyEmployee(PharmacyEmployee oldPharmacyEmployee) {
      if (oldPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee != null)
         if (this.pharmacyEmployee.contains(oldPharmacyEmployee))
            this.pharmacyEmployee.remove(oldPharmacyEmployee);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacyEmployee() {
      if (pharmacyEmployee != null)
         pharmacyEmployee.clear();
   }

}