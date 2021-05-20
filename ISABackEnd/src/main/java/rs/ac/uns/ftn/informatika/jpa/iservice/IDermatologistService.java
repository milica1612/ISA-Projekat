package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;

public interface IDermatologistService {
	
	List<DermatologistDTO> getAllDermatologist();

	List<DermatologistDTO> searchDermatologist(String firstName, String lastName);
	
	List<DermatologistDTO> searchDermatologistsByFirstName(String firstName);
	
	List<DermatologistDTO> searchDermatologistsByLastName(String lastName);
	
	List<DermatologistDTO> filterDermatologistByRaiting(Double minRaiting, Double maxRaiting);
}
