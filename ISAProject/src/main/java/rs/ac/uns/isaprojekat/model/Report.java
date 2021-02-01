package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Report {
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