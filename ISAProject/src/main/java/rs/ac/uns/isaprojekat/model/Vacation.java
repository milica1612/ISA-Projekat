package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Vacation {
   private Long vacationId;
   
   public Status status;
   public TimeInterval timeInterval;
   public PharmacyEmployee pharmacyEmployee;
   
   public Vacation(Long vacationId, Status status, TimeInterval timeInterval, PharmacyEmployee pharmacyEmployee) {
		super();
		this.vacationId = vacationId;
		this.status = status;
		this.timeInterval = timeInterval;
		this.pharmacyEmployee = pharmacyEmployee;
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