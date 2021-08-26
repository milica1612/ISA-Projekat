package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.model.Status;

public class PharmacistVacationDTO {
	
	private Long vacationId;
	private String firstName;
	private String lastName;
	private Date startDate;
	private Date endDate;
	private Status status;
	
	public PharmacistVacationDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PharmacistVacationDTO(Long vacationId, String firstName, String lastName, Date startDate, Date endDate,
			Status status) {
		super();
		this.vacationId = vacationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Long getVacationId() {
		return vacationId;
	}

	public void setVacationId(Long vacationId) {
		this.vacationId = vacationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
