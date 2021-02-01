package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 49fa66fc-bea2-427c-918b-e689a759268d */
public class Diagnosis {
   /** @pdOid 01f2037f-80a1-4ab0-8154-8d883ded85d3 */
   private Long diagnosisId;
   
   /** @pdRoleInfo migr=no name=Dermatologist assc=association52 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Dermatologist> dermatologist;
   /** @pdRoleInfo migr=no name=Patient assc=association53 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Patient> patient;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Dermatologist> getDermatologist() {
      if (dermatologist == null)
         dermatologist = new java.util.HashSet<Dermatologist>();
      return dermatologist;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDermatologist() {
      if (dermatologist == null)
         dermatologist = new java.util.HashSet<Dermatologist>();
      return dermatologist.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDermatologist */
   public void setDermatologist(java.util.Collection<Dermatologist> newDermatologist) {
      removeAllDermatologist();
      for (java.util.Iterator iter = newDermatologist.iterator(); iter.hasNext();)
         addDermatologist((Dermatologist)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDermatologist */
   public void addDermatologist(Dermatologist newDermatologist) {
      if (newDermatologist == null)
         return;
      if (this.dermatologist == null)
         this.dermatologist = new java.util.HashSet<Dermatologist>();
      if (!this.dermatologist.contains(newDermatologist))
         this.dermatologist.add(newDermatologist);
   }
   
   /** @pdGenerated default remove
     * @param oldDermatologist */
   public void removeDermatologist(Dermatologist oldDermatologist) {
      if (oldDermatologist == null)
         return;
      if (this.dermatologist != null)
         if (this.dermatologist.contains(oldDermatologist))
            this.dermatologist.remove(oldDermatologist);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDermatologist() {
      if (dermatologist != null)
         dermatologist.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Patient> getPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPatient() {
      if (patient == null)
         patient = new java.util.HashSet<Patient>();
      return patient.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPatient */
   public void setPatient(java.util.Collection<Patient> newPatient) {
      removeAllPatient();
      for (java.util.Iterator iter = newPatient.iterator(); iter.hasNext();)
         addPatient((Patient)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPatient */
   public void addPatient(Patient newPatient) {
      if (newPatient == null)
         return;
      if (this.patient == null)
         this.patient = new java.util.HashSet<Patient>();
      if (!this.patient.contains(newPatient))
         this.patient.add(newPatient);
   }
   
   /** @pdGenerated default remove
     * @param oldPatient */
   public void removePatient(Patient oldPatient) {
      if (oldPatient == null)
         return;
      if (this.patient != null)
         if (this.patient.contains(oldPatient))
            this.patient.remove(oldPatient);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPatient() {
      if (patient != null)
         patient.clear();
   }

}