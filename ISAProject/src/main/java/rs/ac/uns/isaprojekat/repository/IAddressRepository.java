package rs.ac.uns.isaprojekat.repository;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.isaprojekat.model.Address;



public interface IAddressRepository extends JpaRepository<Address, Long> {

	Page<Address> findAll(Pageable pageable);
	
}
