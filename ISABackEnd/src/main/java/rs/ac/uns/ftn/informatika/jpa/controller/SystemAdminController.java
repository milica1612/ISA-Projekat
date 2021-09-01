package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyRegisterDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.service.SystemAdminService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/systemAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemAdminController {

	@Autowired
	private SystemAdminService systemAdminService;

	@Autowired
	private UserService userService;
	
	// Endpoint za registraciju novog korisnika
	@PostMapping("/createSystemAdmin")
	public ResponseEntity<?> createSystemAdmin(@RequestBody RegistrationRequest userRequest, UriComponentsBuilder ucBuilder) {
		try {

		  return new ResponseEntity<>(this.systemAdminService.saveSystemAdmin(userRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/createDermatologist")
	public ResponseEntity<?> createDermatologist(@RequestBody RegistrationRequest userRequest, UriComponentsBuilder ucBuilder) {
		try {
				
		  return new ResponseEntity<>(this.systemAdminService.saveDermatologist(userRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/createSupplier")
	public ResponseEntity<?> createSupplier(@RequestBody RegistrationRequest userRequest, UriComponentsBuilder ucBuilder) {
		try {
		
		  return new ResponseEntity<>(this.systemAdminService.saveSupplier(userRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
}
	

