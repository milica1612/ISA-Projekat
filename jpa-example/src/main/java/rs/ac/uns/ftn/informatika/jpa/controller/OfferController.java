package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.OfferService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;

@RestController
@RequestMapping(value = "/offers")
public class OfferController {

	@Autowired
	private OfferService _offerService;
	
	@Autowired
	private UserService _userService;
	

	@GetMapping(path = "/seeOffers")
	public List<Offer> findOffers() {
		return  _offerService.findAll();
	}

	@GetMapping(path = "/filtrate/{status}/{id}")
	public List<Offer> filtrateOffers(@PathVariable Status status, @PathVariable Long id){
		
		List<Offer> offers = findOffers();
		User user = _userService.findById(id);
		
		List<Offer> filtrateOffers = new ArrayList<>();

		if(user.getUserId() == id) {
			for(Offer o : offers) {
				if(o.getStatus().equals(status)) {
					filtrateOffers.add(o);
					break;
				}
			}
		}
		return filtrateOffers; 
	}
}