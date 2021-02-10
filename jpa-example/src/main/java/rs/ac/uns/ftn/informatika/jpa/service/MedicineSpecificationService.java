package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineSpecificationService;
import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineSpecificationRepository;

@Service
public class MedicineSpecificationService implements IMedicineSpecificationService {

	@Autowired
	private IMedicineSpecificationRepository _medicineSpecRepository;
	
	@Override	
	public MedicineSpecification findById(Long id) {
		return _medicineSpecRepository.findById(id).orElse(null);
	}

	@Override
	public MedicineSpecification save(MedicineSpecification medicineSpecification) {
		return _medicineSpecRepository.save(medicineSpecification);
	}
	
	
	@Override
	public Set<Contraindication> addContrInMedSpec(Contraindication contraindication, Long id) {
		MedicineSpecification medSpec = _medicineSpecRepository.findById(id).orElse(null);
		medSpec.addContraindication(contraindication);
		_medicineSpecRepository.save(medSpec);
		return medSpec.getContraindication();
	}
	
}
