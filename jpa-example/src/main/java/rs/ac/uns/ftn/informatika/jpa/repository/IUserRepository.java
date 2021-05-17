package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	List<User> findUserByUserType(UserType user_type);

	User findByUsername(String username);
}
