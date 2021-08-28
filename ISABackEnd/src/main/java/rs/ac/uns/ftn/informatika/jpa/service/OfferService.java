package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.OfferDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OfferForOrderDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IOfferService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.OrderStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineItemRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IOfferRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IOrderRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class OfferService implements IOfferService {

	private IOfferRepository _offerRepository;

	private IOrderRepository _orderRepository;

	private IUserRepository _userRepository;

	private EmailService _emailService;
	
	private IPharmacyRepository _pharmacyRepository;

	// Example Of Constructor Dependency Injection in Spring
	@Autowired
	public OfferService(IOfferRepository offerRepository, EmailService emailService, IOrderRepository orderRepository, IUserRepository userRepository, IPharmacyRepository pharmacyRepository) {
		this._offerRepository = offerRepository;
		this._orderRepository = orderRepository;
		this._userRepository = userRepository;
		this._emailService = emailService;
		this._pharmacyRepository = pharmacyRepository;
	}


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
	public Boolean accept(Long offerId) {
		Offer offer = _offerRepository.getOne(offerId);
		Order order = offer.getOrder();

		List<Offer> allOffers = _offerRepository.findAll();
		List<Offer> declinedOffers = new ArrayList<Offer>();
		
		for (Offer o : allOffers) {
			if (order.getOrderId() == o.getOrder().getOrderId()) {
					if (o.getOfferId() != offer.getOfferId()) {
						o.setStatus(Status.DECLINED);
						_offerRepository.save(o);
						declinedOffers.add(o);							
					} 
				}
			}
		try {
			
			for(Offer dOffer : declinedOffers) {
				sendDeclinedOfferEmail(dOffer);
			}
			
			offer.setStatus(Status.ACCEPTED);
			if (sendAcceptedOfferEmail(offer))	
				_offerRepository.save(offer);	
			
			order.setOrderStatus(OrderStatus.FINISHED);
			_orderRepository.save(order);
			
			addMedicineItemsToPharmacy(order);
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private void addMedicineItemsToPharmacy(Order order) {
		Pharmacy pharmacy = order.getPharmacy();
		
		Set<MedicineItem> orderMedicineItems = order.getMedicineItem();
		
		Set<MedicineItem> pharmacyMedicineItems = pharmacy.getMedicineItem();
		
		List<MedicineItem> newMedicineItemsForPharmacy = new ArrayList<MedicineItem>();
		
		boolean isPharmacyHasMedicine;
		for (MedicineItem oMedicineItem : orderMedicineItems) {
			isPharmacyHasMedicine = false;
			for (MedicineItem pMedicineItem : pharmacyMedicineItems) {
				if(pMedicineItem.getMedicine().getMedicineId() == oMedicineItem.getMedicine().getMedicineId()) {
					isPharmacyHasMedicine = true;
					pMedicineItem.setQuantity(pMedicineItem.getQuantity() + oMedicineItem.getQuantity());
				}
			}
			if (!isPharmacyHasMedicine) {
				newMedicineItemsForPharmacy.add(oMedicineItem);
			}
		}
		
		for (MedicineItem m : newMedicineItemsForPharmacy) {
			pharmacyMedicineItems.add(m);
		}
		
		pharmacy.setMedicineItem(pharmacyMedicineItems);
		_pharmacyRepository.save(pharmacy);
	}


	private boolean sendAcceptedOfferEmail(Offer o) {
		try {
			_emailService.sendAcceptedOfferEmailAsync(o);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private void sendDeclinedOfferEmail(Offer o) {
		try {
			_emailService.sendDeclinedOfferEmailAsync(o);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<OfferForOrderDTO> findOffersByOrderId(Long orderId) {
		List<Offer> allOffers = _offerRepository.findAll();
		List<OfferForOrderDTO> list = new ArrayList<OfferForOrderDTO>();

		for (Offer offer : allOffers) {
			if (offer.getOrder().getOrderId() == orderId) {
				String deliveryDeadline = new SimpleDateFormat("dd.MM.yyyy.").format(offer.getDeliveryDeadline());
				OfferForOrderDTO offerForOrderDTO = new OfferForOrderDTO(offer.getOfferId(),
						offer.getSupplier().getFirstName() + " " + offer.getSupplier().getLastName(),
						offer.getSupplier().getEmail(), offer.getPrice(), deliveryDeadline, offer.getOrder().getPharmacyAdministrator().getUserId(), offer.getOrder().getOrderStatus());
				list.add(offerForOrderDTO);
			}
		}
		return list;
	}


	@Override
	public List<Offer> findOffersBySupplier(Long id) {

		List<Offer> offers = _offerRepository.findAll();
		Supplier supplier = new Supplier();

		List<Offer> offersBySupplier = new ArrayList<Offer>();

		for (Offer o : offers) {
			supplier.setUserId(o.getSupplier().getUserId());

			if (supplier.getUserId() == id) {
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
		
		if(supplier.getMedicineItem().isEmpty()) {
			System.out.println("empty");
			throw new IllegalArgumentException("There is no available medicine for order!");
		}
		
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
		
		Order order = _orderRepository.findById(offerDTO.getId()).orElse(null);	

		if(!checkMedicineAvailable(order, supplier)) {
			throw new IllegalArgumentException("There is no available medicine for order!");
		}
		
		if(order.getOfferDeadline().after(offerDTO.getDeliveryDeadline())) {
			throw new IllegalArgumentException("Date is passed!");
		}
		
		return true;
	}

}
