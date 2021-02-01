package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Order {
   private Date offerDeadline;
   private Long orderId;
   
   public OrderStatus orderStatus;
   public Pharmacy pharmacy;
   public PharmacyAdministrator pharmacyAdministrator;
   
public Order(Date offerDeadline, Long orderId, OrderStatus orderStatus, Pharmacy pharmacy,
		PharmacyAdministrator pharmacyAdministrator) {
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

public OrderStatus getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
}

public Pharmacy getPharmacy() {
	return pharmacy;
}

public void setPharmacy(Pharmacy pharmacy) {
	this.pharmacy = pharmacy;
}

public PharmacyAdministrator getPharmacyAdministrator() {
	return pharmacyAdministrator;
}

public void setPharmacyAdministrator(PharmacyAdministrator pharmacyAdministrator) {
	this.pharmacyAdministrator = pharmacyAdministrator;
}
  
}