package rs.ac.uns.isaprojekat.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long appointmentId;
	
	@Column(name = "dateAndTime", nullable = false)
    private Date dateAndTime;
	
	@Column(name = "duration", nullable = false)
    private int duration;
	
	@Column(name = "price", nullable = false)
    private Double price;
    
	@Column(name = "cancelled", nullable = false)
	private Boolean cancelled;
	
	@Column(name = "points", nullable = false)
    private int points;
	
	public Patient patient;
	
	public Shift shift;
	
	@Column(name = "appoitmentStatus", nullable = false)
    public AppointmentStatus appointmentStatus;
   
	   
	public Appointment(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
			Patient patient, Shift shift, AppointmentStatus appointmentStatus) {
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
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
   
   

}