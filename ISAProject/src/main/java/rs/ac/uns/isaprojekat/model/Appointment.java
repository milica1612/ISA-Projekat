package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 3833fca0-aefd-4cbf-82e8-83fd20a4e2d0 */
public class Appointment {
   /** @pdOid eefee3f2-a620-45b9-b098-3507d0fc4d47 */
   private Date dateAndTime;
   /** @pdOid 1caa8236-4e41-4711-9c16-46b395246af9 */
   private int duration;
   /** @pdOid e8c3eb3e-d5da-4fac-8303-a97bf0e0739c */
   private Double price;
   /** @pdOid 71a642a4-faaa-4d2c-95dc-2e0dd16dcf33 */
   private Long appointmentId;
   /** @pdOid 43820c1a-30da-46ed-9131-38732c91df63 */
   private Boolean cancelled;
   /** @pdOid cd6bc355-9f69-4fcf-a8b7-9501375ad426 */
   private int points;
   
   /** @pdRoleInfo migr=no name=Patient assc=association2 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   /** @pdRoleInfo migr=no name=Shift assc=association54 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Shift> shift;
   /** @pdRoleInfo migr=no name=AppointmentStatus assc=association61 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<AppointmentStatus> appointmentStatus;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Patient> getPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPatient */
   public void setPatient(java.util.Collection<Patient> newPatient) {
      removeAllPatient();
      for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
         addPatient((Patient)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPatient */
   public void addPatient(Patient newPatient) {
      if (newPatient == null)
         return;
      if (this.patient == null)
         this.patient = new java.util.HashSet<Patient>();
      if (!this.patient.contains(newPatient))
         this.patient.add(newPatient);
   }
   
   /** @pdGenerated default remove
     * @param oldPatient */
   public void removePatient(Patient oldPatient) {
      if (oldPatient == null)
         return;
      if (this.patient != null)
         if (this.patient.contains(oldPatient))
            this.patient.remove(oldPatient);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPatient() {
      if (patient != null)
         patient.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Shift> getShift() {
      if (shift == null)
         shift = new java.util.HashSet<Shift>();
      return shift;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorShift() {
      if (shift == null)
         shift = new java.util.HashSet<Shift>();
      return shift.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newShift */
   public void setShift(java.util.Collection<Shift> newShift) {
      removeAllShift();
      for (java.util.Iterator iter = newShift.iterator(); iter.hasNext();)
         addShift((Shift)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newShift */
   public void addShift(Shift newShift) {
      if (newShift == null)
         return;
      if (this.shift == null)
         this.shift = new java.util.HashSet<Shift>();
      if (!this.shift.contains(newShift))
         this.shift.add(newShift);
   }
   
   /** @pdGenerated default remove
     * @param oldShift */
   public void removeShift(Shift oldShift) {
      if (oldShift == null)
         return;
      if (this.shift != null)
         if (this.shift.contains(oldShift))
            this.shift.remove(oldShift);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllShift() {
      if (shift != null)
         shift.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<AppointmentStatus> getAppointmentStatus() {
      if (appointmentStatus == null)
         appointmentStatus = new java.util.HashSet<AppointmentStatus>();
      return appointmentStatus;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAppointmentStatus() {
      if (appointmentStatus == null)
         appointmentStatus = new java.util.HashSet<AppointmentStatus>();
      return appointmentStatus.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAppointmentStatus */
   public void setAppointmentStatus(java.util.Collection<AppointmentStatus> newAppointmentStatus) {
      removeAllAppointmentStatus();
      for (java.util.Iterator iter = newAppointmentStatus.iterator(); iter.hasNext();)
         addAppointmentStatus((AppointmentStatus)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAppointmentStatus */
   public void addAppointmentStatus(AppointmentStatus newAppointmentStatus) {
      if (newAppointmentStatus == null)
         return;
      if (this.appointmentStatus == null)
         this.appointmentStatus = new java.util.HashSet<AppointmentStatus>();
      if (!this.appointmentStatus.contains(newAppointmentStatus))
         this.appointmentStatus.add(newAppointmentStatus);
   }
   
   /** @pdGenerated default remove
     * @param oldAppointmentStatus */
   public void removeAppointmentStatus(AppointmentStatus oldAppointmentStatus) {
      if (oldAppointmentStatus == null)
         return;
      if (this.appointmentStatus != null)
         if (this.appointmentStatus.contains(oldAppointmentStatus))
            this.appointmentStatus.remove(oldAppointmentStatus);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAppointmentStatus() {
      if (appointmentStatus != null)
         appointmentStatus.clear();
   }

}