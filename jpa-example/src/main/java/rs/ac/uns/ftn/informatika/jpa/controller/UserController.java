package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.servlet.http.HttpSession;

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

import rs.ac.uns.ftn.informatika.jpa.dto.LogInDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService _userService ;

	@GetMapping(value = "/{id}")
	public User findUser(@PathVariable Long id) {
		return (User) _userService.findById(id);
	}
 
	@GetMapping(value = "/email/{email}")
	public User findUserByEmail(@PathVariable String email) {
		return _userService.findByEmail(email);
	}	
	
	@GetMapping(value = "/email/{email}/{password}")
	public User findUser(@PathVariable String email, @PathVariable String password) {
		return _userService.findByEmailAndPassword(email, password);
	}	
	
	@GetMapping(value = "/login")
	public User logInUser(@RequestBody LogInDTO logInDTO, HttpSession session){
		
		User user = _userService.findByEmailAndPassword(logInDTO.getEmail(), logInDTO.getPassword());
		
		if(user == null) {
			return null;
		}
		
		session.setAttribute("email", user.getEmail());
		return user;
		
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
	public Supplier createSupplier(@RequestBody Supplier supplier){
		
		if(supplier == null) {
			return null;
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
		return _supplier;
		
	}
	
	@PostMapping(value = "/createPharmacyAdmin")
	public ResponseEntity<PharmacyAdministrator> createPharmacyAdmin(@RequestBody PharmacyAdministrator pharmacyAdministrator){

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
	public ResponseEntity<Dermatologist> createDermatologist(@RequestBody Dermatologist dermatologist){

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
		_dermatologist.setRating(dermatologist.getRating());
		
		_dermatologist = (Dermatologist) _userService.save(_dermatologist);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@PostMapping(value = "/update")
	public void updateUser(@RequestBody User user) throws Exception {
		
		System.out.println(user.getUserId());
		
		_userService.update(user);
		
	}
	
	@GetMapping(value = "/new")
	public Supplier getNewSupplier() {
						
		String firstName = "";
		String email = "";
		String lastName = "";
		String phoneNumber = "";
		String street = "";
		String streetNumber = "";
		String city = "";
		String country = "";
		Double longitude = 0.0;
		Double latitude = 0.0;
		String username = "";
		String password = "";
		
		return  new Supplier(firstName, lastName, username, password, email,
				phoneNumber, UserType.SUPPLIER, new Address(street, streetNumber, city, country, longitude, latitude));
		
	}
	
	@GetMapping(value = "/newDermatologist")
	public Dermatologist getNewDermatologist() {
						
		String firstName = "";
		String email = "";
		String lastName = "";
		String phoneNumber = "";
		String street = "";
		String streetNumber = "";
		String city = "";
		String country = "";
		Double longitude = 0.0;
		Double latitude = 0.0;
		String username = "";
		String password = "";
		Double rating = 0.0;
		
		return new Dermatologist(firstName, lastName, username, password, email,
				phoneNumber, UserType.DERMATOLOGIST, new Address(street, streetNumber, city, country, latitude, longitude), rating);
	}

	
	@GetMapping(value = "/newPhAdmin")
	public PharmacyAdministrator getNewPharmacyAdmin() {
						
		String firstName = "";
		String email = "";
		String lastName = "";
		String phoneNumber = "";
		String street = "";
		String streetNumber = "";
		String city = "";
		String country = "";
		Double longitude = 0.0;
		Double latitude = 0.0;
		String username = "";
		String password = "";
		
		return  new PharmacyAdministrator(firstName, lastName, username, password, email,
				phoneNumber, UserType.PH_ADMINISTRATOR, new Address(street, streetNumber, city, country, longitude, latitude), new Pharmacy());
	}
	
}
