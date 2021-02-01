package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class AnswerPharmacy {
   private String textPh;
   private Long answPhId;
   public ComplaintPharmacy complaintPharmacy;
   public SystemAdministrator systemAdministrator;
   
   public AnswerPharmacy(String textPh, Long answPhId, ComplaintPharmacy complaintPharmacy,
		SystemAdministrator systemAdministrator) {
	super();
	this.textPh = textPh;
	this.answPhId = answPhId;
	this.complaintPharmacy = complaintPharmacy;
	this.systemAdministrator = systemAdministrator;
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