package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IConsultationService;
import rs.ac.uns.ftn.informatika.jpa.repository.IConsultationRepository;

@Service
public class ConsultationService implements IConsultationService{

	@Autowired 
	private IConsultationRepository _conConsultationRepository;
}
