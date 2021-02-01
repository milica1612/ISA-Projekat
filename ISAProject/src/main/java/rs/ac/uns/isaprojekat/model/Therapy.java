package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid f140d238-cdfe-4a3a-93fd-f88bf5c35df3 */
public class Therapy {
   /** @pdOid 0eb6360b-1fcc-428d-bf1f-506dc6a4ec1b */
   private Long therapyId;
   
   /** @pdRoleInfo migr=no name=Medicine assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Medicine> medicine;
   /** @pdRoleInfo migr=no name=TimeInterval assc=association63 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TimeInterval> timeInterval;
   /** @pdRoleInfo migr=no name=Examination assc=association65 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Examination> examination;
   
   
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
   /** @pdGenerated default getter */
   public java.util.Collection<Examination> getExamination() {
      if (examination == null)
         examination = new java.util.HashSet<Examination>();
      return examination;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorExamination() {
      if (examination == null)
         examination = new java.util.HashSet<Examination>();
      return examination.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newExamination */
   public void setExamination(java.util.Collection<Examination> newExamination) {
      removeAllExamination();
      for (java.util.Iterator iter = newExamination.iterator(); iter.hasNext();)
         addExamination((Examination)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExamination */
   public void addExamination(Examination newExamination) {
      if (newExamination == null)
         return;
      if (this.examination == null)
         this.examination = new java.util.HashSet<Examination>();
      if (!this.examination.contains(newExamination))
         this.examination.add(newExamination);
   }
   
   /** @pdGenerated default remove
     * @param oldExamination */
   public void removeExamination(Examination oldExamination) {
      if (oldExamination == null)
         return;
      if (this.examination != null)
         if (this.examination.contains(oldExamination))
            this.examination.remove(oldExamination);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllExamination() {
      if (examination != null)
         examination.clear();
   }

}