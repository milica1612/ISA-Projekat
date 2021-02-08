package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.User;

@Service
public interface IUserService {

	User findById(Long id);

	void update(User user);

	User save(User user);
	
	User findByEmail(String email);
	}
