package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Shift {
   private Date day;
   private Long shiftId;
   public WorkSchedule workSchedule;
   
   public Shift(Date day, Long shiftId, WorkSchedule workSchedule) {
		super();
		this.day = day;
		this.shiftId = shiftId;
		this.workSchedule = workSchedule;
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

	public WorkSchedule getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(WorkSchedule workSchedule) {
		this.workSchedule = workSchedule;
	}

}