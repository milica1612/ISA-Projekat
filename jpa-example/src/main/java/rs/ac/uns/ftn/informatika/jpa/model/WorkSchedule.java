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
public class WorkSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workScheduleId;
	
	@Column(name = "startTime", nullable = false)
    private Date startTime;
	
	@Column(name = "endTime", nullable = false)
    private Date endTime;
    
	@OneToOne(fetch = FetchType.LAZY)
    public PharmacyEmployee pharmacyEmployee;
   
   
    public WorkSchedule(Date startTime, Date endTime, Long workScheduleId, PharmacyEmployee pharmacyEmployee) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.workScheduleId = workScheduleId;
		this.pharmacyEmployee = pharmacyEmployee;
   }
    
    public WorkSchedule()
    {
    	
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