package rs.ac.uns.ftn.informatika.jpa.iservice;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyRegisterDTO;
import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyService {

	Pharmacy findById(Long id);

	Pharmacy save(Pharmacy pharmacy);
	
	PharmacyRegisterDTO getPharmacyById(Long pharmacyId);
	
	ArrayList<Pharmacy> findAllPharmacy();
	
	ArrayList<Pharmacy> getPharmacyByNameOrAddress(String parametar);

    ArrayList<Pharmacy> filtratePharmaciesByRating(Long rating);
}
