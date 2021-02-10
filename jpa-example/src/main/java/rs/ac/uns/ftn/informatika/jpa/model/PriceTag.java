package rs.ac.uns.ftn.informatika.jpa.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class PriceTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceTagId;

	@Column(name = "price", nullable = false)
	private Double price;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)    
	public TimeInterval timeInterval;
   
   public PriceTag(Double price, TimeInterval timeInterval) {
		super();
		this.price = price;
		this.timeInterval = timeInterval;
   	}
   
   public PriceTag()
   {
	   
   }

	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public TimeInterval getTimeInterval() {
		return timeInterval;
	}
	
	public void setTimeInterval(TimeInterval timeInterval) {
		this.timeInterval = timeInterval;
	}

}