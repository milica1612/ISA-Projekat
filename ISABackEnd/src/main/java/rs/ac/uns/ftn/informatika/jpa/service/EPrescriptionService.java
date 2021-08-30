package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IEPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
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
		/*ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId) {
				if(!result.contains(ePrescription.getMedicine())) {
					result.add(ePrescription.getMedicine());
				}
			}
		}*/
	}
		
}
