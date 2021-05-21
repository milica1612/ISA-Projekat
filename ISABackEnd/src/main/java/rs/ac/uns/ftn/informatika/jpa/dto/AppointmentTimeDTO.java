package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import javax.persistence.Column;

public class AppointmentTimeDTO {
	
	private Date dateAndTime;
	private int duration;
	
	public AppointmentTimeDTO() {}

	public AppointmentTimeDTO(Date dateAndTime, int duration) {
		super();
		this.dateAndTime = dateAndTime;
		this.duration = duration;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
