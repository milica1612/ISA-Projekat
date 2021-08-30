package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.RateEmployee;
import rs.ac.uns.ftn.informatika.jpa.model.RatePharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;
import rs.ac.uns.ftn.informatika.jpa.service.RatePharmacyService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/ratePharmacy")
public class RatePharmacyController {
	@Autowired
	RatePharmacyService _ratePharmacyService;
	
	@Autowired
	PharmacyService _pharmacyService;
	
	
	@PostMapping(value = "/rate")
	public void rateEmployeePharmacist(@RequestBody RatePharmacy rate) {
		if(rate.getRating()<6 || rate.getRating()>10) {
			return;
		}
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		rate.setPatient((Patient) user);
		Double newRating = _ratePharmacyService.ratePharmacy(rate);
		_pharmacyService.updateRating(rate.getPharmacy().getPharmacyId(), newRating);
		
	}
	
}
