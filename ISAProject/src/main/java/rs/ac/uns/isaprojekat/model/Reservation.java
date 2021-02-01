package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Reservation {
   private Date deadline;
   private Long reservationId;
   private Boolean recieved;
   
   public java.util.Collection<Patient> patient;
   public java.util.Collection<MedicineItem> medicineItem;
   
   @Override
public String toString() {
	return "Reservation [deadline=" + deadline + ", reservationId=" + reservationId + ", recieved=" + recieved
			+ ", patient=" + patient + ", medicineItem=" + medicineItem + "]";
}

public Date getDeadline() {
	return deadline;
}

public void setDeadline(Date deadline) {
	this.deadline = deadline;
}

public Long getReservationId() {
	return reservationId;
}

public void setReservationId(Long reservationId) {
	this.reservationId = reservationId;
}

public Boolean getRecieved() {
	return recieved;
}

public void setRecieved(Boolean recieved) {
	this.recieved = recieved;
}

public java.util.Collection<Patient> getPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient;
   }
   
   public java.util.Iterator getIteratorPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient.iterator();
   }
   
   public void setPatient(java.util.Collection<Patient> newPatient) {
      removeAllPatient();
      for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
         addPatient((Patient)iter.next());
   }
   
   public void addPatient(Patient newPatient) {
      if (newPatient == null)
         return;
      if (this.patient == null)
         this.patient = new java.util.HashSet<Patient>();
      if (!this.patient.contains(newPatient))
         this.patient.add(newPatient);
   }
   
   public void removePatient(Patient oldPatient) {
      if (oldPatient == null)
         return;
      if (this.patient != null)
         if (this.patient.contains(oldPatient))
            this.patient.remove(oldPatient);
   }
   
   public void removeAllPatient() {
      if (patient != null)
         patient.clear();
   }
   public java.util.Collection<MedicineItem> getMedicineItem() {
      if (medicineItem == null)
         medicineItem = new java.util.HashSet<MedicineItem>();
      return medicineItem;
   }
   
   public java.util.Iterator getIteratorMedicineItem() {
      if (medicineItem == null)
         medicineItem = new java.util.HashSet<MedicineItem>();
      return medicineItem.iterator();
   }
   
   public void setMedicineItem(java.util.Collection<MedicineItem> newMedicineItem) {
      removeAllMedicineItem();
      for (java.util.Iterator iter = newMedicineItem.iterator(); iter.hasNext();)
         addMedicineItem((MedicineItem)iter.next());
   }
   
   public void addMedicineItem(MedicineItem newMedicineItem) {
      if (newMedicineItem == null)
         return;
      if (this.medicineItem == null)
         this.medicineItem = new java.util.HashSet<MedicineItem>();
      if (!this.medicineItem.contains(newMedicineItem))
         this.medicineItem.add(newMedicineItem);
   }
   
   public void removeMedicineItem(MedicineItem oldMedicineItem) {
      if (oldMedicineItem == null)
         return;
      if (this.medicineItem != null)
         if (this.medicineItem.contains(oldMedicineItem))
            this.medicineItem.remove(oldMedicineItem);
   }
   
   public void removeAllMedicineItem() {
      if (medicineItem != null)
         medicineItem.clear();
   }

}