package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Therapy {
   private Long therapyId;
   
   public java.util.Collection<Medicine> medicine;
   public java.util.Collection<TimeInterval> timeInterval;
   public java.util.Collection<Examination> examination;
   
   public Therapy(Long therapyId, Collection<Medicine> medicine, Collection<TimeInterval> timeInterval,
		Collection<Examination> examination) {
	super();
	this.therapyId = therapyId;
	this.medicine = medicine;
	this.timeInterval = timeInterval;
	this.examination = examination;
}

public Long getTherapyId() {
	return therapyId;
}

public void setTherapyId(Long therapyId) {
	this.therapyId = therapyId;
}

public java.util.Collection<Medicine> getMedicine() {
      if (medicine == null)
         medicine = new java.util.HashSet<Medicine>();
      return medicine;
   }
   
   public java.util.Iterator getIteratorMedicine() {
      if (medicine == null)
         medicine = new java.util.HashSet<Medicine>();
      return medicine.iterator();
   }
   
   public void setMedicine(java.util.Collection<Medicine> newMedicine) {
      removeAllMedicine();
      for (java.util.Iterator iter = newMedicine.iterator(); iter.hasNext();)
         addMedicine((Medicine)iter.next());
   }
   
   public void addMedicine(Medicine newMedicine) {
      if (newMedicine == null)
         return;
      if (this.medicine == null)
         this.medicine = new java.util.HashSet<Medicine>();
      if (!this.medicine.contains(newMedicine))
         this.medicine.add(newMedicine);
   }
   
   public void removeMedicine(Medicine oldMedicine) {
      if (oldMedicine == null)
         return;
      if (this.medicine != null)
         if (this.medicine.contains(oldMedicine))
            this.medicine.remove(oldMedicine);
   }

   public void removeAllMedicine() {
      if (medicine != null)
         medicine.clear();
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
   public java.util.Collection<Examination> getExamination() {
      if (examination == null)
         examination = new java.util.HashSet<Examination>();
      return examination;
   }
   
   public java.util.Iterator getIteratorExamination() {
      if (examination == null)
         examination = new java.util.HashSet<Examination>();
      return examination.iterator();
   }
   
   public void setExamination(java.util.Collection<Examination> newExamination) {
      removeAllExamination();
      for (java.util.Iterator iter = newExamination.iterator(); iter.hasNext();)
         addExamination((Examination)iter.next());
   }
   
   public void addExamination(Examination newExamination) {
      if (newExamination == null)
         return;
      if (this.examination == null)
         this.examination = new java.util.HashSet<Examination>();
      if (!this.examination.contains(newExamination))
         this.examination.add(newExamination);
   }
   
   public void removeExamination(Examination oldExamination) {
      if (oldExamination == null)
         return;
      if (this.examination != null)
         if (this.examination.contains(oldExamination))
            this.examination.remove(oldExamination);
   }
   
   public void removeAllExamination() {
      if (examination != null)
         examination.clear();
   }

}