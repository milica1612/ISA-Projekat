package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IAppointmentService;
import rs.ac.uns.ftn.informatika.jpa.model.Appointment;
import rs.ac.uns.ftn.informatika.jpa.repository.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService{
	@Autowired
	private IAppointmentRepository _appointmentRepository;

	@Override
	public ArrayList<Appointment> getAppointmentsByPharmacy(Long pharmacyId) {
		ArrayList<Appointment> allAppointments = (ArrayList<Appointment>) _appointmentRepository.findAll();
		return allAppointments;
	}
	
}
