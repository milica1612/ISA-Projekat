package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 14a26fee-e213-4c1e-a66c-9957db0b33e0 */
public class Shift {
   /** @pdOid cfc019e0-883f-4fd9-853b-3aac3597df1f */
   private Date day;
   /** @pdOid bbfcc1a7-a3db-47ff-b591-69ab897d701e */
   private Long shiftId;
   
   /** @pdRoleInfo migr=no name=WorkSchedule assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<WorkSchedule> workSchedule;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<WorkSchedule> getWorkSchedule() {
      if (workSchedule == null)
         workSchedule = new java.util.HashSet<WorkSchedule>();
      return workSchedule;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorWorkSchedule() {
      if (workSchedule == null)
         workSchedule = new java.util.HashSet<WorkSchedule>();
      return workSchedule.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newWorkSchedule */
   public void setWorkSchedule(java.util.Collection<WorkSchedule> newWorkSchedule) {
      removeAllWorkSchedule();
      for (java.util.Iterator iter = newWorkSchedule.iterator(); iter.hasNext();)
         addWorkSchedule((WorkSchedule)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newWorkSchedule */
   public void addWorkSchedule(WorkSchedule newWorkSchedule) {
      if (newWorkSchedule == null)
         return;
      if (this.workSchedule == null)
         this.workSchedule = new java.util.HashSet<WorkSchedule>();
      if (!this.workSchedule.contains(newWorkSchedule))
         this.workSchedule.add(newWorkSchedule);
   }
   
   /** @pdGenerated default remove
     * @param oldWorkSchedule */
   public void removeWorkSchedule(WorkSchedule oldWorkSchedule) {
      if (oldWorkSchedule == null)
         return;
      if (this.workSchedule != null)
         if (this.workSchedule.contains(oldWorkSchedule))
            this.workSchedule.remove(oldWorkSchedule);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllWorkSchedule() {
      if (workSchedule != null)
         workSchedule.clear();
   }

}