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
public class AnswerEmployee {
   	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answEmpId;
	
	@Column(name = "textEmp", nullable = false)
	private String textEmp;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public ComplaintEmployee complaintEmployee;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public SystemAdministrator systemAdministrator;
	
   
    public AnswerEmployee(String textEmp, Long answEmpId, ComplaintEmployee complaintEmployee, SystemAdministrator systemAdministrator) {
		super();
		this.textEmp = textEmp;
		this.answEmpId = answEmpId;
		this.complaintEmployee = complaintEmployee;
		this.systemAdministrator = systemAdministrator;
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

		public SystemAdministrator getSystemAdministrator() {
			return systemAdministrator;
		}

		public void setSystemAdministrator(SystemAdministrator systemAdministrator) {
			this.systemAdministrator = systemAdministrator;
		}
	
}