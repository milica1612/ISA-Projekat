package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintEmployeeDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.service.ComplaintService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/complaint", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComplaintEmployeeController {

	@Autowired
	public ComplaintService _complaintService;
	
	@PostMapping("/createComplaint")
	public ResponseEntity<?> createComplaint(@RequestBody ComplaintEmployeeDTO complaintEmployeeDTO, UriComponentsBuilder ucBuilder) {
		try {
			return new ResponseEntity<>(this._complaintService.createComplaint(complaintEmployeeDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/createComplaintForPharmacy")
	public ResponseEntity<?> createComplaintForPharmacy(@RequestBody ComplaintPharmacyDTO complaintPharmacyDTO, UriComponentsBuilder ucBuilder) {
		try {
			return new ResponseEntity<>(this._complaintService.createComplaintForPharmacy(complaintPharmacyDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
		}
	}
	
}
