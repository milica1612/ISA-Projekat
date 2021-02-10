package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;

public interface IPharmacistService {
	
    List<PharmacistDTO> getAllPharmacists();
	
    List<PharmacistDTO> searchPharmacist(String firstName, String lastName);
}
