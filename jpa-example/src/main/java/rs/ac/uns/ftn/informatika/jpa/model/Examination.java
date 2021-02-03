package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Examination extends Appointment {
   
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Dermatologist dermatologist;

    public Examination(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
			Patient patient, Shift shift, AppointmentStatus appointmentStatus,
			Dermatologist dermatologist) {
		super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
		this.dermatologist = dermatologist;
	}
	
	public Dermatologist getDermatologist() {
		return dermatologist;
	}
	
	public void setDermatologist(Dermatologist dermatologist) {
		this.dermatologist = dermatologist;
	}
   
   

}