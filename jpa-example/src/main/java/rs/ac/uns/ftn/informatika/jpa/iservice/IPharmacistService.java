package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;

public interface IPharmacistService {
	
    List<PharmacistDTO> getAllPharmacist();
	
    List<PharmacistDTO> searchPharmacist(String firstName, String lastName);

	List<PharmacistDTO> findPharmacistsByPharmacy(Long pharmacyId);

	List<PharmacistDTO> searchPharmacistsByLastName(String lastName);

	List<PharmacistDTO> searchPharmacistsByFirstName(String firstName);
}
