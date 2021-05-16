package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
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
		
		PharmacyDTO result = new PharmacyDTO(p.getName(), p.getAdress().getStreet(), p.getAdress().getStreetNumber(), p.getAdress().getCity(), p.getAdress().getCountry(), p.getAdress().getLongitude(), p.getAdress().getLatitude(), p.getRating(), p.getDescription());
		
		return result;
	}

	public ArrayList<Pharmacy> findAllPharmacy() {
		// TODO Auto-generated method stub
		return (ArrayList<Pharmacy>) _pharmacyRepository.findAll();
	}
}
