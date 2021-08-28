package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
	
	@Column(name = "reservationCode", nullable = false)
    private String reservationCode;
	
	@Column(name = "recieved", nullable = false)
    private Boolean recieved;
	
	@OneToOne(fetch = FetchType.EAGER)
    public Patient patient;
    
	@ManyToOne(fetch = FetchType.EAGER)
    public MedicineItem medicineItem;
    
	@Column(name = "deadline", nullable = false)
    private Date deadline;
	
	@ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.DETACH)
	@JoinColumn(name = "pharmacy_pharmacy_id", referencedColumnName = "pharmacy_id")
	public Pharmacy pharmacy;
   
    public Reservation(Date deadline, String reservationCode, Boolean recieved, Patient patient,
    		MedicineItem item, Pharmacy pharmacy) {
		super();
		this.deadline = deadline;
		this.reservationCode = reservationCode;
		this.recieved = recieved;
		this.patient = patient;
		this.medicineItem = item;
		this.pharmacy = pharmacy;
	}
    
    public Reservation() 
    {

	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationCode=" + reservationCode + ", recieved="
				+ recieved + ", patient=" + patient + ", medicineItem=" + medicineItem + ", deadline=" + deadline + "]";
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

	public String getReservationCode() {
		return reservationCode;
	}
	
	

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}
		
}