package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;


import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;

@Service
public interface IConsultationService {
	 Consultation save(ConsultationDTO dto, Patient p);
	 ArrayList<Consultation> findAllConsultation();
	 Consultation saveConsultation(Consultation consultation);
	 ArrayList<Consultation> getConsultationsByPatient(Long patientId);
}
