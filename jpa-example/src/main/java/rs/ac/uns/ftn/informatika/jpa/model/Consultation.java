package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Consultation extends Appointment {

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   public Pharmacist pharmacist;

   public Consultation(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
		Patient patient, Shift shift, AppointmentStatus appointmentStatus, Pharmacist pharmacist) {
	super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
	this.pharmacist = pharmacist;
    }
   
   public Consultation()
   {
	   
   }

	public Pharmacist getPharmacist() {
		return pharmacist;
	}
	
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}
    
}