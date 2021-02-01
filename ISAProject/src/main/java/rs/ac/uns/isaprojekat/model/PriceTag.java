package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class PriceTag {
   private Double price;
   public TimeInterval timeInterval;
   
   public PriceTag(Double price, TimeInterval timeInterval) {
		super();
		this.price = price;
		this.timeInterval = timeInterval;
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