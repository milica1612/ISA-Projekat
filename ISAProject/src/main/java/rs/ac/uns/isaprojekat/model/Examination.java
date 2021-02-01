package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Examination extends Appointment {
   public Examination(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
			Collection<Patient> patient, Collection<Shift> shift, Collection<AppointmentStatus> appointmentStatus) {
		super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
		// TODO Auto-generated constructor stub
	}
   
   @Override
public Date getDateAndTime() {
	// TODO Auto-generated method stub
	return super.getDateAndTime();
}

@Override
public void setDateAndTime(Date dateAndTime) {
	// TODO Auto-generated method stub
	super.setDateAndTime(dateAndTime);
}

@Override
public int getDuration() {
	// TODO Auto-generated method stub
	return super.getDuration();
}

@Override
public void setDuration(int duration) {
	// TODO Auto-generated method stub
	super.setDuration(duration);
}

@Override
public Double getPrice() {
	// TODO Auto-generated method stub
	return super.getPrice();
}

@Override
public void setPrice(Double price) {
	// TODO Auto-generated method stub
	super.setPrice(price);
}

@Override
public Long getAppointmentId() {
	// TODO Auto-generated method stub
	return super.getAppointmentId();
}

@Override
public void setAppointmentId(Long appointmentId) {
	// TODO Auto-generated method stub
	super.setAppointmentId(appointmentId);
}

@Override
public Boolean getCancelled() {
	// TODO Auto-generated method stub
	return super.getCancelled();
}

@Override
public void setCancelled(Boolean cancelled) {
	// TODO Auto-generated method stub
	super.setCancelled(cancelled);
}

@Override
public int getPoints() {
	// TODO Auto-generated method stub
	return super.getPoints();
}

@Override
public void setPoints(int points) {
	// TODO Auto-generated method stub
	super.setPoints(points);
}

@Override
public Collection<Patient> getPatient() {
	// TODO Auto-generated method stub
	return super.getPatient();
}

@Override
public Iterator getIteratorPatient() {
	// TODO Auto-generated method stub
	return super.getIteratorPatient();
}

@Override
public void setPatient(Collection<Patient> newPatient) {
	// TODO Auto-generated method stub
	super.setPatient(newPatient);
}

@Override
public void addPatient(Patient newPatient) {
	// TODO Auto-generated method stub
	super.addPatient(newPatient);
}

@Override
public void removePatient(Patient oldPatient) {
	// TODO Auto-generated method stub
	super.removePatient(oldPatient);
}

@Override
public void removeAllPatient() {
	// TODO Auto-generated method stub
	super.removeAllPatient();
}

@Override
public Collection<Shift> getShift() {
	// TODO Auto-generated method stub
	return super.getShift();
}

@Override
public Iterator getIteratorShift() {
	// TODO Auto-generated method stub
	return super.getIteratorShift();
}

@Override
public void setShift(Collection<Shift> newShift) {
	// TODO Auto-generated method stub
	super.setShift(newShift);
}

@Override
public void addShift(Shift newShift) {
	// TODO Auto-generated method stub
	super.addShift(newShift);
}

@Override
public void removeShift(Shift oldShift) {
	// TODO Auto-generated method stub
	super.removeShift(oldShift);
}

@Override
public void removeAllShift() {
	// TODO Auto-generated method stub
	super.removeAllShift();
}

@Override
public Collection<AppointmentStatus> getAppointmentStatus() {
	// TODO Auto-generated method stub
	return super.getAppointmentStatus();
}

@Override
public Iterator getIteratorAppointmentStatus() {
	// TODO Auto-generated method stub
	return super.getIteratorAppointmentStatus();
}

@Override
public void setAppointmentStatus(Collection<AppointmentStatus> newAppointmentStatus) {
	// TODO Auto-generated method stub
	super.setAppointmentStatus(newAppointmentStatus);
}

@Override
public void addAppointmentStatus(AppointmentStatus newAppointmentStatus) {
	// TODO Auto-generated method stub
	super.addAppointmentStatus(newAppointmentStatus);
}

@Override
public void removeAppointmentStatus(AppointmentStatus oldAppointmentStatus) {
	// TODO Auto-generated method stub
	super.removeAppointmentStatus(oldAppointmentStatus);
}

@Override
public void removeAllAppointmentStatus() {
	// TODO Auto-generated method stub
	super.removeAllAppointmentStatus();
}

@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}

@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}

@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
}

@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}


public java.util.Collection<Dermatologist> dermatologist;
   
   public java.util.Collection<Dermatologist> getDermatologist() {
      if (dermatologist == null)
         dermatologist = new java.util.HashSet<Dermatologist>();
      return dermatologist;
   }
   
   public java.util.Iterator getIteratorDermatologist() {
      if (dermatologist == null)
         dermatologist = new java.util.HashSet<Dermatologist>();
      return dermatologist.iterator();
   }
   
   public void setDermatologist(java.util.Collection<Dermatologist> newDermatologist) {
      removeAllDermatologist();
      for (java.util.Iterator iter = newDermatologist.iterator(); iter.hasNext();)
         addDermatologist((Dermatologist)iter.next());
   }
   
   public void addDermatologist(Dermatologist newDermatologist) {
      if (newDermatologist == null)
         return;
      if (this.dermatologist == null)
         this.dermatologist = new java.util.HashSet<Dermatologist>();
      if (!this.dermatologist.contains(newDermatologist))
         this.dermatologist.add(newDermatologist);
   }
   
   public void removeDermatologist(Dermatologist oldDermatologist) {
      if (oldDermatologist == null)
         return;
      if (this.dermatologist != null)
         if (this.dermatologist.contains(oldDermatologist))
            this.dermatologist.remove(oldDermatologist);
   }
   
   public void removeAllDermatologist() {
      if (dermatologist != null)
         dermatologist.clear();
   }

}