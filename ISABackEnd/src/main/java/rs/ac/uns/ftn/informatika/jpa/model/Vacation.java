package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Vacation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacationId;
   
	@Column(name = "status", nullable = false)
    public Status status;
    
	@OneToOne(fetch = FetchType.LAZY)
    public TimeInterval timeInterval;
   
	@OneToOne(fetch = FetchType.LAZY)
    public PharmacyEmployee pharmacyEmployee;
   
    public Vacation(Long vacationId, Status status, TimeInterval timeInterval, PharmacyEmployee pharmacyEmployee) {
		super();
		this.vacationId = vacationId;
		this.status = status;
		this.timeInterval = timeInterval;
		this.pharmacyEmployee = pharmacyEmployee;
   	}
    
    public Vacation()
    {
    	
    }

	public Long getVacationId() {
		return vacationId;
	}
	
	public void setVacationId(Long vacationId) {
		this.vacationId = vacationId;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public TimeInterval getTimeInterval() {
		return timeInterval;
	}
	
	public void setTimeInterval(TimeInterval timeInterval) {
		this.timeInterval = timeInterval;
	}
	
	public PharmacyEmployee getPharmacyEmployee() {
		return pharmacyEmployee;
	}
	
	public void setPharmacyEmployee(PharmacyEmployee pharmacyEmployee) {
		this.pharmacyEmployee = pharmacyEmployee;
	}
		
}