package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 59bb93bc-1fcf-4d7d-8f6c-7c9e9b85db93 */
public class Offer {
   /** @pdOid fe57b7a9-485d-4d5d-acdb-223f7e0fd4d8 */
   private Date deliveryDeadline;
   /** @pdOid be8aaf76-10de-4033-a457-b43a35e0a656 */
   private Double price;
   /** @pdOid 82f6b59f-99e0-4fd7-af6a-6051be1286ef */
   private Long offerId;
   
   /** @pdRoleInfo migr=no name=Supplier assc=association21 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Supplier> supplier;
   /** @pdRoleInfo migr=no name=Order assc=association22 mult=1..1 */
   public Order order;
   /** @pdRoleInfo migr=no name=Status assc=association24 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Status> status;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Supplier> getSupplier() {
      if (supplier == null)
         supplier = new java.util.HashSet<Supplier>();
      return supplier;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSupplier() {
      if (supplier == null)
         supplier = new java.util.HashSet<Supplier>();
      return supplier.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSupplier */
   public void setSupplier(java.util.Collection<Supplier> newSupplier) {
      removeAllSupplier();
      for (java.util.Iterator iter = newSupplier.iterator(); iter.hasNext();)
         addSupplier((Supplier)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSupplier */
   public void addSupplier(Supplier newSupplier) {
      if (newSupplier == null)
         return;
      if (this.supplier == null)
         this.supplier = new java.util.HashSet<Supplier>();
      if (!this.supplier.contains(newSupplier))
         this.supplier.add(newSupplier);
   }
   
   /** @pdGenerated default remove
     * @param oldSupplier */
   public void removeSupplier(Supplier oldSupplier) {
      if (oldSupplier == null)
         return;
      if (this.supplier != null)
         if (this.supplier.contains(oldSupplier))
            this.supplier.remove(oldSupplier);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSupplier() {
      if (supplier != null)
         supplier.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Status> getStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStatus */
   public void setStatus(java.util.Collection<Status> newStatus) {
      removeAllStatus();
      for (java.util.Iterator iter = newStatus.iterator(); iter.hasNext();)
         addStatus((Status)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStatus */
   public void addStatus(Status newStatus) {
      if (newStatus == null)
         return;
      if (this.status == null)
         this.status = new java.util.HashSet<Status>();
      if (!this.status.contains(newStatus))
         this.status.add(newStatus);
   }
   
   /** @pdGenerated default remove
     * @param oldStatus */
   public void removeStatus(Status oldStatus) {
      if (oldStatus == null)
         return;
      if (this.status != null)
         if (this.status.contains(oldStatus))
            this.status.remove(oldStatus);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStatus() {
      if (status != null)
         status.clear();
   }

}