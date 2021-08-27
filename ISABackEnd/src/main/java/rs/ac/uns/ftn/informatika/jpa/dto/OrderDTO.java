package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.OrderStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Status;

public class OrderDTO {
	
	private Long orderId;
	private String offerDeadline;
	private String adminName;
	private OrderStatus orderStatus;
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(Long orderId, String offerDeadline, String adminName, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.offerDeadline = offerDeadline;
		this.adminName = adminName;
		this.orderStatus = orderStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOfferDeadline() {
		return offerDeadline;
	}

	public void setOfferDeadline(String offerDeadline) {
		this.offerDeadline = offerDeadline;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
