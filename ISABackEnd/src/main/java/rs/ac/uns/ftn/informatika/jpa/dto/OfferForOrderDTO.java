package rs.ac.uns.ftn.informatika.jpa.dto;

public class OfferForOrderDTO {
	
	private Long offerId;
	private String supplierName;
	private String supplierEmail;
	private Double offerPrice;
	private String deliveryDeadline;
	private Long adminId;
	
	public OfferForOrderDTO() {
		// TODO Auto-generated constructor stub
	}
		
	
	public OfferForOrderDTO(Long offerId, String supplierName, String supplierEmail, Double offerPrice,
			String deliveryDeadline, Long adminId) {
		super();
		this.offerId = offerId;
		this.supplierName = supplierName;
		this.supplierEmail = supplierEmail;
		this.offerPrice = offerPrice;
		this.deliveryDeadline = deliveryDeadline;
		this.adminId = adminId;
	}


	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public String getDeliveryDeadline() {
		return deliveryDeadline;
	}

	public void setDeliveryDeadline(String deliveryDeadline) {
		this.deliveryDeadline = deliveryDeadline;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
	
	
}
