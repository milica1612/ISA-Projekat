package rs.ac.uns.ftn.informatika.jpa.iservice;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;

@Service
public interface IContraindicationService {

	public Contraindication findById(Long id);
	
	public Contraindication save(Contraindication contraindication);
	
}
