package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Offer {
   private Date deliveryDeadline;
   private Double price;
   private Long offerId;
   public java.util.Collection<Supplier> supplier;
   public Order order;
   public java.util.Collection<Status> status;
   
   public Offer(Date deliveryDeadline, Double price, Long offerId, Collection<Supplier> supplier, Order order,
		Collection<Status> status) {
	super();
	this.deliveryDeadline = deliveryDeadline;
	this.price = price;
	this.offerId = offerId;
	this.supplier = supplier;
	this.order = order;
	this.status = status;
}

public Date getDeliveryDeadline() {
	return deliveryDeadline;
}

public void setDeliveryDeadline(Date deliveryDeadline) {
	this.deliveryDeadline = deliveryDeadline;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Long getOfferId() {
	return offerId;
}

public void setOfferId(Long offerId) {
	this.offerId = offerId;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public java.util.Collection<Supplier> getSupplier() {
      if (supplier == null)
         supplier = new java.util.HashSet<Supplier>();
      return supplier;
   }
   
   public java.util.Iterator getIteratorSupplier() {
      if (supplier == null)
         supplier = new java.util.HashSet<Supplier>();
      return supplier.iterator();
   }
   
   public void setSupplier(java.util.Collection<Supplier> newSupplier) {
      removeAllSupplier();
      for (java.util.Iterator iter = newSupplier.iterator(); iter.hasNext();)
         addSupplier((Supplier)iter.next());
   }
   
   public void addSupplier(Supplier newSupplier) {
      if (newSupplier == null)
         return;
      if (this.supplier == null)
         this.supplier = new java.util.HashSet<Supplier>();
      if (!this.supplier.contains(newSupplier))
         this.supplier.add(newSupplier);
   }
   
   public void removeSupplier(Supplier oldSupplier) {
      if (oldSupplier == null)
         return;
      if (this.supplier != null)
         if (this.supplier.contains(oldSupplier))
            this.supplier.remove(oldSupplier);
   }
   
   public void removeAllSupplier() {
      if (supplier != null)
         supplier.clear();
   }
   public java.util.Collection<Status> getStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status;
   }
   
   public java.util.Iterator getIteratorStatus() {
      if (status == null)
         status = new java.util.HashSet<Status>();
      return status.iterator();
   }
   
   public void setStatus(java.util.Collection<Status> newStatus) {
      removeAllStatus();
      for (java.util.Iterator iter = newStatus.iterator(); iter.hasNext();)
         addStatus((Status)iter.next());
   }
   
   public void addStatus(Status newStatus) {
      if (newStatus == null)
         return;
      if (this.status == null)
         this.status = new java.util.HashSet<Status>();
      if (!this.status.contains(newStatus))
         this.status.add(newStatus);
   }
   
   public void removeStatus(Status oldStatus) {
      if (oldStatus == null)
         return;
      if (this.status != null)
         if (this.status.contains(oldStatus))
            this.status.remove(oldStatus);
   }
   
   public void removeAllStatus() {
      if (status != null)
         status.clear();
   }
}