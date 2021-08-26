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
import rs.ac.uns.ftn.informatika.jpa.model.DermatologistVacation;
import rs.ac.uns.ftn.informatika.jpa.service.DermatologistVacationService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/dermatologistVacation", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistVacationController {
	
	private DermatologistVacationService _dermatologistVacationService;
	
	@Autowired
	public DermatologistVacationController(DermatologistVacationService dermatologistVacationService) {
		this._dermatologistVacationService = dermatologistVacationService;
	}
	
	@PreAuthorize("hasRole('ROLE_SYS_ADMIN')")
	@GetMapping(path = "/all")
	public ResponseEntity<List<DermatologistVacation>> findAllPharmacistVacation() {
		List<DermatologistVacation> listVacationDTO = _dermatologistVacationService.findAllDermatologistVacation();
		return new ResponseEntity<List<DermatologistVacation>>(listVacationDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_SYS_ADMIN')")
	@GetMapping(path = "/allWithStatusWaiting")
	public ResponseEntity<List<DermatologistVacation>> findAllPharmacistVacationWithStatusWaiting() {
		List<DermatologistVacation> listVacationDTO = _dermatologistVacationService.findAllDermatologistVacationWithStatusWaiting();
		return new ResponseEntity<List<DermatologistVacation>>(listVacationDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_SYS_ADMIN')")
	@PostMapping(value = "/accept/{vacationId}") 
	public ResponseEntity<DermatologistVacation> accept(@PathVariable Long vacationId) {
		try {
			return new ResponseEntity<DermatologistVacation>(_dermatologistVacationService.accept(vacationId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DermatologistVacation>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_SYS_ADMIN')")
	@PostMapping(value = "/decline") 
	public ResponseEntity<DermatologistVacation> decline(@RequestBody RequestDeclineDTO requestDeclineDTO) { 
		try {
			return new ResponseEntity<DermatologistVacation>(_dermatologistVacationService.decline(requestDeclineDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<DermatologistVacation>(HttpStatus.BAD_REQUEST);
		}
	}

}
