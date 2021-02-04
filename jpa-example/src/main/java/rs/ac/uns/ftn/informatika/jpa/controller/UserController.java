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
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
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
	
	@PostMapping(value = "/createSupplier")
	public ResponseEntity<Patient> create(@RequestBody Supplier supplier){
		
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
	public ResponseEntity<Patient> create(@RequestBody PharmacyAdministrator pharmacyAdministrator){

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
}
