package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.ArrayList;

public class EPrescriptionDTO {

	private ArrayList<QRCodeDTO> qrcodeDTO;
	private String code;
	private ArrayList<MedicineAvailableInPharmacyDTO> medicineAvailableInPharmacyDTO;
	
	public EPrescriptionDTO(ArrayList<QRCodeDTO> qrcodeDTO, String code,
			ArrayList<MedicineAvailableInPharmacyDTO> medicineAvailableInPharmacyDTO) {
		super();
		this.qrcodeDTO = qrcodeDTO;
		this.code = code;
		this.medicineAvailableInPharmacyDTO = medicineAvailableInPharmacyDTO;
	}

	public ArrayList<QRCodeDTO> getQrcodeDTO() {
		return qrcodeDTO;
	}

	public void setQrcodeDTO(ArrayList<QRCodeDTO> qrcodeDTO) {
		this.qrcodeDTO = qrcodeDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<MedicineAvailableInPharmacyDTO> getMedicineAvailableInPharmacyDTO() {
		return medicineAvailableInPharmacyDTO;
	}

	public void setMedicineAvailableInPharmacyDTO(
			ArrayList<MedicineAvailableInPharmacyDTO> medicineAvailableInPharmacyDTO) {
		this.medicineAvailableInPharmacyDTO = medicineAvailableInPharmacyDTO;
	}
}
