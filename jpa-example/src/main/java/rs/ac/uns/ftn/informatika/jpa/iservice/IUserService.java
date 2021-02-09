package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.model.User;

@Service
public interface IUserService {

	User findById(Long id);

	void update(User user);

	User save(User user);
	
	List<PharmacistDTO> getAllPharmacists();
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);
	
}
