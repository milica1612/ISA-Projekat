package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.service.EmailService;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;
import rs.ac.uns.ftn.informatika.jpa.service.ReservationService;

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
	
	static class ResChecker {
		public String deadlineDate;
		public String resCode;
		public Long pharmacyId;
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

}
