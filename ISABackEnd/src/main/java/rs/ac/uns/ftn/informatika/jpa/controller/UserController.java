package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Penalty;
import rs.ac.uns.ftn.informatika.jpa.model.PenaltyType;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.service.PenaltyService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService _userService ;
	

	@Autowired
	private PenaltyService _penaltyService;
	
	@GetMapping(value = "/{id}")
	public User findUser(@PathVariable Long id) {
		return (User) _userService.findById(id);
	}
	
	@GetMapping(value = "/currentUser")
	public User getCurrentLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return user;
	}

 
	@GetMapping(value = "/email/{email}")
	public User findUserByEmail(@PathVariable String email) {
		return _userService.findByEmail(email);
	}	
	

	@GetMapping(value = "/email/{email}/{password}")
	public User findUser(@PathVariable String email, @PathVariable String password) {
		return _userService.findByEmailAndPassword(email, password);
	}	
	
	@GetMapping(path = "/findAllByUserType/{userType}")
	public List<UserDTO> findAllByPharmacyIdAndUserType(@PathVariable UserType userType) {
		return _userService.findUserByUserType(userType);
	}	
	

	@GetMapping(path = "/getAllpatients")
	public List<UserDTO> getAllPatients() {
		 return _userService.getAllUsers();
	}
	
	static class NameAndEmployee{
		public String fullName;
		public Long employeeId;
	}
	
    @PutMapping(value = "/searchUser")
    public List<Patient> searchUser(@RequestBody NameAndEmployee ne) {
    	return _userService.getPatientsByName(ne.fullName, ne.employeeId);
	}
	

	@PostMapping(value = "/update")
	public void updateUser(@RequestBody User user) throws Exception {
		
		System.out.println(user.getUserId());
		
		_userService.update(user);
		
	}
	
	@PostMapping(value = "/increasePenaltyExamination")
	public void increasePenaltyExamination(@RequestBody Examination e) throws Exception {
		Penalty p = new Penalty(e.getDateAndTime().toString(), PenaltyType.EXAMINATION_MISSED, e.getPharmacy());
		Penalty newPenalty = _penaltyService.save(p);
		_userService.increasePenalty(e.getPatient().getUserId(),newPenalty);
	}
	
	@PostMapping(value = "/increasePenaltyConsultation")
	public void increasePenaltyConsultation(@RequestBody Consultation c) throws Exception {
		Penalty p = new Penalty(c.getDateAndTime().toString(), PenaltyType.CONSULTATION_MISSED, c.getPharmacy());
		Penalty newPenalty = _penaltyService.save(p);
		_userService.increasePenalty(c.getPatient().getUserId(), newPenalty);
	}
}	
