package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacistService;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacistRepository;

@Service
public class PharmacistService implements IPharmacistService{

	@Autowired
	private IPharmacistRepository _pharmacistRepository;

	@Override
	public List<PharmacistDTO> getAllPharmacists() {
		return _pharmacistRepository.findAll().stream()
				.map(p-> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}


	@Override
	public List<PharmacistDTO> searchPharmacist(String firstName, String lastName) {
		return _pharmacistRepository.findAllByFirstNameAndLastName(firstName, lastName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}

}
