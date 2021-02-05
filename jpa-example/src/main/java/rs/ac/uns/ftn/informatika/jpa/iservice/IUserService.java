package rs.ac.uns.ftn.informatika.jpa.iservice;


import org.omg.CORBA.UserException;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.User;

@Service
public interface IUserService {

	User findById(Long id);

	User save(User user);
}
