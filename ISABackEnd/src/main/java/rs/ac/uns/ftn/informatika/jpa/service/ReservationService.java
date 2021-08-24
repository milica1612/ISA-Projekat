package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IReservationService;
import rs.ac.uns.ftn.informatika.jpa.model.Reservation;
import rs.ac.uns.ftn.informatika.jpa.repository.IReservationRepository;

@Service
public class ReservationService implements IReservationService{

	@Autowired
	private IReservationRepository _reservationRepository;
	
	@Override
	public Reservation updateReservation(@Valid Reservation r) {
		
		Reservation reservation = _reservationRepository.findById(r.getReservationId()).orElse(null);
		reservation.setRecieved(true);
		this._reservationRepository.save(reservation);
		return reservation;
	}
	
	@Override
	public Reservation findReservationByCode(String code) {
		
		List<Reservation> reservations = _reservationRepository.findAll();
		
		for (Reservation r: reservations) {
			if (r.getReservationCode().equals(code)) {
				
				return updateReservation(r);
			}
		}
		
		return null;
	}
}
