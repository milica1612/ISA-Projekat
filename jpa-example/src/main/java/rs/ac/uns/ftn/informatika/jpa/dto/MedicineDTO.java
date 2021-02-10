package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

public class MedicineDTO {
	
	private String name;
	private String type;
	private String medicineCode;
	
	private Double dosage;
	private String contraindications;
	private String ingridients;
	private String manufacturer;
	private Set<MedicineDTO> replacementMedicine;
	private String precautions;
	
	private int loyaltyPoint;
	

	public MedicineDTO(String name, String type, String medicineCode, Double dosage, String contraindications,
			String ingridients, int loyaltyPoint, String manufacturer, String precautions) {
		super();
		this.name = name;
		this.type = type;
		this.medicineCode = medicineCode;
		this.dosage = dosage;
		this.contraindications = contraindications;
		this.ingridients = ingridients;
		this.replacementMedicine = new HashSet<>();
		this.loyaltyPoint = loyaltyPoint;
		this.manufacturer = manufacturer;
		this.precautions = precautions;
	}

	
	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedicineType() {
		return type;
	}

	public void setMedicineType(String medicineType) {
		this.type = medicineType;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public String getContraindications() {
		return contraindications;
	}

	public void setContraindications(String contraindications) {
		this.contraindications = contraindications;
	}

	public String getIngridients() {
		return ingridients;
	}

	public void setIngridients(String ingridients) {
		this.ingridients = ingridients;
	}


	public Set<MedicineDTO> getReplacementMedicine() {
		return replacementMedicine;
	}


	public void setReplacementMedicine(Set<MedicineDTO> replacementMedicine) {
		this.replacementMedicine = replacementMedicine;
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
	
}
