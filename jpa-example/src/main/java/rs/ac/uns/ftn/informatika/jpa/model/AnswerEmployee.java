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


//@Entity
public class AnswerEmployee {
   	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answEmpId;
	
	//@Column(name = "textEmp", nullable = false)
	private String textEmp;

	//@OneToOne(mappedBy = "answerEmployee", cascade = CascadeType.ALL)
	public ComplaintEmployee complaintEmployee;
	
	
	public Set<SystemAdministrator> systemAdministrator = new HashSet<SystemAdministrator>();
	
   
    public AnswerEmployee(String textEmp, Long answEmpId, ComplaintEmployee complaintEmployee) {
		super();
		this.textEmp = textEmp;
		this.answEmpId = answEmpId;
		this.complaintEmployee = complaintEmployee;
	}
	
	public String getTextEmp() {
			return textEmp;
		}
	
		public void setTextEmp(String textEmp) {
			this.textEmp = textEmp;
		}
	
		public Long getAnswEmpId() {
			return answEmpId;
		}
	
		public void setAnswEmpId(Long answEmpId) {
			this.answEmpId = answEmpId;
		}
	
		public ComplaintEmployee getComplaintEmployee() {
			return complaintEmployee;
		}
	
		public void setComplaintEmployee(ComplaintEmployee complaintEmployee) {
			this.complaintEmployee = complaintEmployee;
		}
	
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