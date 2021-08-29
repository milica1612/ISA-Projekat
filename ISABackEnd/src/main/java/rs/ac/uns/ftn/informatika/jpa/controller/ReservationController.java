package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationViewDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ReservationViewDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineItemService;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;
import rs.ac.uns.ftn.informatika.jpa.service.ReservationService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

	@Autowired
	private ReservationService _reservationService;

	@Autowired
	private PharmacyService _pharmacyService;
	
	@Autowired
	private EmailService _emailService;
	
	@Autowired
	private UserService _userService;
	
	@Autowired
	private MedicineItemService _medicineItemService;
	
	static class ResChecker {
		public String deadlineDate;
		public String resCode;
		public Long pharmacyId;
	}
	
	@PostMapping("create")
	public void createReservation(@RequestBody ReservationDTO dto) {
		User user = _userService.findById(dto.getUserId());
		Reservation reservation = _reservationService.createReservation(dto,(Patient) user);
		_medicineItemService.findMedicineItmeAndChangeQuantity(dto.getDto());
		_emailService.sendReservationMadeEmail(reservation);
	}
	
	@GetMapping(value = "/getByPatientId/{patientId}")
	public ArrayList<ReservationViewDTO> getByPatient(@PathVariable Long patientId){
		return _reservationService.getByPatient(patientId);
	}
	
	@PutMapping("/findReservation")
	public Reservation findReservationByCode(@RequestBody ResChecker resChecker) throws ParseException {
		
		Boolean reservationInPharmacy = false;
		Pharmacy pharmacy = new Pharmacy();
		Reservation r =  _reservationService.findReservationByCode(resChecker.resCode);
	
		
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date());               // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, 24); 
		
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resChecker.deadlineDate);
		
		if(!date.before(cal.getTime())) {
			reservationInPharmacy = false;	
		}
				
		else {
			pharmacy = _pharmacyService.findById(resChecker.pharmacyId);
			for (MedicineItem m: pharmacy.medicineItem) {
						if(m.equals(r.medicineItem)) {
							reservationInPharmacy = true;
						}
					}
		}
		
		if (r != null && reservationInPharmacy) {
			System.out.println(r);
			if(r.getRecieved() != true) {
				
				_emailService.sendRecievedMedicineEmail(r.getReservationCode(), pharmacy, r.getPatient());
				return _reservationService.updateReservation(r);
			}
			return new Reservation();
		}
		
		return new Reservation();
		
	}
	@PutMapping(value = "/cancel")
	public boolean cancelReservation(@RequestBody ReservationViewDTO reservation) {
		return _reservationService.cancelReservation(reservation);
	}
	
	@PutMapping(value = "/checkForPenalties/{patientId}")
	public void checkForPenalties(@PathVariable Long patientId) {
		int penatlties = _reservationService.checkForPenatlies(patientId);
		for (int i = 0; i < penatlties; i++) {
			_userService.increasePenalty(patientId);
		}
	}

}
