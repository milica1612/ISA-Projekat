package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Offer {
   private Date deliveryDeadline;
   private Double price;
   private Long offerId;
   public Supplier supplier;
   public Order order;
   public Status status;
   
   

public Offer(Date deliveryDeadline, Double price, Long offerId, Supplier supplier, Order order, Status status) {
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

public Supplier getSupplier() {
	return supplier;
}

public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}
}