package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;


@Entity
public class SaleAndPromotion {
   
	private Long saleId;
	public Pharmacy pharmacy;
   
    public SaleAndPromotion(Pharmacy pharmacy) {
		super();
		this.pharmacy = pharmacy;
	}

    public Pharmacy getPharmacy() {
	    return pharmacy;
    }
	
    public void setPharmacy(Pharmacy pharmacy) {
	    this.pharmacy = pharmacy;
    }

}