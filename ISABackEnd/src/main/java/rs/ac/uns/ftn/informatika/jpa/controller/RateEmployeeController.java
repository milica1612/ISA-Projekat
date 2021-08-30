package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.RateEmployee;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacistService;
import rs.ac.uns.ftn.informatika.jpa.service.RateEmployeeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/rateEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
public class RateEmployeeController {

	@Autowired
	private RateEmployeeService _rateEmployeeService;
	
	@Autowired
	private PharmacistService _pharmacistService;
	
	@PostMapping(value = "/ratePharmacist")
	public void rateEmployee(@RequestBody RateEmployee rate) {
		System.out.println("Controller");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		rate.setPatient((Patient) user);
		Double newRating = _rateEmployeeService.rateEmployee(rate);
		_pharmacistService.updateRating(rate.getPharmacyEmployee().getUserId(), newRating);
		
	}
}
