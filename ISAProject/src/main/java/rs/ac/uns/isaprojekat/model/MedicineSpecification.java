package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid c648782e-318e-45d1-af30-c0ead02f13f3 */
public class MedicineSpecification {
   /** @pdOid 50134ccc-e7dc-4d67-aed6-0143dd599736 */
   private Double dosage;
   /** @pdOid 09df5233-f38d-4232-83c9-58c12bc27197 */
   private Long medSpecId;
   
   /** @pdRoleInfo migr=no name=Contraindication assc=association39 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Contraindication> contraindication;
   /** @pdRoleInfo migr=no name=Ingridient assc=association40 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Ingridient> ingridient;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Contraindication> getContraindication() {
      if (contraindication == null)
         contraindication = new java.util.HashSet<Contraindication>();
      return contraindication;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorContraindication() {
      if (contraindication == null)
         contraindication = new java.util.HashSet<Contraindication>();
      return contraindication.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newContraindication */
   public void setContraindication(java.util.Collection<Contraindication> newContraindication) {
      removeAllContraindication();
      for (java.util.Iterator iter = newContraindication.iterator(); iter.hasNext();)
         addContraindication((Contraindication)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newContraindication */
   public void addContraindication(Contraindication newContraindication) {
      if (newContraindication == null)
         return;
      if (this.contraindication == null)
         this.contraindication = new java.util.HashSet<Contraindication>();
      if (!this.contraindication.contains(newContraindication))
         this.contraindication.add(newContraindication);
   }
   
   /** @pdGenerated default remove
     * @param oldContraindication */
   public void removeContraindication(Contraindication oldContraindication) {
      if (oldContraindication == null)
         return;
      if (this.contraindication != null)
         if (this.contraindication.contains(oldContraindication))
            this.contraindication.remove(oldContraindication);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllContraindication() {
      if (contraindication != null)
         contraindication.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Ingridient> getIngridient() {
      if (ingridient == null)
         ingridient = new java.util.HashSet<Ingridient>();
      return ingridient;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIngridient() {
      if (ingridient == null)
         ingridient = new java.util.HashSet<Ingridient>();
      return ingridient.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIngridient */
   public void setIngridient(java.util.Collection<Ingridient> newIngridient) {
      removeAllIngridient();
      for (java.util.Iterator iter = newIngridient.iterator(); iter.hasNext();)
         addIngridient((Ingridient)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIngridient */
   public void addIngridient(Ingridient newIngridient) {
      if (newIngridient == null)
         return;
      if (this.ingridient == null)
         this.ingridient = new java.util.HashSet<Ingridient>();
      if (!this.ingridient.contains(newIngridient))
         this.ingridient.add(newIngridient);
   }
   
   /** @pdGenerated default remove
     * @param oldIngridient */
   public void removeIngridient(Ingridient oldIngridient) {
      if (oldIngridient == null)
         return;
      if (this.ingridient != null)
         if (this.ingridient.contains(oldIngridient))
            this.ingridient.remove(oldIngridient);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIngridient() {
      if (ingridient != null)
         ingridient.clear();
   }

}