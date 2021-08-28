package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.ConsultationService;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;
import rs.ac.uns.ftn.informatika.jpa.service.WorkSchedulePharmacistService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/consultation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsultationController {

	@Autowired
	private ConsultationService _consultationService;
	

	@Autowired
	private UserService _userService;
	
	@Autowired
	private EmailService _emailService;
	
	@Autowired
	private WorkSchedulePharmacistService _workSchedulePharmacist;
	
	static class Request{
		public ConsultationDTO dto;
		public Long patientId;
	}
	
	@PostMapping("/create")
	public void createNewConsultation(@RequestBody Request r) {
		User user = _userService.findById(r.patientId);
		Consultation c = this._consultationService.save(r.dto, (Patient) user);
		this._workSchedulePharmacist.addNewConsultationToWorkSchedule(c);
		this._emailService.sendConsultationConfirmation(c);
	}
	
	@PutMapping(value = "/createNewConsultation")
	public Boolean createNewExamination(@RequestBody Consultation consultation) {
		
		Calendar examS = Calendar.getInstance();
		examS.setTime(consultation.getDateAndTime());
		examS.add(Calendar.HOUR, -1);
		
		Calendar endExam = Calendar.getInstance(); // creates calendar
		endExam.setTime(examS.getTime());               // sets calendar time/date
		endExam.add(Calendar.MINUTE, 30);
		boolean available = true;
		
		System.out.println(examS.getTime().toString());
		System.out.println(endExam.getTime().toString());
		
		Long examStart = examS.getTimeInMillis();
		Long examEnd = endExam.getTimeInMillis(); 
		
		ArrayList<Consultation> byPatient = _consultationService.getConsultationsByPatient(consultation.getPatient().getUserId());
		for (Consultation e: byPatient) {
			
			Calendar pS = Calendar.getInstance();
			pS.setTime(e.getDateAndTime());
			
			Calendar pEn = Calendar.getInstance(); // creates calendar
			pEn.setTime(e.getDateAndTime()); // sets calendar time/date
			pEn.add(Calendar.MINUTE, 30);
			
			Long pStart = pS.getTimeInMillis();
			Long pEnd = pEn.getTimeInMillis();
			
			System.out.println(pS.getTime().toString());
			System.out.println(pEn.getTime().toString());
			System.out.println(examStart + " " +  examEnd + " " + pStart + " " + pEnd);
			
			if(examStart <= pStart && examEnd >= pStart) {
				available = false;
				break;
			} else if (examStart <= pEnd && examEnd >= pEnd) {
				available = false;
				break;
			}
		}
		if(available) {
			Consultation c = this._consultationService.saveConsultation(consultation);
			if(!this._workSchedulePharmacist.addConsToWorkSchedule(c)) {
				return false;
			}
			this._emailService.sendConsultationConfirmation(c);
			return true;
		}else {
			return false;
		}
	}
	
}
