package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class WorkSchedule {
   private Date startTime;
   private Date endTime;
   private Long workScheduleId;
   
   public WorkSchedule(Date startTime, Date endTime, Long workScheduleId, Collection<PharmacyEmployee> pharmacyEmployee) {
	super();
	this.startTime = startTime;
	this.endTime = endTime;
	this.workScheduleId = workScheduleId;
	this.pharmacyEmployee = pharmacyEmployee;
}

public Date getStartTime() {
	return startTime;
}

public void setStartTime(Date startTime) {
	this.startTime = startTime;
}

public Date getEndTime() {
	return endTime;
}

public void setEndTime(Date endTime) {
	this.endTime = endTime;
}

public Long getWorkScheduleId() {
	return workScheduleId;
}

public void setWorkScheduleId(Long workScheduleId) {
	this.workScheduleId = workScheduleId;
}

public java.util.Collection<PharmacyEmployee> pharmacyEmployee;
   
   public java.util.Collection<PharmacyEmployee> getPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee;
   }
   
   public java.util.Iterator getIteratorPharmacyEmployee() {
      if (pharmacyEmployee == null)
         pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      return pharmacyEmployee.iterator();
   }
   
   public void setPharmacyEmployee(java.util.Collection<PharmacyEmployee> newPharmacyEmployee) {
      removeAllPharmacyEmployee();
      for (java.util.Iterator iter = newPharmacyEmployee.iterator(); iter.hasNext();)
         addPharmacyEmployee((PharmacyEmployee)iter.next());
   }
   
   public void addPharmacyEmployee(PharmacyEmployee newPharmacyEmployee) {
      if (newPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee == null)
         this.pharmacyEmployee = new java.util.HashSet<PharmacyEmployee>();
      if (!this.pharmacyEmployee.contains(newPharmacyEmployee))
         this.pharmacyEmployee.add(newPharmacyEmployee);
   }
   
   public void removePharmacyEmployee(PharmacyEmployee oldPharmacyEmployee) {
      if (oldPharmacyEmployee == null)
         return;
      if (this.pharmacyEmployee != null)
         if (this.pharmacyEmployee.contains(oldPharmacyEmployee))
            this.pharmacyEmployee.remove(oldPharmacyEmployee);
   }
   
   public void removeAllPharmacyEmployee() {
      if (pharmacyEmployee != null)
         pharmacyEmployee.clear();
   }

}