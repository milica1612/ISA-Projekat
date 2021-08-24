package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.AppointmentDateAndTimeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.service.WorkSchedulePharmacistService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/workSchedulePharmacist", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkSchedulePharmacistController {
	@Autowired
	private WorkSchedulePharmacistService _workSchedulePharmacist;
	
	@PutMapping("/getAvailablePharmacies")
	public ArrayList<Pharmacy> getAvailablePharmacies(@RequestBody AppointmentDateAndTimeDTO dto) {
		System.out.println(dto.getDate());
		
		System.out.println(dto.getTime());
		return new ArrayList<Pharmacy>();
		
	}

}
