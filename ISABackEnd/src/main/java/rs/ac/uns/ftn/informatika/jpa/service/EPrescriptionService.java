package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IEPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescriptionStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IEPrescriptionRepository;

@Service
public class EPrescriptionService implements IEPrescriptionService {

	@Autowired
	private IEPrescriptionRepository _ePrescriptionRepository;

	@Override
	public void getPharmaciesForPatient(Long patientId, ArrayList<Pharmacy> result) {
		ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId) {
				if(!result.contains(ePrescription.getPharmacy())) {
					result.add(ePrescription.getPharmacy());
				}
			}
		}
		
	}

	@Override
	public void getMedicineForRating(Long patientId, ArrayList<Medicine> result) {
		ArrayList<Medicine> med = getIssuedMedicine(patientId);
		for (Medicine medicine : med) {
			if(!result.contains(medicine)) {
				result.add(medicine);
			}
		}
	}

	@Override
	public ArrayList<EPrescriptionDTO> getByPatient(Long patientId) {
		ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		ArrayList<EPrescriptionDTO> result = new ArrayList<EPrescriptionDTO>();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId) {
				result.add(new EPrescriptionDTO(ePrescription.getDate().toString(), ePrescription.getPharmacy(), ePrescription.getStatus()));
			}
		}
		return result;
	}

	@Override
	public ArrayList<EPrescriptionDTO> filtrate(String status, Long patientId) {
		ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		ArrayList<EPrescriptionDTO> result = new ArrayList<EPrescriptionDTO>();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId && ePrescription.getStatus().toString().equals(status)) {
				result.add(new EPrescriptionDTO(ePrescription.getDate().toString(), ePrescription.getPharmacy(), ePrescription.getStatus()));
			}
		}
		return result;
	}

	@Override
	public ArrayList<Medicine> getIssuedMedicine(Long patientId) {
		ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		ArrayList<Medicine> result = new ArrayList<Medicine>();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId && ePrescription.getStatus().equals(EPrescriptionStatus.PROCESSED)) {
				result.addAll(ePrescription.getMedicine());
			}
		}
		return result;
	}
		
}
