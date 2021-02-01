package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Diagnosis {
   private Long diagnosisId;
   
   public java.util.Collection<Dermatologist> dermatologist;
   public java.util.Collection<Patient> patient;
   
   public Diagnosis(Long diagnosisId, Collection<Dermatologist> dermatologist, Collection<Patient> patient) {
	super();
	this.diagnosisId = diagnosisId;
	this.dermatologist = dermatologist;
	this.patient = patient;
}

public Long getDiagnosisId() {
	return diagnosisId;
}

public void setDiagnosisId(Long diagnosisId) {
	this.diagnosisId = diagnosisId;
}

public java.util.Collection<Dermatologist> getDermatologist() {
      if (dermatologist == null)
         dermatologist = new java.util.HashSet<Dermatologist>();
      return dermatologist;
   }
   
   public java.util.Iterator getIteratorDermatologist() {
      if (dermatologist == null)
         dermatologist = new java.util.HashSet<Dermatologist>();
      return dermatologist.iterator();
   }
   
   public void setDermatologist(java.util.Collection<Dermatologist> newDermatologist) {
      removeAllDermatologist();
      for (java.util.Iterator iter = newDermatologist.iterator(); iter.hasNext();)
         addDermatologist((Dermatologist)iter.next());
   }
   
   public void addDermatologist(Dermatologist newDermatologist) {
      if (newDermatologist == null)
         return;
      if (this.dermatologist == null)
         this.dermatologist = new java.util.HashSet<Dermatologist>();
      if (!this.dermatologist.contains(newDermatologist))
         this.dermatologist.add(newDermatologist);
   }
   
   public void removeDermatologist(Dermatologist oldDermatologist) {
      if (oldDermatologist == null)
         return;
      if (this.dermatologist != null)
         if (this.dermatologist.contains(oldDermatologist))
            this.dermatologist.remove(oldDermatologist);
   }
   
   public void removeAllDermatologist() {
      if (dermatologist != null)
         dermatologist.clear();
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

}