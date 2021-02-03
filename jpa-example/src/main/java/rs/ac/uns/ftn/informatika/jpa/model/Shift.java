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
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shiftId;
    
	@OneToOne(fetch = FetchType.LAZY)
    public WorkSchedule workSchedule;
    
	private Date day;
    
    public Shift(Date day, Long shiftId, WorkSchedule workSchedule) {
		super();
		this.day = day;
		this.shiftId = shiftId;
		this.workSchedule = workSchedule;
    }
    
    public Shift() 
    {
    	
    }

   	public Date getDay() {
		return day;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	public Long getShiftId() {
		return shiftId;
	}

	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}

	/*public WorkSchedule getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(WorkSchedule workSchedule) {
		this.workSchedule = workSchedule;
	}*/

}