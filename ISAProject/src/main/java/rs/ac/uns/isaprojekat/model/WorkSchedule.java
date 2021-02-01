package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class WorkSchedule {
   private Date startTime;
   private Date endTime;
   private Long workScheduleId;
   public PharmacyEmployee pharmacyEmployee;
   
   
   public WorkSchedule(Date startTime, Date endTime, Long workScheduleId, PharmacyEmployee pharmacyEmployee) {
	super();
	this.startTime = startTime;
	this.endTime = endTime;
	this.workScheduleId = workScheduleId;
	this.pharmacyEmployee = pharmacyEmployee;
   }


	public Date getStartTime() {
		return startTime;
	}
	
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	
	public Date getEndTime() {
		return endTime;
	}
	
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	public Long getWorkScheduleId() {
		return workScheduleId;
	}
	
	
	public void setWorkScheduleId(Long workScheduleId) {
		this.workScheduleId = workScheduleId;
	}
	
	
	public PharmacyEmployee getPharmacyEmployee() {
		return pharmacyEmployee;
	}
	
	
	public void setPharmacyEmployee(PharmacyEmployee pharmacyEmployee) {
		this.pharmacyEmployee = pharmacyEmployee;
	}

}