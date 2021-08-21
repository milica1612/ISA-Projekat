package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.service.ExaminationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/examination")
public class ExaminationContoller {
	@Autowired
	ExaminationService _examinationService;
	
	@GetMapping(value = "/getByPharmacy/{pharmacyId}")
	public ArrayList<ExaminationDTO> getByPharmacy(@PathVariable Long pharmacyId){
		return _examinationService.getByPharmacy(pharmacyId);
	}
	
	@GetMapping(value = "/getByPatientId/{patientId}")
	public ArrayList<ExaminationDTO> getByPatient(@PathVariable Long patientId){
		return _examinationService.getByPatient(patientId);
	}
	
	@PutMapping(value = "/schedule")
	public void scheduleExamination(@RequestBody ExaminationDTO examination) {
		_examinationService.scheduleExamination(examination);
	}
	
	@PutMapping(value = "/cancel")
	public boolean cancelExamination(@RequestBody ExaminationDTO examination) {
		return _examinationService.cancelExamination(examination);
	}
}
