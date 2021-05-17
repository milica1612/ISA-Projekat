package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import rs.ac.uns.ftn.informatika.jpa.model.Offer;

public class OfferDTO {

	private Long id;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDeadline;
	
	private Double price;

	public OfferDTO(Offer offer) {
		this.id = offer.getOfferId();
		this.deliveryDeadline = offer.getDeliveryDeadline();
		this.price = offer.getPrice();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
	
}
