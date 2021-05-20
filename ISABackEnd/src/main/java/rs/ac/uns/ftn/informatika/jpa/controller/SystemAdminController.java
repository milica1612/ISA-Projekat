package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.exception.ResourceConflictException;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;
import rs.ac.uns.ftn.informatika.jpa.service.SystemAdminService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "/sysAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemAdminController {

	@Autowired
	public SystemAdminService systemAdminService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public PharmacyService pharmacyService;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/registerDermatologist")
	@PreAuthorize("hasRole('SYS_ADMINISTRATOR')")
	public ResponseEntity<?> registerDermatologist(@RequestBody RegistrationRequest userRequest, UriComponentsBuilder ucBuilder) {
		try {
		User existUser = this.userService.findByEmail(userRequest.getEmail());
		if (existUser != null) 
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		
		  return new ResponseEntity<>(this.systemAdminService.createDermatologist(userRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/registerSupplier")
//	@PreAuthorize("hasRole('SYS_ADMINISTRATOR')")
	public ResponseEntity<?> registerSupplier(@RequestBody RegistrationRequest userRequest, UriComponentsBuilder ucBuilder) {
		try {
		User existUser = this.userService.findByEmail(userRequest.getEmail());
		if (existUser != null) 
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		
		  return new ResponseEntity<>(this.systemAdminService.createSupplier(userRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/registerPharmacist")
//    @PreAuthorize("hasRole('SYS_ADMINISTRATOR')")
	public ResponseEntity<?> registerPharmacist(@RequestBody RegistrationRequest userRequest, UriComponentsBuilder ucBuilder) {
		try {
		User existUser = this.userService.findByEmail(userRequest.getEmail());
		if (existUser != null) 
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		
		  return new ResponseEntity<>(this.systemAdminService.createPharmacist(userRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/createPharmacy")
	//@PreAuthorize("hasRole('SYS_ADMINISTRATOR')")
	public ResponseEntity<?> createPharmacy(@RequestBody PharmacyDTO pharmacyDTO) {
		try {
			return new ResponseEntity<>(pharmacyService.createPharmacy(pharmacyDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
