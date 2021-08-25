package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MedicineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineItemId;
	
	@Column(name = "quantity", nullable = false)
    private int quantity;
   
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Medicine medicine;
  
    public MedicineItem(int quantity, Medicine medicine) {
		super();
		this.quantity = quantity;
		this.medicine = medicine;
    }
    public MedicineItem()
    {
    	
    }
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Medicine getMedicine() {
		return medicine;
	}
	
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

}