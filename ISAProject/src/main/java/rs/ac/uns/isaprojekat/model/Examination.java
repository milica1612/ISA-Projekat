package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 42d08c67-e0da-48f2-b3c9-2b62b3039db0 */
public class Examination extends Appointment {
   /** @pdRoleInfo migr=no name=Dermatologist assc=association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Dermatologist> dermatologist;
   
   
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

}