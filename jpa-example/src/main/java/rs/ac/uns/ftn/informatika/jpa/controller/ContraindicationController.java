package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.service.ContraindicationService;

@RestController
@RequestMapping(value = "/contraindications")
public class ContraindicationController {

	@Autowired
	private ContraindicationService _contraindicationService;

	@GetMapping(value = "/{id}")
	public Contraindication findById(@PathVariable Long id) {
		return _contraindicationService.findById(id);
	}
	
}
