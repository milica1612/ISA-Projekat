package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.ConsultationService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/consultation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsultationController {

	@Autowired
	private ConsultationService _consultationService;
	

	@Autowired
	private UserService _userService;
	
	@Autowired
	private WorkSchedulePharmacistController _workSchedulePharmacist;
	
	static class Request{
		public ConsultationDTO dto;
		public Long patientId;
	}
	
	@PostMapping("/create")
	public void createNewConsultation(@RequestBody Request r) {
		//Patient user = (Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = _userService.findById(r.patientId);
		System.out.println(r.dto.getPharmacist().getFirstName() + " +++++++++++++++++++++++++");
		
		this._consultationService.save(r.dto, (Patient) user);
	}
	
	
}
