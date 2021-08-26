package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import rs.ac.uns.ftn.informatika.jpa.dto.OfferDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IOfferService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.repository.IOfferRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IOrderRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class OfferService implements IOfferService{

	@Autowired
	private IOfferRepository _offerRepository;

	@Autowired
	private IOrderRepository _orderRepository;

	@Autowired
	private IUserRepository _userRepository;
	
	@Override
	public Offer findById(Long id) {
		
		return _offerRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Offer> findAll() {		
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		
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

	public User getCurrentLoggedUser() {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(currentUser);

		
		User user = (User) currentUser.getPrincipal();		
		return user;
	}
	
	@Override
	public void createOffer(Long order_id, OfferDTO offerDTO) {
		Offer offer = new Offer();
		
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		
		User user = (User) currentUser.getPrincipal();
		Supplier supplier = (Supplier) _userRepository.findById(user.getUserId()).get();
				
		Order order = _orderRepository.findById(offerDTO.getId()).orElse(null);
		
		System.out.println(supplier.getEmail());
		
		if(checkOffer(offerDTO, supplier)) {
			offer.setPrice(offerDTO.getFinalPrice());
			offer.setDeliveryDeadline(offerDTO.getDeliveryDeadline());
			offer.setStatus(Status.WAITING);
			offer.setSupplier(supplier);
			offer.setOrder(order);
		}
		
		_offerRepository.save(offer);
	}

	@Override
	public Boolean checkMedicineAvailable(Order order, Supplier supplier) {
		System.out.println("medicine available");
		Set<MedicineItem> medicineItems = order.getMedicineItem();
		
		Set<MedicineItem> supplierMedItem = supplier.getMedicineItem();
		
		/*if(supplier.getMedicineItem().isEmpty()) {
			System.out.println("empty");
			throw new IllegalArgumentException("There is no available medicine for order!");
		}*/
		
		List<MedicineItem> medicineForOrder = new ArrayList<>();
		
		for(MedicineItem m: medicineItems) {
			if(medicineItems.equals(supplierMedItem)) {
					medicineForOrder.add(m);
			}
		}
		return true;
	}

	@Override
	public Boolean checkOffer(OfferDTO offerDTO, Supplier supplier) {
		System.out.println("check offer");
		
		System.out.println(offerDTO.getId());
		Order order = _orderRepository.findById(offerDTO.getId()).orElse(null);
		

		System.out.println("aaa");
		if(!checkMedicineAvailable(order, supplier)) {
			throw new IllegalArgumentException("There is no available medicine for order!");
		}
		
		if(order.getOfferDeadline().after(offerDTO.getDeliveryDeadline())) {
			throw new IllegalArgumentException("Date is passed!");
		}
		
		return true;
	}

}
