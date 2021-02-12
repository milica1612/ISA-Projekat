package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistRepository extends JpaRepository<Pharmacist, Long>{
	
	List<Pharmacist> findAllByFirstNameAndLastName(String firstName, String lastName);
	
	List<Pharmacist> findAllByFirstName(String firstName);
	
	List<Pharmacist> findAllByLastName(String lastName);
	
}
