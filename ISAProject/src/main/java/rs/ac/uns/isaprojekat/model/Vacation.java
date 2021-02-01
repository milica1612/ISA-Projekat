package rs.ac.uns.isaprojekat.model;

/***********************************************************************
 * Module:  Vacation.java
 * Author:  Korisnik
 * Purpose: Defines the Class Vacation
 ***********************************************************************/

import java.util.*;

/** @pdOid 543c7430-4cef-4f51-a930-2744f72e51ce */
public class Vacation {
   /** @pdOid 2ec069b8-9ae1-4b5a-a989-7ccb693dc756 */
   private Long vacationId;
   
   /** @pdRoleInfo migr=no name=Status assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Status> status;
   /** @pdRoleInfo migr=no name=TimeInterval assc=association72 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TimeInterval> timeInterval;
   /** @pdRoleInfo migr=no name=PharmacyEmployee assc=association16 mult=0..* side=A */
   public PharmacyEmployee[] pharmacyEmployee;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Status> getStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStatus */
   public void setStatus(java.util.Collection<Status> newStatus) {
      removeAllStatus();
      for (java.util.Iterator iter = newStatus.iterator(); iter.hasNext();)
         addStatus((Status)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStatus */
   public void addStatus(Status newStatus) {
      if (newStatus == null)
         return;
      if (this.status == null)
         this.status = new java.util.HashSet<Status>();
      if (!this.status.contains(newStatus))
         this.status.add(newStatus);
   }
   
   /** @pdGenerated default remove
     * @param oldStatus */
   public void removeStatus(Status oldStatus) {
      if (oldStatus == null)
         return;
      if (this.status != null)
         if (this.status.contains(oldStatus))
            this.status.remove(oldStatus);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStatus() {
      if (status != null)
         status.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TimeInterval> getTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTimeInterval */
   public void setTimeInterval(java.util.Collection<TimeInterval> newTimeInterval) {
      removeAllTimeInterval();
      for (java.util.Iterator iter = newTimeInterval.iterator(); iter.hasNext();)
         addTimeInterval((TimeInterval)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTimeInterval */
   public void addTimeInterval(TimeInterval newTimeInterval) {
      if (newTimeInterval == null)
         return;
      if (this.timeInterval == null)
         this.timeInterval = new java.util.HashSet<TimeInterval>();
      if (!this.timeInterval.contains(newTimeInterval))
         this.timeInterval.add(newTimeInterval);
   }
   
   /** @pdGenerated default remove
     * @param oldTimeInterval */
   public void removeTimeInterval(TimeInterval oldTimeInterval) {
      if (oldTimeInterval == null)
         return;
      if (this.timeInterval != null)
         if (this.timeInterval.contains(oldTimeInterval))
            this.timeInterval.remove(oldTimeInterval);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTimeInterval() {
      if (timeInterval != null)
         timeInterval.clear();
   }

}