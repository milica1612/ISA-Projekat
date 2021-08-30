package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.List;

public class CreateOrderDTO {
	
	private List<MedicineData> medicineData;
	
	public CreateOrderDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CreateOrderDTO(List<MedicineData> medicineData) {
		super();
		this.medicineData = medicineData;
	}

	public List<MedicineData> getMedicineData() {
		return medicineData;
	}

	public void setMedicineData(List<MedicineData> medicineData) {
		this.medicineData = medicineData;
	}

}
