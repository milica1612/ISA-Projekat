package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Examination extends Appointment {
   
public java.util.Collection<Dermatologist> dermatologist;

   public Examination(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
			Patient patient, Shift shift, AppointmentStatus appointmentStatus,
			Collection<Dermatologist> dermatologist) {
		super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
		this.dermatologist = dermatologist;
	}

public java.util.Collection<Dermatologist> getDermatologist() {
	return dermatologist;
}

public void setDermatologist(java.util.Collection<Dermatologist> dermatologist) {
	this.dermatologist = dermatologist;
}
   
   

}