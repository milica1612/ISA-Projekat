package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IUserService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository _userRepository;
	
	@Autowired
	private AuthorityService _authorityService;

	@Autowired
	private PasswordEncoder _passwordEncoder;
	
	
	@Override
	public User findById(Long id) {
		
		return _userRepository.findById(id).orElse(null);
	}
	
	@Override
	public User save(RegistrationRequest request) {
		User u = new User();
		Address address = new Address();
		address.setStreet(request.getStreet());
		address.setStreetNumber(request.getStreetNumber());
		address.setCity(request.getCity());
		address.setCountry(request.getCountry());
		address.setLatitude(null);
		address.setLongitude(null);
		u.setEmail(request.getEmail());
		u.setPassword(_passwordEncoder.encode(request.getPassword()));
		u.setFirstName(request.getFirstName());
		u.setLastName(request.getLastName());
		u.setUserName(request.getUsername());
		u.setPhoneNumber(request.getPhoneNumber());
		u.setAddress(address);
		
		u.setEnabled(true);
		
		List<Authority> auth = _authorityService.findByName("ROLE_PATIENT");
		u.setAuthorities(auth);
		
		this._userRepository.save(u);
		return u;
	}
	
	
	
	@Override
	public void update(@Valid User user) {
		User existing = _userRepository.findById(user.getUserId()).orElse(null);
		
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setAddress(user.getAddress());
		existing.setPassword(user.getPassword());
		existing.setPhoneNumber(user.getPhoneNumber());

		_userRepository.save(existing);
		
	}

	@Override
	public User findByEmail(String email) {
		List<User> users = _userRepository.findAll();
		User user = new User();
		
		if(users == null) {
			return null;
		}

		for (User u : users) {
			if(u.getEmail().equals(email)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	@Override
	public User findByEmailAndPassword(String email, String password) {

		List<User> users = _userRepository.findAll();
		User user = new User();
		
		if(users == null) {
			return null;
		}

		for (User u : users) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
        List<User> users = _userRepository.findAll();
        List<User> usersList = new ArrayList<>();
        for (User u : users) {
			if(u.getUserType() == UserType.ROLE_PATIENT)
				usersList.add(u);
        }
        List<UserDTO> dtos = new ArrayList<>();
        usersList.stream().forEach(user -> dtos.add(new UserDTO(user.getFirstName(), user.getLastName())));      
        return dtos;
	}
	
	@Override
	public ArrayList<UserDTO> userSearch(UserDTO userDTO) {
        ArrayList<UserDTO> users = new ArrayList<>();
        for (UserDTO user : getAllUsers()) {
            if (user.getFirstName().equals(userDTO.getFirstName()) && user.getLastName().equals(userDTO.getLastName()))
            		users.add(user);
        }
        return users;
    }

	@Override
	public List<UserDTO> findUserByUserType(UserType userType)
	{
		return _userRepository.findUserByUserType(userType).stream()
				.map(u -> new UserDTO(u.getFirstName(), u.getLastName())).collect(Collectors.toList());
	}

	
}
