package rs.ac.uns.ftn.informatika.jpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.jpa.iservice.IUserService;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService _userService ;
	

	@GetMapping(value = "/{id}")
	public User findUser(@PathVariable Long id) {
		return (User) _userService.findById(id);
	}
	
	@PostMapping(value = "/update")
	public void updateUser(@RequestBody User user) throws Exception {
		
		System.out.println(user.getUserId());
		
		_userService.update(user);
		
		//return new ModelAndView("redirect:/greetings", "greetings", greetingService.findAll());
	}

	
}
