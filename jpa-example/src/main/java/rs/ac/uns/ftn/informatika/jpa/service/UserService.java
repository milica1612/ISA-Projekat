package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IUserService;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
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
	public List<PharmacistDTO> getAllPharmacists() {
		List<User> users = userRepository.findAll();
		List<Pharmacist> pharmacists = new ArrayList<>();
		List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
		
		for (User u : users) 
			if(u.getUserType() == UserType.PHARMACIST)
				pharmacists.add((Pharmacist)u);
		
		pharmacists.stream().forEach(p -> pharmacistDTOs.add(new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName())));
		
		return pharmacistDTOs;
	}
}
