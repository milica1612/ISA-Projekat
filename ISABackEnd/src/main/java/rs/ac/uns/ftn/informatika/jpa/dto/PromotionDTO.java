package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.Date;

public class PromotionDTO {
	
	private String caption;
	private String content;
	private Date startOfPromotion;
	private Date endOfPromotion;
	private Long pharmacyId;
	
	public PromotionDTO() {
		
	}
	
	public PromotionDTO(String caption, String content, Date startOfPromotion, Date endOfPromotion, Long pharmacyId) {
		super();
		this.caption = caption;
		this.content = content;
		this.startOfPromotion = startOfPromotion;
		this.endOfPromotion = endOfPromotion;
		this.pharmacyId = pharmacyId;
	}
	
	
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartOfPromotion() {
		return startOfPromotion;
	}

	public void setStartOfPromotion(Date startOfPromotion) {
		this.startOfPromotion = startOfPromotion;
	}

	public Date getEndOfPromotion() {
		return endOfPromotion;
	}

	public void setEndOfPromotion(Date endOfPromotion) {
		this.endOfPromotion = endOfPromotion;
	}

	public Long getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}	
}
