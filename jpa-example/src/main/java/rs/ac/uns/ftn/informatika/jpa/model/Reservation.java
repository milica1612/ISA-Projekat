package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
	
	@Column(name = "recieved", nullable = false)
    private Boolean recieved;
	
	@OneToOne(fetch = FetchType.LAZY)
    public Patient patient;
    
	@ManyToOne(fetch = FetchType.LAZY)
    public MedicineItem medicineItem;
    
	@Column(name = "deadline", nullable = false)
    private Date deadline;
   
    public Reservation(Date deadline, Long reservationId, Boolean recieved, Patient patient, MedicineItem item) {
		super();
		this.deadline = deadline;
		this.reservationId = reservationId;
		this.recieved = recieved;
		this.patient = patient;
		this.medicineItem = item;
	}
    
    public Reservation() 
    {

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

	public MedicineItem getMedicineItem() {
		return medicineItem;
	}

	public void setMedicineItem(MedicineItem medicineItem) {
		this.medicineItem = medicineItem;
	}
	
	
}