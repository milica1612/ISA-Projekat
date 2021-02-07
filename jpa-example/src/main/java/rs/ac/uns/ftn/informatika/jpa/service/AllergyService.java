package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.iservice.IAllergyService;
import rs.ac.uns.ftn.informatika.jpa.repository.IAllergyRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class AllergyService implements IAllergyService{
	
	@Autowired
	private IAllergyRepository _allergyRepository;

	@Override
	public Set<Medicine> addMedicineToAllergy(Medicine medicine, Long id) {
		Long p = (long) 1;
		Allergy allergy = _allergyRepository.findById(p).orElse(null);
		allergy.addMedicine(medicine);
        _allergyRepository.save(allergy);
		return allergy.getMedicine();
	}


}
