package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyRegisterDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacyService;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class PharmacyService implements IPharmacyService {

	@Autowired
	private IPharmacyRepository _pharmacyRepository;

	@Override
	public Pharmacy findById(Long id) {
		return _pharmacyRepository.findById(id).orElse(null);
	}

	@Override
	public Pharmacy save(Pharmacy pharmacy) {
		return _pharmacyRepository.save(pharmacy);
	}

	@Override
	public PharmacyDTO getPharmacyById(Long pharmacyId) {		
		Pharmacy p = _pharmacyRepository.findById(pharmacyId).orElse(null);
		
		PharmacyDTO result = new PharmacyDTO(p.getName(), p.getAddress().getStreet(), p.getAddress().getStreetNumber(), p.getAddress().getCity(), p.getAddress().getCountry(), p.getAddress().getLongitude(), p.getAddress().getLatitude(), p.getRating(), p.getDescription());
		
		return result;
	}

	public ArrayList<Pharmacy> findAllPharmacy() {
		return (ArrayList<Pharmacy>) _pharmacyRepository.findAll();
	}

	@Override
	public ArrayList<Pharmacy> getPharmacyByNameOrAddress(String parametar) {
		ArrayList<Pharmacy> result = getPharmacyByName(parametar);
		if(!result.isEmpty()) {
			return result;
		}
		result = getPharmacyByAddress(parametar);
		
		return result;
	}
	
	public ArrayList<Pharmacy> getPharmacyByName(String name){
		if(name.trim().equals("")) {
			return findAllPharmacy();
		}
		ArrayList<Pharmacy> pharmacies = findAllPharmacy();
		ArrayList<Pharmacy> result = new ArrayList<Pharmacy>();
		for (Pharmacy pharmacy : pharmacies) {
			if(pharmacy.getName().toLowerCase().contains(name.toLowerCase().trim())) {
				result.add(pharmacy);
			}
		}
		return result;
	}
	
	public ArrayList<Pharmacy> getPharmacyByAddress(String address){
		ArrayList<Pharmacy> pharmacies = findAllPharmacy();
		ArrayList<Pharmacy> result = new ArrayList<Pharmacy>();
		String city = address.trim();
		for (Pharmacy pharmacy : pharmacies) {
			if(pharmacy.getAddress().getCity().toLowerCase().contains(city.toLowerCase().trim())) {
				result.add(pharmacy);
			}
		}		
		return result;
	}

	@Override
	public ArrayList<Pharmacy> filtratePharmaciesByRating(Long rating) {
		ArrayList<Pharmacy> pharmacies = findAllPharmacy();
		ArrayList<Pharmacy> result = new ArrayList<Pharmacy>();
		for (Pharmacy pharmacy : pharmacies) {
			if(pharmacy.getRating() >= rating) 
				result.add(pharmacy);
		}
		return result;
	}
	
}
