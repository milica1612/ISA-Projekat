package rs.ac.uns.ftn.informatika.jpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import rs.ac.uns.ftn.informatika.jpa.service.MedicineItemService;
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
	
	static class ResChecker {
		public String deadlineDate;
		public String resCode;
		public Long pharmacyId;
	}
	
	@PutMapping(value = "/findReservation")
	public Reservation findReservationByCode(@RequestBody ResChecker resChecker) throws ParseException {
		
		Reservation r = _reservationService.findReservationByCode(resChecker.resCode);
		System.out.println(r);
		Boolean reservationInPharmacy = false;
		
	/*	Pharmacy pharmacy = _pharmacyService.findById(resChecker.pharmacyId);
		for (MedicineItem m: pharmacy.medicineItem) {
			if(r.medicineItem.equals(m)) {
				reservationInPharmacy = true;
			}
		}
		*/
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date());               // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, 24);      
		
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resChecker.deadlineDate);
		
		
		if (r == null || date.before(cal.getTime()) || reservationInPharmacy) {
			//System.out.println(r + "+++++ " + date + " " + pharmacy.getPharmacyId());
			return null;
		}
		
		return r;
	}

}
