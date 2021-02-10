package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineSpecificationService;

@RestController
@RequestMapping(value = "/specification")
public class MedicineSpecificationController {

	@Autowired
	private MedicineSpecificationService _specificationService;
	
	@GetMapping(value = "/{id}")
	private MedicineSpecification findById(@PathVariable Long id) {
		return _specificationService.findById(id);
	}
	
	@PutMapping("/{id}/add")
	public Set<Contraindication> addContrToMedSpec(@PathVariable Long id, @RequestBody Contraindication contraindication) {
		return _specificationService.addContrInMedSpec(contraindication, id);
	}

}
