package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import rs.ac.uns.ftn.informatika.jpa.model.Offer;

public class OfferDTO {

	private Double finalPrice;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDeadline;
	    
    private Boolean isApproved;

    public OfferDTO(Offer offer) {
    	this.finalPrice = offer.getPrice();
    	this.deliveryDeadline = offer.getDeliveryDeadline();
    }
    
	public OfferDTO(Double finalPrice, Date deliveryDeadline, Boolean isApproved) {
		super();
		this.finalPrice = finalPrice;
		this.deliveryDeadline = deliveryDeadline;
		this.isApproved = isApproved;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Date getDeliveryDeadline() {
		return deliveryDeadline;
	}

	public void setDeliveryDeadline(Date deliveryDeadline) {
		this.deliveryDeadline = deliveryDeadline;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
    
    

}
