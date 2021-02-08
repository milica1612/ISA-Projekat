package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.User;

@Service
public interface IUserService {

	User findById(Long id);

	User save(User user);

	List<User> getAllPharmacists();
}
