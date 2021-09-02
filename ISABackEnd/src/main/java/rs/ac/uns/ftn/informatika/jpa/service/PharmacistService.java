package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyPharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacistService;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.User;
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
	public List<PharmacistDTO> filterPharmacistByRating(Double minRating, Double maxRating) {
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
		
		for (Pharmacist p : pharmacists)
			if (p.getRating() >= minRating && p.getRating() <= maxRating)
				pharmacistDTOs.add(new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	
	}

	@Override
	public void updateRating(Long userId, Double newRating) {
		Pharmacist existing = _pharmacistRepository.findById(userId).orElse(null);
		if(existing!= null) {
			existing.setRating(newRating);
			_pharmacistRepository.save(existing);
		}
		
		
	}

	@Override
	public List<PharmacyPharmacistDTO> getPharmacistsByPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacyPharmacistDTO> pharmacistDTOs = new ArrayList<PharmacyPharmacistDTO>();
	
		for (Pharmacist p : pharmacists)
			if (p.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId())
				pharmacistDTOs.add(new PharmacyPharmacistDTO(p.getUserId(), p.getFirstName(), p.getLastName(), p.getPhoneNumber(), p.getEmail(), p.getAddress().getStreet(), p.getAddress().getStreetNumber(), p.getAddress().getCity(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	}

}
