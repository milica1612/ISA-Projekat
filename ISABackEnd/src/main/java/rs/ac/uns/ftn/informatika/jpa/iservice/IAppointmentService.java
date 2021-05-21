package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.AppointmentTimeDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Appointment;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;


public interface IAppointmentService {

	List<AppointmentTimeDTO> getAllAppointments();
	
	void chooseAppointmentDerm(Appointment a);

	Appointment save(Appointment a);
}
