package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.ArrayList;

public class EPrescriptionBuyMedicineDTO {
	
	private String code;
	private ArrayList<QRCodeDTO> qrCodeDTOs;
	private Long pharmacyId;
	
	public EPrescriptionBuyMedicineDTO() {}
	
	public EPrescriptionBuyMedicineDTO(String code, ArrayList<QRCodeDTO> qrCodeDTOs, Long pharmacyId) {
		super();
		this.code = code;
		this.qrCodeDTOs = qrCodeDTOs;
		this.pharmacyId = pharmacyId;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<QRCodeDTO> getQrCodeDTOs() {
		return qrCodeDTOs;
	}
	public void setQrCodeDTOs(ArrayList<QRCodeDTO> qrCodeDTOs) {
		this.qrCodeDTOs = qrCodeDTOs;
	}
	public Long getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(Long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	
	

}
