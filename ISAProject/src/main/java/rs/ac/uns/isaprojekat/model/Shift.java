package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Shift {
   private Date day;
   private Long shiftId;
   public java.util.Collection<WorkSchedule> workSchedule;
   
   public Shift(Date day, Long shiftId, Collection<WorkSchedule> workSchedule) {
	super();
	this.day = day;
	this.shiftId = shiftId;
	this.workSchedule = workSchedule;
}

public Date getDay() {
	return day;
}

public void setDay(Date day) {
	this.day = day;
}

public Long getShiftId() {
	return shiftId;
}

public void setShiftId(Long shiftId) {
	this.shiftId = shiftId;
}

public java.util.Collection<WorkSchedule> getWorkSchedule() {
      if (workSchedule == null)
         workSchedule = new java.util.HashSet<WorkSchedule>();
      return workSchedule;
   }
   
   public java.util.Iterator getIteratorWorkSchedule() {
      if (workSchedule == null)
         workSchedule = new java.util.HashSet<WorkSchedule>();
      return workSchedule.iterator();
   }
   
   public void setWorkSchedule(java.util.Collection<WorkSchedule> newWorkSchedule) {
      removeAllWorkSchedule();
      for (java.util.Iterator iter = newWorkSchedule.iterator(); iter.hasNext();)
         addWorkSchedule((WorkSchedule)iter.next());
   }
   
   public void addWorkSchedule(WorkSchedule newWorkSchedule) {
      if (newWorkSchedule == null)
         return;
      if (this.workSchedule == null)
         this.workSchedule = new java.util.HashSet<WorkSchedule>();
      if (!this.workSchedule.contains(newWorkSchedule))
         this.workSchedule.add(newWorkSchedule);
   }
   
   public void removeWorkSchedule(WorkSchedule oldWorkSchedule) {
      if (oldWorkSchedule == null)
         return;
      if (this.workSchedule != null)
         if (this.workSchedule.contains(oldWorkSchedule))
            this.workSchedule.remove(oldWorkSchedule);
   }
   
   public void removeAllWorkSchedule() {
      if (workSchedule != null)
         workSchedule.clear();
   }

}