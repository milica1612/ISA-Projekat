package rs.ac.uns.ftn.informatika.jpa.dto;

import rs.ac.uns.ftn.informatika.jpa.model.MedicineForm;
import rs.ac.uns.ftn.informatika.jpa.model.PrescriptionType;

public class MedicineItemDTO {
	
	private String name;
	private String medicineCode;
	private String type;
	private String manufacturer;
	private MedicineForm medicineForm;
	private PrescriptionType prescriptionType;
	private int quantity;
	
	public MedicineItemDTO() {
	
	}
	
	public MedicineItemDTO(String name, String medicineCode, String type, String manufacturer, MedicineForm medicineForm,
			PrescriptionType prescriptionType, int quantity) {
		super();
		this.name = name;
		this.medicineCode = medicineCode;
		this.type = type;
		this.manufacturer = manufacturer;
		this.medicineForm = medicineForm;
		this.prescriptionType = prescriptionType;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
