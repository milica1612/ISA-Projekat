package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyRegisterDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyService {

	Pharmacy findById(Long id);

	Pharmacy save(Pharmacy pharmacy);
	
	PharmacyDTO getPharmacyById(Long pharmacyId);
	
	ArrayList<Pharmacy> findAllPharmacy();
	
	ArrayList<Pharmacy> getPharmacyByNameOrAddress(String parametar);

    ArrayList<Pharmacy> filtratePharmaciesByRating(Long rating);
    
	List<PharmacyRegisterDTO> getSubscribedPharmacyForPatient(Long patient_id);
	
}
