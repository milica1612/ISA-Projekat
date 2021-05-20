package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;

@RestController
@RequestMapping(value = "/pharmacy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {
	
	@Autowired
	private PharmacyService _pharmacyService;
	
	@GetMapping(value = "")
	public ArrayList<Pharmacy> getAllPharmacies() {
		return _pharmacyService.findAllPharmacy();
	}
	
	@GetMapping(path = "/getPharmacyById/{pharmacyId}")
	public PharmacyDTO getPharmacyById(@PathVariable Long pharmacyId) {
		return  _pharmacyService.getPharmacyById(pharmacyId);
	}

	@GetMapping(value = "/filtrateByRating/{rating}")
	public ArrayList<Pharmacy> filtratePharmaciesByRating(@PathVariable Long rating){
		return _pharmacyService.filtratePharmaciesByRating(rating);
	}
	
	@GetMapping(value = "/getByNameOrAddress/{parametar}")
	public ArrayList<Pharmacy> getPharmacyByNameOrAddress(@PathVariable String parametar) {
		return _pharmacyService.getPharmacyByNameOrAddress(parametar);
	}
	
	@GetMapping(value = "/{id}")
	public Pharmacy getPharmacy(@PathVariable Long id) {
		return _pharmacyService.findById(id);
	}

	@GetMapping(value = "/newPharmacy")
	public Pharmacy getNewPharmacy() {
						
		String name = "";
		Double rating = 0.0;
		return new Pharmacy(name, rating);
	}
}
