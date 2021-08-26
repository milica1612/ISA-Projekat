package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IConsultationService;
import rs.ac.uns.ftn.informatika.jpa.model.AppointmentStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.repository.IConsultationRepository;

@Service
public class ConsultationService implements IConsultationService{

	@Autowired 
	private IConsultationRepository _consultationRepository;

	@Override
	public ArrayList<Consultation> findAllConsultation() {
		return (ArrayList<Consultation>) _consultationRepository.findAll();
	}


	@Override
	public Consultation save(ConsultationDTO dto, Patient p) {
		String d = dto.getDate() + " " +  dto.getTime() + ":00";
	    Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
			System.out.println(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Consultation consultation = new Consultation();
		consultation.setAppointmentStatus(AppointmentStatus.NONE);
		consultation.setCancelled(false);
		consultation.setDateAndTime(date);
		consultation.setPharmacist(dto.getPharmacist());
		consultation.setPatient(p);
		consultation.setPrice(dto.getPharmacist().getPharmacy().getConsultationPrice());
		consultation.setPharmacy(dto.getPharmacist().getPharmacy());
		consultation.setDuration(30);
		return this._consultationRepository.save(consultation);
		
	}
}
