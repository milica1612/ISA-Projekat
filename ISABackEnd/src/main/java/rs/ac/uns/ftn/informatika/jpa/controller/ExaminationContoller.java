package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.CreateFreeTermDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyFreeTermDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ResponseFreeTermDTO;
import rs.ac.uns.ftn.informatika.jpa.model.AppointmentStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.TimeInterval;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.ExaminationService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;
import rs.ac.uns.ftn.informatika.jpa.service.WorkScheduleDermatologistService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/examination")
public class ExaminationContoller {
	
	@Autowired
	ExaminationService _examinationService;
	
	@Autowired
	private EmailService _emailService;
	
	@Autowired
	private UserService _userService;

	@Autowired
	private WorkScheduleDermatologistService _workScheduleDermatologist;
	
	@GetMapping(value = "/getByPharmacy/{pharmacyId}")
	public ArrayList<ExaminationDTO> getByPharmacy(@PathVariable Long pharmacyId){
		return _examinationService.getByPharmacy(pharmacyId);
	}
	
	@GetMapping(value = "/getPreviousExaminations/{patientId}")
	public ArrayList<ExaminationDTO> getPreviousExaminations(@PathVariable Long patientId){
		return _examinationService.getPreviousExaminations(patientId);
	}
	
	@GetMapping(value = "/getByPatientId/{patientId}")
	public ArrayList<ExaminationDTO> getByPatient(@PathVariable Long patientId){
		return _examinationService.getByPatient(patientId);
	}
	
	@PutMapping(value = "/schedule")
	public void scheduleExamination(@RequestBody ExaminationDTO examination) {
		if(!_userService.checkPenalties(examination.getPatient().getUserId())) {
			System.out.println("Unable to schedule examination because of penalties");
			return;
		}
		Examination e = _examinationService.scheduleExamination(examination);
		_emailService.sendExaminationConfirmation(e);
	}
	
	@PutMapping(value = "/cancel")
	public boolean cancelExamination(@RequestBody ExaminationDTO examination) {
		return _examinationService.cancelExamination(examination);
	}
	
	static class DataForTerm{
		public Long pharmacyId;
		public Long dermatologistId;
		public Long patientId;
	}
	
	@PutMapping(value = "/findValidNextTerm")
	public ArrayList<ExaminationDTO> findValidNextTerm(@RequestBody DataForTerm dataForTerm){
		
		ArrayList<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
		ArrayList<ExaminationDTO> byPharmacy = _examinationService.getByPharmacy(dataForTerm.pharmacyId);
		ArrayList<ExaminationDTO> byDermatologist = _examinationService.getByDermatologist(dataForTerm.dermatologistId);
		ArrayList<ExaminationDTO> byPatient = _examinationService.getByPatient(dataForTerm.patientId);
		
		for(ExaminationDTO e1: byPharmacy) {
			for(ExaminationDTO e2: byDermatologist) {
				for(ExaminationDTO e3: byPatient) {
					if(e1.getAppointmentId().equals(e2.getAppointmentId())
							&& !e2.getAppointmentId().equals(e3.getAppointmentId())) {
						result.add(e1);
					}
				}
			}
		}
		
		return result;
		
	}
	
	
	@PutMapping(value = "/createNewExamination")
	public Boolean createNewExamination(@RequestBody Examination examination) {
		
		Calendar examS = Calendar.getInstance();
		examS.setTime(examination.getDateAndTime());
		examS.add(Calendar.HOUR, -1);
		
		Calendar endExam = Calendar.getInstance(); // creates calendar
		endExam.setTime(examS.getTime());               // sets calendar time/date
		endExam.add(Calendar.MONTH, 1);
		endExam.add(Calendar.MINUTE, 30);
		boolean available = true;
		
		System.out.println(examS.getTime().toString());
		
		Long examStart = examS.getTimeInMillis();
		Long examEnd = endExam.getTimeInMillis(); 
		
		ArrayList<Examination> byPatient = _examinationService.getExaminationsByPatient(examination.getPatient().getUserId());
		for (Examination e: byPatient) {
			
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
			Examination e = this._examinationService.saveExamination(examination);
			if(!this._workScheduleDermatologist.addNewExaminationToWorkSchedule(e)) {
				return false;
			}
			this._emailService.sendExaminationConfirmation(e);
			return true;
		}else {
			return false;
		}
	}
	
	static class DataForAppointment{
		public Date dateAndTime;
		public Long dermId;
		public Long patientId;
	}
	
	@PutMapping(value = "/findCurrentTerm")
	public Examination findCurrentTerm(@RequestBody DataForAppointment dfa) {
		
		Examination e = _examinationService.startExamination(dfa.dateAndTime);
		if(e.getDermatologist() != null && e.getPatient() != null && e.getAppointmentStatus().equals(AppointmentStatus.NONE)) {
			if(dfa.patientId.equals(e.getPatient().getUserId())
					&& dfa.dermId.equals(e.getDermatologist().getUserId())) {
					return e;
			}
		else
			return new Examination();
		}
		
		else return new Examination();
	}
	
	@GetMapping(value = "/getAllDermatologistByPatient/{patientId}")
	public ArrayList<Dermatologist> getAllDermatologistByPatient(@PathVariable Long patientId){
		return _examinationService.getAllDermatologistByPatient(patientId);
	}
	
	static class DataForPharmacies{
		public TimeInterval timeInterval;
		public Long pharmacyId;
	}
	
	@PutMapping(value = "/allForDermatologist/{id}")
	public List<Examination> getByDermatologist(@PathVariable Long id, @RequestBody DataForPharmacies dfp) {
		 List<Examination> allExam = _examinationService.getByDermatologist(id, dfp.timeInterval);
		 List<Examination> result = new ArrayList<Examination>();
		 
		 for(Examination e: allExam) {
			 if(dfp.pharmacyId.equals(e.getPharmacy().getPharmacyId())) {
				 result.add(e);
			 }
		 }
		 
		 return result;
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(value = "/findAllScheduledExaminationInPharmacyByDermatologist/{dermatologistId}")
	public ResponseEntity<List<ExaminationDTO>> findAllScheduledExaminationInPharmacyByDermatologist(@PathVariable Long dermatologistId) {
		return new ResponseEntity<List<ExaminationDTO>>(_examinationService.findAllScheduledExaminationInPharmacyByDermatologist(dermatologistId), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@PostMapping(value = "/createFreeTermExamination")
	public ResponseEntity<ResponseFreeTermDTO> createFreeTermExaminationForDermatologist(@RequestBody CreateFreeTermDTO createFreeTermDTO) {
		try {
			return new ResponseEntity<ResponseFreeTermDTO>(_examinationService.createFreeTermExaminationForDermatologist(createFreeTermDTO), HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<ResponseFreeTermDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path = "/findAllFreeTerm")
	public ResponseEntity<List<PharmacyFreeTermDTO>> findAllFreeTermExamination() {
		return new ResponseEntity<List<PharmacyFreeTermDTO>>(_examinationService.findAllFreeTermExamination(), HttpStatus.OK);
	}
	
}
