package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionBuyMedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineAvailableInPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.QRCodeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;

public interface IEPrescriptionService {

	void getPharmaciesForPatient(Long patientId, ArrayList<Pharmacy> result);

	void getMedicineForRating(Long patientId, ArrayList<Medicine> result);

	EPrescription findByCode(String code);

	ArrayList<QRCodeDTO> getQRCodeMedicine(String decodedText);
	
	ArrayList<MedicineAvailableInPharmacyDTO> getPharmacies(ArrayList<QRCodeDTO> qrCodeDTOs);
	
	String getCodeForEPrescription(String decodedText);
	
	ArrayList<MedicineAvailableInPharmacyDTO> checkAvailabilityMedicineInPharmacies(ArrayList<QRCodeDTO> qrCodeDTOs);
	
	EPrescription saveEPrescription(EPrescriptionBuyMedicineDTO ePrescription, Pharmacy pharmacy, Patient patient);
}
