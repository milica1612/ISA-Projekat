package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.util.UriComponentsBuilder;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyRegisterDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyReport;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.service.ConsultationService;
import rs.ac.uns.ftn.informatika.jpa.service.EPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.service.ExaminationService;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;
import rs.ac.uns.ftn.informatika.jpa.service.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/pharmacy", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyController {
	
	@Autowired
	private PharmacyService _pharmacyService;
	
	@Autowired
	private ReservationService _reservationService;
	
	@Autowired
	private EPrescriptionService _ePrescriptionService;
	
	@Autowired
	private ConsultationService _consultationService;
	
	@Autowired
	private ExaminationService _examinationService;
	
	@Autowired
	private IPharmacyRepository _pharmacyRepository;
	
	static class PharmDTO {
		public ArrayList<Pharmacy> pharmacies;
	}
	
	@GetMapping(value = "")
	public ArrayList<Pharmacy> getAllPharmacies() {
		System.out.println("All Pharmacies");
		return _pharmacyService.findAllPharmacy();
	}
	

	@GetMapping(value = "/getPharmacyForPatient/{user_id}")
	public List<Pharmacy> getPharmacyForPatient(@PathVariable Long user_id){
		return _pharmacyService.getSubscribedPharmacyForPatient(user_id);
	}
	
	@PreAuthorize("hasRole('ROLE_PH_ADMIN')")
	@GetMapping(path = "/getPharmacyById/{pharmacyId}")
	public PharmacyDTO getPharmacyById(@PathVariable Long pharmacyId) {
		return  _pharmacyService.getPharmacyById(pharmacyId);
	}

	@PutMapping(value = "/filtrateByRating/{rating}")
	public ArrayList<Pharmacy> filtratePharmaciesByRating(@PathVariable Long rating, @RequestBody PharmDTO dto){
		return _pharmacyService.filtratePharmaciesByRating(rating, dto.pharmacies);
	}
	
	@GetMapping(value = "/getByNameOrAddress/{parametar}")
	public ArrayList<Pharmacy> getPharmacyByNameOrAddress(@PathVariable String parametar) {
		return _pharmacyService.getPharmacyByNameOrAddress(parametar);
	}
	
	@GetMapping(value = "/{id}")
	public Pharmacy getPharmacy(@PathVariable Long id) {
		return _pharmacyService.findById(id);
	}

	@PostMapping(value = "/createPharmacy")
	@PreAuthorize("hasRole('ROLE_SUPPLIER')")
	public ResponseEntity<Pharmacy> createPharmacy(@RequestBody Pharmacy pharmacy){
		
		if(pharmacy == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Pharmacy _pharmacy = new Pharmacy();
		
		_pharmacy.setName(pharmacy.getName());
		_pharmacy.setRating(pharmacy.getRating());
		_pharmacy.setMedicineItem(pharmacy.getMedicineItem());
	
		_pharmacy = (Pharmacy) _pharmacyRepository.save(_pharmacy);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping(value = "/getPharmaciesForPatient/{patientId}")
	public ArrayList<Pharmacy> getPharmaciesForPatient(@PathVariable Long patientId){
		ArrayList<Pharmacy> result = new ArrayList<Pharmacy>();
		_reservationService.getPharmaciesForPatient(patientId, result);
		_ePrescriptionService.getPharmaciesForPatient(patientId, result);
		_consultationService.getPharmaciesForPatient(patientId, result);
		_examinationService.getPharmaciesForPatient(patientId, result);
		
		return result;
	}

	@PostMapping("/createPharmacy")
	public ResponseEntity<?> createPharmacy(@RequestBody PharmacyRegisterDTO pharmacyRequest, UriComponentsBuilder ucBuilder) {
		try {
	
		  return new ResponseEntity<>(this._pharmacyService.createPharmacy(pharmacyRequest), HttpStatus.CREATED);
		} catch (Exception e) { 
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllPharmacyByDermatologist/{id}")
	public ArrayList<Pharmacy> getAllByDermatologist(@PathVariable Long id){
		return _pharmacyService.getAllByDermatologist(id);
	}
	
}
