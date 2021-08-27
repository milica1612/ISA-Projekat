package rs.ac.uns.ftn.informatika.jpa.service;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ReservationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IReservationService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineItemRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IReservationRepository;

@Service
public class ReservationService implements IReservationService{

	@Autowired
	private IReservationRepository _reservationRepository;
	
	@Autowired
	private IMedicineItemRepository _medicineItemRepository;
	
	@Override
	public Reservation updateReservation(@Valid Reservation r) {
		
		Reservation reservation = _reservationRepository.findById(r.getReservationId()).orElse(null);
		reservation.setRecieved(true);
		this._reservationRepository.save(reservation);
		return reservation;
	}
	
	@Override
	public Reservation findReservationByCode(String code) {
		System.out.println("**********************************");
		List<Reservation> reservations = _reservationRepository.findAll();
		
		for (Reservation r: reservations) {
			if (r.getReservationCode().equals(code)) {
				System.out.println(code);
				return r;
			}
		}	
		return null;
	}

	@Override
	public void createReservation(ReservationDTO dto, Patient p) {
		String d = dto.getDate();
	    Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
			System.out.println(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    String generatedString = givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect();
	    MedicineItem item = new MedicineItem(1, dto.getDto().getPriceTag().getMedicine());
		Reservation reservation = new Reservation(date, generatedString, false, p, item);
		System.out.println(generatedString + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++/n");
		_medicineItemRepository.save(item);
		_reservationRepository.save(reservation);
		
	}
	
	public String givenUsingJava8_whenGeneratingRandomAlphanumericString_thenCorrect() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
}
