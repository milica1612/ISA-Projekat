package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.LogInDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.security.auth.JwtAuthenticationRequest;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService _userService ;

	@GetMapping(value = "/loggedUser")
	public User getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
	
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
	
	@GetMapping(path = "/findAllByUserType/{userType}")
	public List<UserDTO> findAllByPharmacyIdAndUserType(@PathVariable UserType userType) {
		return _userService.findUserByUserType(userType);
	}	
	
	
	@GetMapping(path = "/allpatients")
	public List<UserDTO> getAllUsers() {
		 return _userService.getAllUsers();
	}
	 
    @PostMapping(value = "/searchUser")
    public List<UserDTO> searchUser(@RequestBody String request) {
    	
    	String[] values = request.split("\\+");
    	String[] valueNew = values[1].split("\\=");
    	/*if (values.length != 2) {
    		return null;
    	}
    	*/
    	UserDTO user = new UserDTO(values[0], valueNew[0]);
    	return _userService.userSearch(user);
	}

	@PostMapping(value = "/update")
	public void updateUser(@RequestBody User user) throws Exception {
		
		System.out.println(user.getUserId());
		
		_userService.update(user);
		
	}
		
}
