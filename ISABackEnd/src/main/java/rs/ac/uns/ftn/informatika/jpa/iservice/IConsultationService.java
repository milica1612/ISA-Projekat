package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Consultation;


@Service
public interface IConsultationService {

	ArrayList<Consultation> findAllConsultation();

}
