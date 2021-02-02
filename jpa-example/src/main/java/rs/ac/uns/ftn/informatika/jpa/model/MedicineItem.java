package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class MedicineItem {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineItemId;
	
	//@Column(name = "quantity", nullable = false)
    private int quantity;
   
    public Medicine medicine;
  
    public MedicineItem(int quantity, Medicine medicine) {
		super();
		this.quantity = quantity;
		this.medicine = medicine;
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