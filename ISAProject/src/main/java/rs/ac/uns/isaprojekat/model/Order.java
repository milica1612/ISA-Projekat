package rs.ac.uns.isaprojekat.model;

import java.util.*;

/** @pdOid 1167499c-10d2-4c0c-80e1-3e6164ead5ce */
public class Order {
   /** @pdOid 8c2e2b5d-e6fd-4003-9d82-06d3222e0c0d */
   private Date offerDeadline;
   /** @pdOid 3db0f795-b3e9-4a33-9c0e-c57506508928 */
   private Long orderId;
   
   /** @pdRoleInfo migr=no name=OrderStatus assc=association23 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<OrderStatus> orderStatus;
   /** @pdRoleInfo migr=no name=Pharmacy assc=association36 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Pharmacy> pharmacy;
   /** @pdRoleInfo migr=no name=PharmacyAdministrator assc=association62 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<PharmacyAdministrator> pharmacyAdministrator;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<OrderStatus> getOrderStatus() {
      if (orderStatus == null)
         orderStatus = new java.util.HashSet<OrderStatus>();
      return orderStatus;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorOrderStatus() {
      if (orderStatus == null)
         orderStatus = new java.util.HashSet<OrderStatus>();
      return orderStatus.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOrderStatus */
   public void setOrderStatus(java.util.Collection<OrderStatus> newOrderStatus) {
      removeAllOrderStatus();
      for (java.util.Iterator iter = newOrderStatus.iterator(); iter.hasNext();)
         addOrderStatus((OrderStatus)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOrderStatus */
   public void addOrderStatus(OrderStatus newOrderStatus) {
      if (newOrderStatus == null)
         return;
      if (this.orderStatus == null)
         this.orderStatus = new java.util.HashSet<OrderStatus>();
      if (!this.orderStatus.contains(newOrderStatus))
         this.orderStatus.add(newOrderStatus);
   }
   
   /** @pdGenerated default remove
     * @param oldOrderStatus */
   public void removeOrderStatus(OrderStatus oldOrderStatus) {
      if (oldOrderStatus == null)
         return;
      if (this.orderStatus != null)
         if (this.orderStatus.contains(oldOrderStatus))
            this.orderStatus.remove(oldOrderStatus);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOrderStatus() {
      if (orderStatus != null)
         orderStatus.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Pharmacy> getPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacy */
   public void setPharmacy(java.util.Collection<Pharmacy> newPharmacy) {
      removeAllPharmacy();
      for (java.util.Iterator iter = newPharmacy.iterator(); iter.hasNext();)
         addPharmacy((Pharmacy)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacy */
   public void addPharmacy(Pharmacy newPharmacy) {
      if (newPharmacy == null)
         return;
      if (this.pharmacy == null)
         this.pharmacy = new java.util.HashSet<Pharmacy>();
      if (!this.pharmacy.contains(newPharmacy))
         this.pharmacy.add(newPharmacy);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacy */
   public void removePharmacy(Pharmacy oldPharmacy) {
      if (oldPharmacy == null)
         return;
      if (this.pharmacy != null)
         if (this.pharmacy.contains(oldPharmacy))
            this.pharmacy.remove(oldPharmacy);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacy() {
      if (pharmacy != null)
         pharmacy.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<PharmacyAdministrator> getPharmacyAdministrator() {
      if (pharmacyAdministrator == null)
         pharmacyAdministrator = new java.util.HashSet<PharmacyAdministrator>();
      return pharmacyAdministrator;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPharmacyAdministrator() {
      if (pharmacyAdministrator == null)
         pharmacyAdministrator = new java.util.HashSet<PharmacyAdministrator>();
      return pharmacyAdministrator.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPharmacyAdministrator */
   public void setPharmacyAdministrator(java.util.Collection<PharmacyAdministrator> newPharmacyAdministrator) {
      removeAllPharmacyAdministrator();
      for (java.util.Iterator iter = newPharmacyAdministrator.iterator(); iter.hasNext();)
         addPharmacyAdministrator((PharmacyAdministrator)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPharmacyAdministrator */
   public void addPharmacyAdministrator(PharmacyAdministrator newPharmacyAdministrator) {
      if (newPharmacyAdministrator == null)
         return;
      if (this.pharmacyAdministrator == null)
         this.pharmacyAdministrator = new java.util.HashSet<PharmacyAdministrator>();
      if (!this.pharmacyAdministrator.contains(newPharmacyAdministrator))
         this.pharmacyAdministrator.add(newPharmacyAdministrator);
   }
   
   /** @pdGenerated default remove
     * @param oldPharmacyAdministrator */
   public void removePharmacyAdministrator(PharmacyAdministrator oldPharmacyAdministrator) {
      if (oldPharmacyAdministrator == null)
         return;
      if (this.pharmacyAdministrator != null)
         if (this.pharmacyAdministrator.contains(oldPharmacyAdministrator))
            this.pharmacyAdministrator.remove(oldPharmacyAdministrator);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPharmacyAdministrator() {
      if (pharmacyAdministrator != null)
         pharmacyAdministrator.clear();
   }

}