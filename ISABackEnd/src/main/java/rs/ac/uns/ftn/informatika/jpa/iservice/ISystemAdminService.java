package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;

public interface ISystemAdminService {

	User findById(Long id);

	User saveSystemAdmin(RegistrationRequest request);
	
	User findByEmail(String email);
	
	List<UserDTO> getAllUsers();
	
	Pharmacy createPharmacy(PharmacyDTO pharmacy);
	
	User savePharmacyAdmin(RegistrationRequest request);
	
	User saveDermatologist(RegistrationRequest request);
	
	User saveSupplier(RegistrationRequest request);
		
}
