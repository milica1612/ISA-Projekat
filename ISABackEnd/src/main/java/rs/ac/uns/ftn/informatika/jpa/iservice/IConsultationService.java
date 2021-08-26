package rs.ac.uns.ftn.informatika.jpa.iservice;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;

@Service
public interface IConsultationService {
	 void save(ConsultationDTO dto, Patient p);
}
