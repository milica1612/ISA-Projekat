package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;
	
	@OneToOne(fetch = FetchType.LAZY)
    public Consultation consultation;
	@OneToOne(fetch = FetchType.LAZY)
    public Examination examination;
	   

	
	public Long getReportId() {
		return reportId;
	}



	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}



	public Consultation getConsultation() {
		return consultation;
	}



	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}



	public Examination getExamination() {
		return examination;
	}



	public void setExamination(Examination examination) {
		this.examination = examination;
	}



	public Report(Long reportId, Consultation consultation, Examination examination) {
		super();
		this.reportId = reportId;
		this.consultation = consultation;
		this.examination = examination;
	}



	public Report()
	{
		
	}
	

   
   
}