package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Consultation extends Appointment {
	
   public Consultation(Date dateAndTime, int duration, Double price, Long appointmentId, Boolean cancelled, int points,
			Collection<Patient> patient, Collection<Shift> shift, Collection<AppointmentStatus> appointmentStatus) {
		super(dateAndTime, duration, price, appointmentId, cancelled, points, patient, shift, appointmentStatus);
		// TODO Auto-generated constructor stub
	}
   

   public java.util.Collection<Pharmacist> pharmacist;
   
   
   public java.util.Collection<Pharmacist> getPharmacist() {
      if (pharmacist == null)
         pharmacist = new java.util.HashSet<Pharmacist>();
      return pharmacist;
   }
   
   public java.util.Iterator getIteratorPharmacist() {
      if (pharmacist == null)
         pharmacist = new java.util.HashSet<Pharmacist>();
      return pharmacist.iterator();
   }
   
   public void setPharmacist(java.util.Collection<Pharmacist> newPharmacist) {
      removeAllPharmacist();
      for (java.util.Iterator iter = newPharmacist.iterator(); iter.hasNext();)
         addPharmacist((Pharmacist)iter.next());
   }
   
   public void addPharmacist(Pharmacist newPharmacist) {
      if (newPharmacist == null)
         return;
      if (this.pharmacist == null)
         this.pharmacist = new java.util.HashSet<Pharmacist>();
      if (!this.pharmacist.contains(newPharmacist))
         this.pharmacist.add(newPharmacist);
   }
   
   public void removePharmacist(Pharmacist oldPharmacist) {
      if (oldPharmacist == null)
         return;
      if (this.pharmacist != null)
         if (this.pharmacist.contains(oldPharmacist))
            this.pharmacist.remove(oldPharmacist);
   }
   
   public void removeAllPharmacist() {
      if (pharmacist != null)
         pharmacist.clear();
   }

}