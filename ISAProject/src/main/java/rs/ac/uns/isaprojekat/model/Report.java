package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Report {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;
	
	public Appointment appointment;
	   
	public Report(Long reportId, Appointment appointment) {
		super();
		this.reportId = reportId;
		this.appointment = appointment;
	}
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
   
   
}