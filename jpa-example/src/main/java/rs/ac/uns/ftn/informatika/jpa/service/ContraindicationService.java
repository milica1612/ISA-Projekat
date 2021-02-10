package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IContraindicationService;
import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.repository.IContraindicationRepository;

@Service
public class ContraindicationService implements IContraindicationService{

	@Autowired
	private IContraindicationRepository _contraindicationRepository; 
	
	@Override
	public Contraindication findById(Long id) {
		return _contraindicationRepository.findById(id).orElse(null);
	}

	@Override
	public Contraindication save(Contraindication contraindication) {
		return _contraindicationRepository.save(contraindication);
	}

}
