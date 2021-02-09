package rs.ac.uns.ftn.informatika.jpa.dto;

public class MedicineDTO {
	
	private String name;
	private String medicineType;
	private String medicineCode;
	
	public MedicineDTO(String name, String medicineType, String medicineCode) {
		super();
		this.name = name;
		this.medicineType = medicineType;
		this.medicineCode = medicineCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}
}
