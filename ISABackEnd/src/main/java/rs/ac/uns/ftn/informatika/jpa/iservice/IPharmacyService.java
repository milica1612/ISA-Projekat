package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyService {

	Pharmacy findById(Long id);

	Pharmacy save(Pharmacy pharmacy);
	
	PharmacyDTO getPharmacyById(Long pharmacyId);
	
	ArrayList<Pharmacy> findAllPharmacy();
	
	ArrayList<Pharmacy> getPharmacyByNameOrAddress(String parametar);

	void updateRating(Long pharmacyId, Double newRating);

	ArrayList<Pharmacy> getAllByDermatologist(Long id);
	
	ArrayList<Pharmacy> filtratePharmaciesByRating(Long rating, ArrayList<Pharmacy> phamacies);
}
