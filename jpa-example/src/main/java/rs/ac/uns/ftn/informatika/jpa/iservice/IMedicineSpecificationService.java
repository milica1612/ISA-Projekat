package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.Set;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;

@Service
public interface IMedicineSpecificationService {

	public MedicineSpecification findById(Long id);
	
	public MedicineSpecification save(MedicineSpecification medicineSpecification);

	public Set<Contraindication> addContrInMedSpec(Contraindication contraindication, Long id);
	
}
