package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.service.AllergyService;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/allergy")
public class AllergyController {
	@Autowired
	private AllergyService _allergyService ;
	
	@PutMapping("/{id}/add")
	public Set<Medicine> addMedicineToAllergy(@PathVariable Long id,@RequestBody Medicine medicine) {
		return _allergyService.addMedicineToAllergy(medicine, id);
		
	}

}
