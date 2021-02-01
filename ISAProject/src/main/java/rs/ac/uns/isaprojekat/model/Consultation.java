package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Consultation extends Appointment {
	
   public Pharmacist pharmacist;

public Consultation(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
		Patient patient, Shift shift, AppointmentStatus appointmentStatus, Pharmacist pharmacist) {
	super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
	this.pharmacist = pharmacist;
}

public Pharmacist getPharmacist() {
	return pharmacist;
}

public void setPharmacist(Pharmacist pharmacist) {
	this.pharmacist = pharmacist;
}




    
}