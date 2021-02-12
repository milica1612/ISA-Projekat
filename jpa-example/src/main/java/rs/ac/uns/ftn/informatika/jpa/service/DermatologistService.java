package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IDermatologistService;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IDermatologistRepository;

@Service
public class DermatologistService implements IDermatologistService{
	@Autowired
	private IDermatologistRepository _dermatologistRepository;
	
	@Override
	public List<DermatologistDTO> getAllDermatologist() {
		List<Dermatologist> dermatologists = _dermatologistRepository.findAll();
		List<DermatologistDTO> dermatologistDTOs = new ArrayList<DermatologistDTO>();
		
		for (Dermatologist d : dermatologists) {
			DermatologistDTO dermatologistDTO = new DermatologistDTO();
			dermatologistDTO.setFirstName(d.getFirstName());
			dermatologistDTO.setLastName(d.getLastName());
			List<String> pharmacyNames = new ArrayList<String>();
			for (Pharmacy p : d.getPharmacy()) {
				pharmacyNames.add(p.getName());
			}
			dermatologistDTO.setPharmacyName(pharmacyNames);
			dermatologistDTO.setRaiting(d.getRating());
			dermatologistDTOs.add(dermatologistDTO);
		}
		
		return dermatologistDTOs;
	}

	@Override
	public List<DermatologistDTO> searchDermatologist(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DermatologistDTO> searchDermatologistsByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DermatologistDTO> searchDermatologistsByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DermatologistDTO> filterDermatologistByRaiting(Double minRaiting, Double maxRaiting) {
		// TODO Auto-generated method stub
		return null;
	}

}
