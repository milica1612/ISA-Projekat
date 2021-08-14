package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bsep.bsep.model.Authority;
import bsep.bsep.model.Users;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.model.ConfirmationToken;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserTokenState;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.security.TokenUtils;
import rs.ac.uns.ftn.informatika.jpa.security.auth.JwtAuthenticationRequest;
import rs.ac.uns.ftn.informatika.jpa.service.AuthorityService;
import rs.ac.uns.ftn.informatika.jpa.service.ConfirmationTokenService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private final ConfirmationTokenService confirmationTokenService;
	
	private final AuthorityService authorityService;
	
	@Autowired
	public UserController(UserService userService, AuthorityService authorityService,
			ConfirmationTokenService confirmationTokenService) {
		this.userService = userService;
		this.authorityService = authorityService;
		this.confirmationTokenService = confirmationTokenService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> login(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {
 
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();
		
		if(user.getIsEnabled())
		{
			String jwt = tokenUtils.generateToken(user.getEmail());
			// Vrati token kao odgovor na uspesnu autentifikaciju
			return ResponseEntity.ok(new UserTokenState(user.getUserType().name(), jwt, tokenUtils.getExpiredIn()));
		}
		// BAD REQUEST 400
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/confirm_account/{token}", consumes = "application/json")
	public ResponseEntity<Boolean> confirmAccount(@PathVariable String token) {
		try {

			ConfirmationToken confirmationToken = confirmationTokenService.findByConfirmationToken(token);
			if (confirmationToken != null) {
				setupConfirmedAccount(confirmationToken);
				return new ResponseEntity<>(HttpStatus.OK);
				
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	private void setupConfirmedAccount(ConfirmationToken confirmationToken) {
		User user = userService.findByEmail(confirmationToken.getUsers().getEmail());
		user.setIsEnabled(true);
		userService.updateUser(user);
	}

	@GetMapping(value = "/loggedUser")
	public User getLoggedUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
	@GetMapping(value = "/{id}")
	public User findUser(@PathVariable Long id) {
		return (User) userService.findById(id);
	}
 
	@GetMapping(value = "/email/{email}")
	public User findUserByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}	
	

	@GetMapping(value = "/email/{email}/{password}")
	public User findUser(@PathVariable String email, @PathVariable String password) {
		return userService.findByEmailAndPassword(email, password);
	}	
	
	@GetMapping(path = "/findAllByUserType/{userType}")
	public List<UserDTO> findAllByPharmacyIdAndUserType(@PathVariable UserType userType) {
		return userService.findUserByUserType(userType);
	}	
	
	
	@GetMapping(path = "/allpatients")
	public List<UserDTO> getAllUsers() {
		 return userService.getAllUsers();
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
    	return userService.userSearch(user);
	}

	@PostMapping(value = "/update")
	public void updateUser(@RequestBody User user) throws Exception {
		userService.update(user);
		
	}
	
}
