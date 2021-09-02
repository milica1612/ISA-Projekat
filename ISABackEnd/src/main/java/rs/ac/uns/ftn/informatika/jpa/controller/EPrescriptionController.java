package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.service.EPrescriptionService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/ePrescription", produces = MediaType.APPLICATION_JSON_VALUE)
public class EPrescriptionController {

	@Autowired
	private EPrescriptionService _ePrescriptionService;
	
	@GetMapping(value = "/getByPatient/{patientId}")
	public ResponseEntity<?> getByPatiet(@PathVariable Long patientId){
		ArrayList<EPrescriptionDTO> result = _ePrescriptionService.getByPatient(patientId);
		return new ResponseEntity<ArrayList<EPrescriptionDTO>>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/filtrate/{patientId}/{status}")
	public ResponseEntity<?> filtrate(@PathVariable Long patientId, @PathVariable String status){
		ArrayList<EPrescriptionDTO> result = _ePrescriptionService.filtrate(status, patientId);
		return new ResponseEntity<ArrayList<EPrescriptionDTO>>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/issuedMedicine/{patientId}")
	public ResponseEntity<?> getIssuedMedicine(@PathVariable Long patientId){
		ArrayList<Medicine> result = _ePrescriptionService.getIssuedMedicine(patientId);
		return new ResponseEntity<ArrayList<Medicine>>(result, HttpStatus.OK);
	}
	
	
}
