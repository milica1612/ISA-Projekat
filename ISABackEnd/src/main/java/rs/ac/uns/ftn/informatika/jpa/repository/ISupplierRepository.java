package rs.ac.uns.ftn.informatika.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.jpa.model.Supplier;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Long>{

	
}
