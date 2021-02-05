package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService _userService ;

	@GetMapping(value = "/{id}")
	public User getPatient(@PathVariable Long id) {
		return (User) _userService.findById(id);
	}
	
	
	@PostMapping(value = "/createPatient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){

		
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
	
	@PostMapping(value = "/createSupplier")
	public ResponseEntity<Patient> createSupplier(@RequestBody Supplier supplier){
		
		if(supplier == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Supplier _supplier = new Supplier();
		
		_supplier.setFirstName(supplier.getFirstName());
		_supplier.setLastName(supplier.getLastName());
		_supplier.setPhoneNumber(supplier.getPhoneNumber());
		_supplier.setAddress(supplier.getAddress());
		_supplier.setUserType(UserType.SUPPLIER);
		_supplier.setEmail(supplier.getEmail());
		_supplier.setPassword(supplier.getPassword());
		
		_supplier = (Supplier) _userService.save(_supplier);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = "/createPharmacyAdmin")
	
	public ResponseEntity<Patient> createPharmacyAdmin(@RequestBody PharmacyAdministrator pharmacyAdministrator){

		if(pharmacyAdministrator == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		PharmacyAdministrator _pharmacyAdministrator = new PharmacyAdministrator();
		
		_pharmacyAdministrator.setFirstName(pharmacyAdministrator.getFirstName());
		_pharmacyAdministrator.setLastName(pharmacyAdministrator.getLastName());
		_pharmacyAdministrator.setPhoneNumber(pharmacyAdministrator.getPhoneNumber());
		_pharmacyAdministrator.setAddress(pharmacyAdministrator.getAddress());
		_pharmacyAdministrator.setUserType(UserType.PH_ADMINISTRATOR);
		_pharmacyAdministrator.setEmail(pharmacyAdministrator.getEmail());
		_pharmacyAdministrator.setPassword(pharmacyAdministrator.getPassword());
		_pharmacyAdministrator.setPharmacy(pharmacyAdministrator.getPharmacy());
		
		_pharmacyAdministrator = (PharmacyAdministrator) _userService.save(_pharmacyAdministrator);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = "/createDermatologist")
	public ResponseEntity<Patient> createDermatologist(@RequestBody Dermatologist dermatologist){

		if(dermatologist == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Dermatologist _dermatologist = new Dermatologist();
		
		_dermatologist.setFirstName(dermatologist.getFirstName());
		_dermatologist.setLastName(dermatologist.getLastName());
		_dermatologist.setPhoneNumber(dermatologist.getPhoneNumber());
		_dermatologist.setAddress(dermatologist.getAddress());
		_dermatologist.setUserType(UserType.DERMATOLOGIST);
		_dermatologist.setEmail(dermatologist.getEmail());
		_dermatologist.setPassword(dermatologist.getPassword());
		_dermatologist.setPharmacy(dermatologist.getPharmacy());
		
		_dermatologist = (Dermatologist) _userService.save(_dermatologist);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
}
