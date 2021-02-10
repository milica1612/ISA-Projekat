package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

public interface IPharmacistRepository extends JpaRepository<Pharmacist, Long>{
	
	List<Pharmacist> findAllByFirstNameAndLastName(String firstName, String lastName);
}
