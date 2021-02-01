package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Appointment {
   private Date dateAndTime;
   private int duration;
   private Double price;
   private Long appointmentId;
   private Boolean cancelled;
   private int points;
   
   public java.util.Collection<Patient> patient;
   public java.util.Collection<Shift> shift;
   public java.util.Collection<AppointmentStatus> appointmentStatus;
   
   public Appointment(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
		Collection<Patient> patient, Collection<Shift> shift, Collection<AppointmentStatus> appointmentStatus) {
	super();
	this.dateAndTime = dateAndTime;
	this.duration = duration;
	this.price = price;
	this.appointmentId = appointmentId;
	this.cancelled = cancelled;
	this.points = points;
	this.patient = patient;
	this.shift = shift;
	this.appointmentStatus = appointmentStatus;
}

public Date getDateAndTime() {
	return dateAndTime;
}

public void setDateAndTime(Date dateAndTime) {
	this.dateAndTime = dateAndTime;
}

public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Long getAppointmentId() {
	return appointmentId;
}

public void setAppointmentId(Long appointmentId) {
	this.appointmentId = appointmentId;
}

public Boolean getCancelled() {
	return cancelled;
}

public void setCancelled(Boolean cancelled) {
	this.cancelled = cancelled;
}

public int getPoints() {
	return points;
}

public void setPoints(int points) {
	this.points = points;
}

public java.util.Collection<Patient> getPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient;
   }
   
   public java.util.Iterator getIteratorPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient.iterator();
   }
   
   public void setPatient(java.util.Collection<Patient> newPatient) {
      removeAllPatient();
      for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
         addPatient((Patient)iter.next());
   }
   
   public void addPatient(Patient newPatient) {
      if (newPatient == null)
         return;
      if (this.patient == null)
         this.patient = new java.util.HashSet<Patient>();
      if (!this.patient.contains(newPatient))
         this.patient.add(newPatient);
   }
   
   public void removePatient(Patient oldPatient) {
      if (oldPatient == null)
         return;
      if (this.patient != null)
         if (this.patient.contains(oldPatient))
            this.patient.remove(oldPatient);
   }
   
   public void removeAllPatient() {
      if (patient != null)
         patient.clear();
   }
   public java.util.Collection<Shift> getShift() {
      if (shift == null)
         shift = new java.util.HashSet<Shift>();
      return shift;
   }
   
   public java.util.Iterator getIteratorShift() {
      if (shift == null)
         shift = new java.util.HashSet<Shift>();
      return shift.iterator();
   }
   
   public void setShift(java.util.Collection<Shift> newShift) {
      removeAllShift();
      for (java.util.Iterator iter = newShift.iterator(); iter.hasNext();)
         addShift((Shift)iter.next());
   }
   
   public void addShift(Shift newShift) {
      if (newShift == null)
         return;
      if (this.shift == null)
         this.shift = new java.util.HashSet<Shift>();
      if (!this.shift.contains(newShift))
         this.shift.add(newShift);
   }
   
   public void removeShift(Shift oldShift) {
      if (oldShift == null)
         return;
      if (this.shift != null)
         if (this.shift.contains(oldShift))
            this.shift.remove(oldShift);
   }
   
   public void removeAllShift() {
      if (shift != null)
         shift.clear();
   }
   public java.util.Collection<AppointmentStatus> getAppointmentStatus() {
      if (appointmentStatus == null)
         appointmentStatus = new java.util.HashSet<AppointmentStatus>();
      return appointmentStatus;
   }
   
   public java.util.Iterator getIteratorAppointmentStatus() {
      if (appointmentStatus == null)
         appointmentStatus = new java.util.HashSet<AppointmentStatus>();
      return appointmentStatus.iterator();
   }
   
   public void setAppointmentStatus(java.util.Collection<AppointmentStatus> newAppointmentStatus) {
      removeAllAppointmentStatus();
      for (java.util.Iterator iter = newAppointmentStatus.iterator(); iter.hasNext();)
         addAppointmentStatus((AppointmentStatus)iter.next());
   }
   
   public void addAppointmentStatus(AppointmentStatus newAppointmentStatus) {
      if (newAppointmentStatus == null)
         return;
      if (this.appointmentStatus == null)
         this.appointmentStatus = new java.util.HashSet<AppointmentStatus>();
      if (!this.appointmentStatus.contains(newAppointmentStatus))
         this.appointmentStatus.add(newAppointmentStatus);
   }
   
   public void removeAppointmentStatus(AppointmentStatus oldAppointmentStatus) {
      if (oldAppointmentStatus == null)
         return;
      if (this.appointmentStatus != null)
         if (this.appointmentStatus.contains(oldAppointmentStatus))
            this.appointmentStatus.remove(oldAppointmentStatus);
   }
   
   public void removeAllAppointmentStatus() {
      if (appointmentStatus != null)
         appointmentStatus.clear();
   }

}