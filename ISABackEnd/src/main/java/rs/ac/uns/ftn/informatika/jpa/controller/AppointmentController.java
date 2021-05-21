package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.AppointmentTimeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Appointment;
import rs.ac.uns.ftn.informatika.jpa.model.AppointmentStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.AppointmentService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {

	@Autowired
	private AppointmentService _appointmentService ;

	@GetMapping(path = "/allappointments")
	public List<AppointmentTimeDTO> getAllAppointments() {
		 return _appointmentService.getAllAppointments();
	}
	
	@PostMapping(value = "/scheduledAppointment")
	public void chooseAppointmentDerm(@RequestBody Appointment a, Patient p) throws Exception {
		
		_appointmentService.chooseAppointmentDerm(a, p);
		
	}
	
	@PostMapping(value = "/scheduleAppointment")
	public ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment){
	
		if (appointment == null) {
			return null;
		}
		
		Appointment _appointment = new Appointment();
		
		_appointment.setDateAndTime(appointment.getDateAndTime());
		_appointment.setDuration(appointment.getDuration());
		_appointment.setAppointmentStatus(AppointmentStatus.NONE);
		_appointment.setCancelled(false);
		_appointment.setPatient(appointment.getPatient());
		_appointment.setPrice(appointment.getPrice());
		_appointment.setPoints(appointment.getPoints());
		_appointment.setShift(appointment.getShift());

		_appointment = _appointmentService.save(_appointment);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
}
