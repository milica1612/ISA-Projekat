package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Offer;

@Service
public interface IOfferService {

	List<Offer> findAll();
	
	Offer save(Offer offer);
}
