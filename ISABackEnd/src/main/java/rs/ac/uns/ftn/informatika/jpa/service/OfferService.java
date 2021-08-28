package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.OfferDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.OfferForOrderDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IOfferService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.repository.IOfferRepository;

@Service
public class OfferService implements IOfferService {

	private IOfferRepository _offerRepository;

	private EmailService _emailService;

	// Example Of Constructor Dependency Injection in Spring
	@Autowired
	public OfferService(IOfferRepository offerRepository, EmailService emailService) {
		this._offerRepository = offerRepository;
		this._emailService = emailService;
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
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
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
						offer.getSupplier().getEmail(), offer.getPrice(), deliveryDeadline);
				list.add(offerForOrderDTO);
			}
		}
		return list;
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

		for (Offer o : offers) {
			supplier.setUserId(o.getSupplier().getUserId());

			if (supplier.getUserId() == id) {
				offersBySupplier.add(o);
			}
		}
		return offersBySupplier;
	}

	@Override
	public void createOffer(OfferDTO offerDTO, Order order) {
		Offer offer = new Offer();

		Supplier supplier = (Supplier) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(supplier.getEmail());

		if (order.getOfferDeadline().after(new Date())) {
			if (checkOffer(order, supplier)) {
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

		if (mitem.isEmpty()) {
			return false;
		}
		List<MedicineItem> medicineForOrder = new ArrayList<>();

		for (MedicineItem m : mitem) {
			if (!(m.getMedicine().equals(order.getMedicineItem()))) {
				if (m.getQuantity() < medicineItem.getQuantity()) {
					return false;
				}
			}
			medicineForOrder.add(m);
		}
		return true;

	}

}
