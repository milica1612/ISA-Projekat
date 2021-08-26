package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
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
		String d = dto.getDate() + " " +  dto.getTime() + ":00";
	    Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
			System.out.println(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Pharmacy>();
		}  
		
	
		return _workSchedulePharmacist.getAvailablePharmacies(date);
		
	}
	
	@PutMapping("/getAvailablePharmacistsInPharmacy")
	public ArrayList<Pharmacist> getAvalibalePharmacistsInPharmacy(@RequestBody ConsultationDTO dto){
		String d = dto.getDate() + " " +  dto.getTime() + ":00";
	    Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
			System.out.println(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Pharmacist>();
		}  
		long id = Long.parseLong(dto.getPharmacyId());
		
		return _workSchedulePharmacist.getAvailablePharmacistsInPharmacy(date, id);
	}

}
