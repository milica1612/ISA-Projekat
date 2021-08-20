package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.service.DermatologistService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/dermatologists", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistController {
	
	private DermatologistService _dermatologistService;
	@Autowired
	public DermatologistController(DermatologistService dermatologistService) {
		this._dermatologistService = dermatologistService;
	}
	
	@GetMapping(path = "/all")
	public List<DermatologistDTO> getAllDermatologist(){
		return _dermatologistService.getAllDermatologist();
	}
	
	@GetMapping(value = "/searchDermatologistsByFirstName/{firstName}")
	public List<DermatologistDTO> searchDermatologistsByFirstName(@PathVariable String firstName){
		 return _dermatologistService.searchDermatologistsByFirstName(firstName);
	}
	
	@GetMapping(path = "/searchDermatologistsByLastName/{lastName}")
	public List<DermatologistDTO> searchDermatologistsByLastName(@PathVariable String lastName){
		 return _dermatologistService.searchDermatologistsByLastName(lastName);
	}
	
	
	@GetMapping(path = "/searchDermatologists/{firstName}/{lastName}")
	public List<DermatologistDTO> searchDermatologist(@PathVariable String firstName, @PathVariable String lastName){
		 return _dermatologistService.searchDermatologist(firstName, lastName);
	}
	
	@GetMapping(path = "/filterDermatologistByRating/{minRating}/{maxRating}")
	public List<DermatologistDTO> filterDermatologistByRating(@PathVariable Double minRating, @PathVariable Double maxRating)
	{
		return _dermatologistService.filterDermatologistByRating(minRating, maxRating);
	}
}
