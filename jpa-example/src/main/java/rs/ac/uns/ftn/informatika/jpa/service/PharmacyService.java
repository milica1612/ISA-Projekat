package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}