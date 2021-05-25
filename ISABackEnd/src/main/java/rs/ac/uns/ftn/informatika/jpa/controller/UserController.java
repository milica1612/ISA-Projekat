package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService _userService ;

	@GetMapping(value = "/currentUser")
	public User getCurrentLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return user;
	}
	
	
	@GetMapping(value = "/{id}")
	public User findUser(@PathVariable Long id) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getEmail());
		return (User) _userService.findById(user.getUserId());
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
