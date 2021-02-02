package rs.ac.uns.isaprojekat.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class EPrescription {
  // @Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long prescriptionId;
   
  // @Column(name = "date", nullable = false)
   private Date date;
   
   public Collection<Medicine> medicine;
   
   public EPrescription(Long prescriptionId, Date date) {
	super();
	this.prescriptionId = prescriptionId;
	this.date = date;
	this.medicine = new ArrayList<Medicine>();
}
	
	public Long getPrescriptionId() {
		return prescriptionId;
	}
	
	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public java.util.Collection<Medicine> getMedicine() {
	      if (medicine == null)
	         medicine = new java.util.HashSet<Medicine>();
	      return medicine;
	   }
	   
	   public java.util.Iterator getIteratorMedicine() {
	      if (medicine == null)
	         medicine = new java.util.HashSet<Medicine>();
	      return medicine.iterator();
	   }
	   
	   public void setMedicine(java.util.Collection<Medicine> newMedicine) {
	      removeAllMedicine();
	      for (java.util.Iterator iter = newMedicine.iterator(); iter.hasNext();)
	         addMedicine((Medicine)iter.next());
	   }
	   
	   public void addMedicine(Medicine newMedicine) {
	      if (newMedicine == null)
	         return;
	      if (this.medicine == null)
	         this.medicine = new java.util.HashSet<Medicine>();
	      if (!this.medicine.contains(newMedicine))
	         this.medicine.add(newMedicine);
	   }
	   
	   public void removeMedicine(Medicine oldMedicine) {
	      if (oldMedicine == null)
	         return;
	      if (this.medicine != null)
	         if (this.medicine.contains(oldMedicine))
	            this.medicine.remove(oldMedicine);
	   }
	   
	   public void removeAllMedicine() {
	      if (medicine != null)
	         medicine.clear();
	   }

}