package rs.ac.uns.isaprojekat.model;

/***********************************************************************
 * Module:  Vacation.java
 * Author:  Korisnik
 * Purpose: Defines the Class Vacation
 ***********************************************************************/

import java.util.*;

public class Vacation {
   private Long vacationId;
   
   public java.util.Collection<Status> status;
   public java.util.Collection<TimeInterval> timeInterval;
   public PharmacyEmployee[] pharmacyEmployee;
   
   public Vacation(Long vacationId, Collection<Status> status, Collection<TimeInterval> timeInterval,
		PharmacyEmployee[] pharmacyEmployee) {
	super();
	this.vacationId = vacationId;
	this.status = status;
	this.timeInterval = timeInterval;
	this.pharmacyEmployee = pharmacyEmployee;
}

public Long getVacationId() {
	return vacationId;
}

public void setVacationId(Long vacationId) {
	this.vacationId = vacationId;
}

public PharmacyEmployee[] getPharmacyEmployee() {
	return pharmacyEmployee;
}

public void setPharmacyEmployee(PharmacyEmployee[] pharmacyEmployee) {
	this.pharmacyEmployee = pharmacyEmployee;
}

public java.util.Collection<Status> getStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status;
   }
   
   public java.util.Iterator getIteratorStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status.iterator();
   }
   
   public void setStatus(java.util.Collection<Status> newStatus) {
      removeAllStatus();
      for (java.util.Iterator iter = newStatus.iterator(); iter.hasNext();)
         addStatus((Status)iter.next());
   }
   
   public void addStatus(Status newStatus) {
      if (newStatus == null)
         return;
      if (this.status == null)
         this.status = new java.util.HashSet<Status>();
      if (!this.status.contains(newStatus))
         this.status.add(newStatus);
   }
   
   public void removeStatus(Status oldStatus) {
      if (oldStatus == null)
         return;
      if (this.status != null)
         if (this.status.contains(oldStatus))
            this.status.remove(oldStatus);
   }
   
   public void removeAllStatus() {
      if (status != null)
         status.clear();
   }
   public java.util.Collection<TimeInterval> getTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval;
   }
   
   public java.util.Iterator getIteratorTimeInterval() {
      if (timeInterval == null)
         timeInterval = new java.util.HashSet<TimeInterval>();
      return timeInterval.iterator();
   }
   
   public void setTimeInterval(java.util.Collection<TimeInterval> newTimeInterval) {
      removeAllTimeInterval();
      for (java.util.Iterator iter = newTimeInterval.iterator(); iter.hasNext();)
         addTimeInterval((TimeInterval)iter.next());
   }
   
   public void addTimeInterval(TimeInterval newTimeInterval) {
      if (newTimeInterval == null)
         return;
      if (this.timeInterval == null)
         this.timeInterval = new java.util.HashSet<TimeInterval>();
      if (!this.timeInterval.contains(newTimeInterval))
         this.timeInterval.add(newTimeInterval);
   }
   
   public void removeTimeInterval(TimeInterval oldTimeInterval) {
      if (oldTimeInterval == null)
         return;
      if (this.timeInterval != null)
         if (this.timeInterval.contains(oldTimeInterval))
            this.timeInterval.remove(oldTimeInterval);
   }
   
   public void removeAllTimeInterval() {
      if (timeInterval != null)
         timeInterval.clear();
   }

}