package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import rs.ac.uns.ftn.informatika.jpa.dto.OfferDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IOfferService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
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

	@Override
	public void createOffer(OfferDTO offerDTO, Order order, Supplier supplier) {
		Offer offer = new Offer();
		
		if(order.getOfferDeadline().after(new Date())) {
			if(checkOffer(order, supplier)) {
				offer.setPrice(offerDTO.getFinalPrice());
				offer.setDeliveryDeadline(offerDTO.getDeliveryDeadline());
			}
		}
		_offerRepository.save(offer);
	}

	@Override
	public Boolean checkOffer(Order order, Supplier supplier) {
		List<MedicineItem> mitem = (List<MedicineItem>) supplier.getMedicineItem();
		
		MedicineItem medicineItem = (MedicineItem) order.getMedicineItem();
		
		if(mitem.isEmpty()) {
			return false;
		}
		List<MedicineItem> medicineForOrder = new ArrayList<>();
		
		for(MedicineItem m : mitem) {
			if(!(m.getMedicine().equals(order.getMedicineItem()))) {
				if(m.getQuantity() < medicineItem.getQuantity()) {
					return false;
				}
			}
		medicineForOrder.add(m);
		}
		return true;

	}

}
