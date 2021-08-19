package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.OfferDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Order;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.OfferService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/offers")
public class OfferController {

	@Autowired
	private OfferService _offerService;
	
	@Autowired
	private UserService _userService;
	
	@GetMapping(path = "/seeOffers/{id}")
	public List<Offer> findOffers(@PathVariable Long id) {
		return  _offerService.findOffersBySupplier(id);
	}

	@GetMapping(path = "/filtrate/{status}/{id}")
	public List<Offer> filtrateOffers(@PathVariable Status status, @PathVariable Long id){
		
		List<Offer> offers = findOffers(id);
		User user = _userService.findById(id);
		
		List<Offer> filtrateOffers = new ArrayList<>();

		if(user.getUserId() == id) {
			for(Offer o : offers) {
				if(o.getStatus().equals(status)) {
					filtrateOffers.add(o);
				}
			}
		}
		return filtrateOffers; 
	}
	
	@PutMapping(value = "createOffer/{id}/{order_id}")
	public ResponseEntity<?> createOffer(@RequestBody OfferDTO offerDTO, Order order){
		try {
			_offerService.createOffer(offerDTO, null);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}