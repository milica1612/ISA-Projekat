package rs.ac.uns.ftn.informatika.jpa.iservice;


import rs.ac.uns.ftn.informatika.jpa.model.Reservation;

public interface IReservationService {
	
	public Reservation findReservationByCode(String code);

	public Reservation updateReservation(Reservation r);
}