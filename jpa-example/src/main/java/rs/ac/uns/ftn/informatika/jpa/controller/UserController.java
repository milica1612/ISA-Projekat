package rs.ac.uns.ftn.informatika.jpa.controller;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.iservice.IUserService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.service.AddressService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService _userService ;
	private AddressService _addressService;

	@GetMapping(value = "/{id}")
	public User getPatient(@PathVariable Long id) {
		return (User) _userService.findById(id);
	}
	
	@PostMapping(value = "/createPatient")
	public ResponseEntity<Patient> create(@RequestBody Patient patient){

		
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Patient _patient = new Patient();
		
		_patient.setFirstName(patient.getFirstName());
		_patient.setLastName(patient.getLastName());
		_patient.setPhoneNumber(patient.getPhoneNumber());
		_patient.setAddress(patient.getAddress());
		_patient.setUserName(patient.getUserName());
		_patient.setUserType(UserType.PATIENT);
		_patient.setEmail(patient.getEmail());
		_patient.setPassword(patient.getPassword());
		
		_patient = (Patient) _userService.save(_patient);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
}
