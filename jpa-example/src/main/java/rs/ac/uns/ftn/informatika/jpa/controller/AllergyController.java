package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.PathParam;

import rs.ac.uns.ftn.informatika.jpa.service.AllergyService;


@RestController
@RequestMapping(value = "/allergy")
public class AllergyController {
	@Autowired
	private AllergyService _allergyService ;
	
	@PutMapping("/{id}/add")
	public Set<Medicine> addMedicineToAllergy(@PathVariable Long id,@RequestBody Medicine medicine) {
		return _allergyService.addMedicineToAllergy(medicine, id);
		
	}

}
