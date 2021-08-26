package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacistVacation;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacistVacationService;

@CrossOrigin(origins= "http://localhost:8080")
@RestController
@RequestMapping(value = "/pharmacistVacation", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacistVacationController {
	
	private PharmacistVacationService _pharmacistVacationService;
	
	@Autowired
	public PharmacistVacationController(PharmacistVacationService pharmacistVacationService) {
		this._pharmacistVacationService = pharmacistVacationService;
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path = "/all")
	public ResponseEntity<List<PharmacistVacation>> findAllPharmacistVacation() {
		List<PharmacistVacation> listVacationDTO = _pharmacistVacationService.findAllPharmacistVacation();
		return new ResponseEntity<List<PharmacistVacation>>(listVacationDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path = "/allWithStatusWaiting")
	public ResponseEntity<List<PharmacistVacation>> findAllPharmacistVacationWithStatusWaiting() {
		List<PharmacistVacation> listVacationDTO = _pharmacistVacationService.findAllPharmacistVacationWithStatusWaiting();
		return new ResponseEntity<List<PharmacistVacation>>(listVacationDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("('ROLE_PH_ADMIN')")
	@PostMapping(value = "/accept/{vacationId}") 
	public ResponseEntity<Boolean> accept(@PathVariable Long vacationId) {
		try {
			Boolean value = _pharmacistVacationService.accept(vacationId);
			return new ResponseEntity<Boolean>(value, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@PostMapping(value = "/decline") 
	public ResponseEntity<Boolean> decline(@RequestBody RequestDeclineDTO requestDeclineDTO) { 
		try {
			Boolean value = _pharmacistVacationService.decline(requestDeclineDTO);
			return new ResponseEntity<Boolean>(value, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
}
