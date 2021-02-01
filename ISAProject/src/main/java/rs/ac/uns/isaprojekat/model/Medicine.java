package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Medicine {
   private Long medicineId;
   private String name;
   private String type;
   private String manufacturer;
   private String precautions;
   private int loyaltyPoints;
   
   public MedicineSpecification medicineSpecification;
   public java.util.Collection<Medicine> replacementMedicine;
   public MedicineForm medicineForm;
   public PrescriptionType prescriptionType;
   
   

public Medicine(Long medicineId, String name, String type, String manufacturer, String precautions, int loyaltyPoints,
		MedicineSpecification medicineSpecification, Collection<Medicine> replacementMedicine,
		MedicineForm medicineForm, PrescriptionType prescriptionType) {
	super();
	this.medicineId = medicineId;
	this.name = name;
	this.type = type;
	this.manufacturer = manufacturer;
	this.precautions = precautions;
	this.loyaltyPoints = loyaltyPoints;
	this.medicineSpecification = medicineSpecification;
	this.replacementMedicine = replacementMedicine;
	this.medicineForm = medicineForm;
	this.prescriptionType = prescriptionType;
}

public Long getMedicineId() {
	return medicineId;
}

public void setMedicineId(Long medicineId) {
	this.medicineId = medicineId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getManufacturer() {
	return manufacturer;
}

public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}

public String getPrecautions() {
	return precautions;
}

public void setPrecautions(String precautions) {
	this.precautions = precautions;
}

public int getLoyaltyPoints() {
	return loyaltyPoints;
}

public void setLoyaltyPoints(int loyaltyPoints) {
	this.loyaltyPoints = loyaltyPoints;
}

public MedicineSpecification getMedicineSpecification() {
	return medicineSpecification;
}

public void setMedicineSpecification(MedicineSpecification medicineSpecification) {
	this.medicineSpecification = medicineSpecification;
}

public java.util.Collection<Medicine> getReplacementMedicine() {
	return replacementMedicine;
}

public void setReplacementMedicine(java.util.Collection<Medicine> replacementMedicine) {
	this.replacementMedicine = replacementMedicine;
}

public MedicineForm getMedicineForm() {
	return medicineForm;
}

public void setMedicineForm(MedicineForm medicineForm) {
	this.medicineForm = medicineForm;
}

public PrescriptionType getPrescriptionType() {
	return prescriptionType;
}

public void setPrescriptionType(PrescriptionType prescriptionType) {
	this.prescriptionType = prescriptionType;
}

}