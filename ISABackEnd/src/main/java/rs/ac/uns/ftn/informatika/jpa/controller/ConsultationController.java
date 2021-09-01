package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.controller.ExaminationContoller.DataForAppointment;
import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationViewDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
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
		if(!_userService.checkPenalties(r.patientId)) {
			System.out.println("Unable to schedule consultation because of penalties");
			return;
		}
		Consultation c = this._consultationService.save(r.dto, (Patient) user);
		this._workSchedulePharmacist.addNewConsultationToWorkSchedule(c);
		this._emailService.sendConsultationConfirmation(c);
	}
	@GetMapping(value = "/getByPatientId/{patientId}")
	public ArrayList<ConsultationViewDTO> getByPatient(@PathVariable Long patientId){
		return _consultationService.getByPatient(patientId);
	}
	

	@GetMapping(value = "/getPreviousConsultations/{patientId}")
	public ArrayList<ConsultationViewDTO> getPreviousConsultations(@PathVariable Long patientId){
		return _consultationService.getPreviousConsultations(patientId);
	}
	
	@PutMapping(value = "/cancel")
	public boolean cancelConsultation(@RequestBody ConsultationViewDTO consultation) {
		return _consultationService.cancelConsultation(consultation);
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
	
	
	@GetMapping(value = "/allForPharmacist/{id}")
	public List<Consultation> getByPharmacist(@PathVariable Long id) {
		return _consultationService.getByPharmacist(id);
	}
	

	static class DataForAppointment{
		public Date dateAndTime;
		public Long pharmId;
		public Long patientId;
	}
	
	@PutMapping(value = "/findCurrentTerm")
	public Consultation findCurrentTerm(@RequestBody DataForAppointment dfa) {
		
		Consultation e = _consultationService.startConsultation(dfa.dateAndTime);
		if(e.getPharmacist() != null && e.getPatient() != null) {
			if(dfa.patientId.equals(e.getPatient().getUserId())
					&& dfa.pharmId.equals(e.getPharmacist().getUserId())) {
					return e;
			}
		else
			return new Consultation();
		}
		
		else return new Consultation();
	}
	
	@GetMapping(value = "/getAllPharmacistsByPatient/{patientId}")
	public ArrayList<Pharmacist> getAllPharmacistByPatient(@PathVariable Long patientId){
		return _consultationService.getAllPharmacistForPatient(patientId);
	}

}
