package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Order {
   private Date offerDeadline;
   private Long orderId;
   
   public java.util.Collection<OrderStatus> orderStatus;
   public java.util.Collection<Pharmacy> pharmacy;
   public java.util.Collection<PharmacyAdministrator> pharmacyAdministrator;
   
   
   public Order(Date offerDeadline, Long orderId, Collection<OrderStatus> orderStatus, Collection<Pharmacy> pharmacy,
		Collection<PharmacyAdministrator> pharmacyAdministrator) {
	super();
	this.offerDeadline = offerDeadline;
	this.orderId = orderId;
	this.orderStatus = orderStatus;
	this.pharmacy = pharmacy;
	this.pharmacyAdministrator = pharmacyAdministrator;
}

public Date getOfferDeadline() {
	return offerDeadline;
}

public void setOfferDeadline(Date offerDeadline) {
	this.offerDeadline = offerDeadline;
}

public Long getOrderId() {
	return orderId;
}

public void setOrderId(Long orderId) {
	this.orderId = orderId;
}

public java.util.Collection<OrderStatus> getOrderStatus() {
      if (orderStatus == null)
         orderStatus = new java.util.HashSet<OrderStatus>();
      return orderStatus;
   }
   
   public java.util.Iterator getIteratorOrderStatus() {
      if (orderStatus == null)
         orderStatus = new java.util.HashSet<OrderStatus>();
      return orderStatus.iterator();
   }
   
   public void setOrderStatus(java.util.Collection<OrderStatus> newOrderStatus) {
      removeAllOrderStatus();
      for (java.util.Iterator iter = newOrderStatus.iterator(); iter.hasNext();)
         addOrderStatus((OrderStatus)iter.next());
   }
   
   public void addOrderStatus(OrderStatus newOrderStatus) {
      if (newOrderStatus == null)
         return;
      if (this.orderStatus == null)
         this.orderStatus = new java.util.HashSet<OrderStatus>();
      if (!this.orderStatus.contains(newOrderStatus))
         this.orderStatus.add(newOrderStatus);
   }
   
   public void removeOrderStatus(OrderStatus oldOrderStatus) {
      if (oldOrderStatus == null)
         return;
      if (this.orderStatus != null)
         if (this.orderStatus.contains(oldOrderStatus))
            this.orderStatus.remove(oldOrderStatus);
   }
   
   public void removeAllOrderStatus() {
      if (orderStatus != null)
         orderStatus.clear();
   }
   public java.util.Collection<Pharmacy> getPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy;
   }
   
   public java.util.Iterator getIteratorPharmacy() {
      if (pharmacy == null)
         pharmacy = new java.util.HashSet<Pharmacy>();
      return pharmacy.iterator();
   }
   
   public void setPharmacy(java.util.Collection<Pharmacy> newPharmacy) {
      removeAllPharmacy();
      for (java.util.Iterator iter = newPharmacy.iterator(); iter.hasNext();)
         addPharmacy((Pharmacy)iter.next());
   }
   
   public void addPharmacy(Pharmacy newPharmacy) {
      if (newPharmacy == null)
         return;
      if (this.pharmacy == null)
         this.pharmacy = new java.util.HashSet<Pharmacy>();
      if (!this.pharmacy.contains(newPharmacy))
         this.pharmacy.add(newPharmacy);
   }
   
   public void removePharmacy(Pharmacy oldPharmacy) {
      if (oldPharmacy == null)
         return;
      if (this.pharmacy != null)
         if (this.pharmacy.contains(oldPharmacy))
            this.pharmacy.remove(oldPharmacy);
   }
   
   public void removeAllPharmacy() {
      if (pharmacy != null)
         pharmacy.clear();
   }

   public java.util.Collection<PharmacyAdministrator> getPharmacyAdministrator() {
      if (pharmacyAdministrator == null)
         pharmacyAdministrator = new java.util.HashSet<PharmacyAdministrator>();
      return pharmacyAdministrator;
   }
   
   public java.util.Iterator getIteratorPharmacyAdministrator() {
      if (pharmacyAdministrator == null)
         pharmacyAdministrator = new java.util.HashSet<PharmacyAdministrator>();
      return pharmacyAdministrator.iterator();
   }
   
   public void setPharmacyAdministrator(java.util.Collection<PharmacyAdministrator> newPharmacyAdministrator) {
      removeAllPharmacyAdministrator();
      for (java.util.Iterator iter = newPharmacyAdministrator.iterator(); iter.hasNext();)
         addPharmacyAdministrator((PharmacyAdministrator)iter.next());
   }
   
   public void addPharmacyAdministrator(PharmacyAdministrator newPharmacyAdministrator) {
      if (newPharmacyAdministrator == null)
         return;
      if (this.pharmacyAdministrator == null)
         this.pharmacyAdministrator = new java.util.HashSet<PharmacyAdministrator>();
      if (!this.pharmacyAdministrator.contains(newPharmacyAdministrator))
         this.pharmacyAdministrator.add(newPharmacyAdministrator);
   }
   
   public void removePharmacyAdministrator(PharmacyAdministrator oldPharmacyAdministrator) {
      if (oldPharmacyAdministrator == null)
         return;
      if (this.pharmacyAdministrator != null)
         if (this.pharmacyAdministrator.contains(oldPharmacyAdministrator))
            this.pharmacyAdministrator.remove(oldPharmacyAdministrator);
   }
   
   public void removeAllPharmacyAdministrator() {
      if (pharmacyAdministrator != null)
         pharmacyAdministrator.clear();
   }
}