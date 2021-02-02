package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Examination extends Appointment {
   
	public Collection<Dermatologist> dermatologist;

    public Examination(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
			Patient patient, Shift shift, AppointmentStatus appointmentStatus,
			Collection<Dermatologist> dermatologist) {
		super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
		this.dermatologist = dermatologist;
	}
	
	public Collection<Dermatologist> getDermatologist() {
		return dermatologist;
	}
	
	public void setDermatologist(Collection<Dermatologist> dermatologist) {
		this.dermatologist = dermatologist;
	}
   
   

}