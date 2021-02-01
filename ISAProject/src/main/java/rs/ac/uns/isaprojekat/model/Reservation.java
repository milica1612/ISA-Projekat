package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Reservation {
   private Date deadline;
   private Long reservationId;
   private Boolean recieved;
   public Patient patient;
   public Collection<MedicineItem> medicineItem;
   
   
   public Reservation(Date deadline, Long reservationId, Boolean recieved, Patient patient) {
	super();
	this.deadline = deadline;
	this.reservationId = reservationId;
	this.recieved = recieved;
	this.patient = patient;
	this.medicineItem = new ArrayList<MedicineItem>();
}

@Override
   public String toString() {
	   return "Reservation [deadline=" + deadline + ", reservationId=" + reservationId + ", recieved=" + recieved
			+ ", patient=" + patient + ", medicineItem=" + medicineItem + "]";
   }

	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Long getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	
	public Boolean getRecieved() {
		return recieved;
	}
	
	public void setRecieved(Boolean recieved) {
		this.recieved = recieved;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Collection<MedicineItem> getMedicineItem() {
		return medicineItem;
	}
	
	public void setMedicineItem(Collection<MedicineItem> medicineItem) {
		this.medicineItem = medicineItem;
	}

}