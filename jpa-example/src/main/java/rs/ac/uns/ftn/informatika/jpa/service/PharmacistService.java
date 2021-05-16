package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacistService;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacistRepository;

@Service
public class PharmacistService implements IPharmacistService{

	@Autowired
	private IPharmacistRepository _pharmacistRepository;

	@Override
	public List<PharmacistDTO> getAllPharmacist() {
		return _pharmacistRepository.findAll().stream()
				.map(p-> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<PharmacistDTO> searchPharmacistsByFirstName(String firstName) {
		return _pharmacistRepository.findAllByFirstName(firstName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<PharmacistDTO> searchPharmacistsByLastName(String lastName) {
		return _pharmacistRepository.findAllByLastName(lastName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public List<PharmacistDTO> searchPharmacist(String firstName, String lastName) {
		return _pharmacistRepository.findAllByFirstNameAndLastName(firstName, lastName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<PharmacistDTO> findPharmacistsByPharmacy(Long pharmacyId) {
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
	
		for (Pharmacist p : pharmacists)
			if (p.getPharmacy().getPharmacyId() == pharmacyId)
				pharmacistDTOs.add(new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	}
	
	@Override
	public List<PharmacistDTO> filterPharmacistByRaiting(Double minRaiting, Double maxRaiting) {
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
		
		for (Pharmacist p : pharmacists)
			if (p.getRating() >= minRaiting && p.getRating() <= maxRaiting)
				pharmacistDTOs.add(new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	}

}
