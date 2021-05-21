
package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.AppointmentTimeDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IAppointmentService;
import rs.ac.uns.ftn.informatika.jpa.model.Appointment;
import rs.ac.uns.ftn.informatika.jpa.model.AppointmentStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.IAppointmentRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentRepository _appointmentRepository;
	

	@Override
	public List<AppointmentTimeDTO> getAllAppointments() {
        List<Appointment> appointments = _appointmentRepository.findAll();
        List<Appointment> appointmentsList = new ArrayList<>();
        for (Appointment a : appointments) {
        	if(a.getAppointmentStatus().equals(AppointmentStatus.NONE) && (a.getPatient() == null))
				appointmentsList.add(a);
        }
        List<AppointmentTimeDTO> dtos = new ArrayList<>();
        appointmentsList.stream().forEach(appointment -> dtos.add(new AppointmentTimeDTO(appointment.getDateAndTime(), appointment.getDuration())));      
        return dtos;
	}


	@Override
	public void chooseAppointmentDerm(Appointment a) {
			
		if(a.getAppointmentStatus().equals(AppointmentStatus.STARTED)) {
			//a.setPatient(p);
		}
		
		_appointmentRepository.save(a);
	}


	@Override
	public Appointment save(Appointment a) {
		
		return _appointmentRepository.save(a);
	}
	
}
