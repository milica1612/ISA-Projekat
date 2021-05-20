package rs.ac.uns.ftn.informatika.jpa.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class AnswerPharmacy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answPhId; 
	
	@Column(name = "textPh", nullable = false)
    private String textPh;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public ComplaintPharmacy complaintPharmacy;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public SystemAdministrator systemAdministrator;
   
   public AnswerPharmacy(String textPh, Long answPhId, ComplaintPharmacy complaintPharmacy,
		SystemAdministrator systemAdministrator) {
	super();
	this.textPh = textPh;
	this.answPhId = answPhId;
	this.complaintPharmacy = complaintPharmacy;
	this.systemAdministrator = systemAdministrator;
	}
	
   public AnswerPharmacy()
   {
	   
   }
   
	public String getTextPh() {
		return textPh;
	}
	
	public void setTextPh(String textPh) {
		this.textPh = textPh;
	}
	
	public Long getAnswPhId() {
		return answPhId;
	}
	
	public void setAnswPhId(Long answPhId) {
		this.answPhId = answPhId;
	}
	
	public ComplaintPharmacy getComplaintPharmacy() {
		return complaintPharmacy;
	}
	
	public void setComplaintPharmacy(ComplaintPharmacy complaintPharmacy) {
		this.complaintPharmacy = complaintPharmacy;
	}
	
	public SystemAdministrator getSystemAdministrator() {
		return systemAdministrator;
	}
	
	public void setSystemAdministrator(SystemAdministrator systemAdministrator) {
		this.systemAdministrator = systemAdministrator;
	}
	

}