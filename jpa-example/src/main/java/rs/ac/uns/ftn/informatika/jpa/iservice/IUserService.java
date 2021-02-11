package rs.ac.uns.ftn.informatika.jpa.iservice;


import java.util.List;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;

@Service
public interface IUserService {

	User findById(Long id);

	void update(User user);

	User save(User user);
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);

	List<UserDTO> getAllUsers();
	
	List<UserDTO> userSearch(UserDTO userDTO);
	
	List<UserDTO> findUserByUserType(UserType userType);
}
