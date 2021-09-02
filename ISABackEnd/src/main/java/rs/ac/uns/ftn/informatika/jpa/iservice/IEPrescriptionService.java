package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IEPrescriptionService {

	void getPharmaciesForPatient(Long patientId, ArrayList<Pharmacy> result);

	void getMedicineForRating(Long patientId, ArrayList<Medicine> result);

	ArrayList<EPrescriptionDTO> getByPatient(Long patientId);

	ArrayList<EPrescriptionDTO> filtrate(String status, Long patientId);

	ArrayList<Medicine> getIssuedMedicine(Long patientId);

}
