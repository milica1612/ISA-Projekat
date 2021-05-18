package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IOfferService;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.repository.IOfferRepository;

@Service
public class OfferService implements IOfferService{

	@Autowired
	private IOfferRepository _offerRepository;
	
	@Override
	public Offer findById(Long id) {
		return _offerRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Offer> findAll() {		
		List<Offer> listOffer = _offerRepository.findAll();
		return listOffer;
	}
	
	@Override
	public Offer save(Offer offer) {
		return _offerRepository.save(offer);
	}

	@Override
	public List<Offer> findOffersBySupplier(Long id) {

		List<Offer> offers = _offerRepository.findAll();
		Supplier supplier = new Supplier();
		
		List<Offer> offersBySupplier = new ArrayList<Offer>();
	
		for(Offer o : offers) {
			supplier.setUserId(o.getSupplier().getUserId());
			
			if(supplier.getUserId() == id) {
				offersBySupplier.add(o);
				
			}
		}
		return offersBySupplier;		
	}


	

}
