package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class AnswerPharmacy {
   private String textPh;
   private Long answPhId;
   
   public AnswerPharmacy(String textPh, Long answPhId, ComplaintPharmacy complaintPharmacy,
		Collection<SystemAdministrator> systemAdministrator) {
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

public ComplaintPharmacy complaintPharmacy;
   public java.util.Collection<SystemAdministrator> systemAdministrator;
   
   
   public java.util.Collection<SystemAdministrator> getSystemAdministrator() {
      if (systemAdministrator == null)
         systemAdministrator = new java.util.HashSet<SystemAdministrator>();
      return systemAdministrator;
   }
   
   public java.util.Iterator getIteratorSystemAdministrator() {
      if (systemAdministrator == null)
         systemAdministrator = new java.util.HashSet<SystemAdministrator>();
      return systemAdministrator.iterator();
   }
   
   public void setSystemAdministrator(java.util.Collection<SystemAdministrator> newSystemAdministrator) {
      removeAllSystemAdministrator();
      for (java.util.Iterator iter = newSystemAdministrator.iterator(); iter.hasNext();)
         addSystemAdministrator((SystemAdministrator)iter.next());
   }
   
   public void addSystemAdministrator(SystemAdministrator newSystemAdministrator) {
      if (newSystemAdministrator == null)
         return;
      if (this.systemAdministrator == null)
         this.systemAdministrator = new java.util.HashSet<SystemAdministrator>();
      if (!this.systemAdministrator.contains(newSystemAdministrator))
         this.systemAdministrator.add(newSystemAdministrator);
   }
   
   public void removeSystemAdministrator(SystemAdministrator oldSystemAdministrator) {
      if (oldSystemAdministrator == null)
         return;
      if (this.systemAdministrator != null)
         if (this.systemAdministrator.contains(oldSystemAdministrator))
            this.systemAdministrator.remove(oldSystemAdministrator);
   }
   
   public void removeAllSystemAdministrator() {
      if (systemAdministrator != null)
         systemAdministrator.clear();
   }

}