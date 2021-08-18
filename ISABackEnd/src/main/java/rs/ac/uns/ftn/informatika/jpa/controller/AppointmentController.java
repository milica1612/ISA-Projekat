package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Appointment;
import rs.ac.uns.ftn.informatika.jpa.service.AppointmentService;;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService _appointmentService ;
	
	@GetMapping("/getByPharmacy/{pharmacyId}")
	public ArrayList<Appointment> getAppointmentsByPharmacy(@PathVariable Long pharmacyId) {
		return _appointmentService.getAppointmentsByPharmacy(pharmacyId);
		
	}
}
