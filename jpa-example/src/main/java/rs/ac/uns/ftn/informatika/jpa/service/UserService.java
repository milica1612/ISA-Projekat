package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IUserService;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User findById(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}
	

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void update(@Valid User user) {
		User existing = userRepository.findById(user.getUserId()).orElse(null);
		
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setAddress(user.getAddress());
		existing.setPassword(user.getPassword());
		existing.setPhoneNumber(user.getPhoneNumber());

		userRepository.save(existing);
		
	}


	@Override
	public User findByEmail(String email) {
		List<User> users = userRepository.findAll();
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

		List<User> users = userRepository.findAll();
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
}
