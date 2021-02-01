package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class MedicineItem {
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