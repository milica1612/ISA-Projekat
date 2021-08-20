package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacistService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/pharmacists", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacistController {

	@Autowired
	private PharmacistService _pharmacistSerivce ;
	
	@GetMapping(path = "/all")
	public List<PharmacistDTO> getAllPharmacist() {
		 return _pharmacistSerivce.getAllPharmacist();
	}
	
	@GetMapping(path = "/searchPharmacistsByFirstName/{firstName}")
	public List<PharmacistDTO> searchPharmacistsByFirstName(@PathVariable String firstName){
		 return _pharmacistSerivce.searchPharmacistsByFirstName(firstName);
	}
	
	@GetMapping(path = "/searchPharmacistsByLastName/{lastName}")
	public List<PharmacistDTO> searchPharmacistsByLastName(@PathVariable String lastName){
		 return _pharmacistSerivce.searchPharmacistsByLastName(lastName);
	}
	
	
	@GetMapping(path = "/searchPharmacists/{firstName}/{lastName}")
	public List<PharmacistDTO> searchPharmacist(@PathVariable String firstName, @PathVariable String lastName){
		 return _pharmacistSerivce.searchPharmacist(firstName, lastName);
	}
	
	@GetMapping(path = "/findPharmacistsByPharmacy/{pharmacyId}")
	public List<PharmacistDTO> findPharmacistsByPharmacy(@PathVariable Long pharmacyId)
	{
		return _pharmacistSerivce.findPharmacistsByPharmacy(pharmacyId);
	}
	
	@GetMapping(path = "/filterPharmacistByRating/{minRating}/{maxRating}")
	public List<PharmacistDTO> filterPharmacistByRating(@PathVariable Double minRating, @PathVariable Double maxRating)
	{
		return _pharmacistSerivce.filterPharmacistByRating(minRating, maxRating);
	}
}
