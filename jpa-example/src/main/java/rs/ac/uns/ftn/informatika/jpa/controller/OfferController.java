package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.service.OfferService;

@RestController
@RequestMapping(value = "/offers")
public class OfferController {

	@Autowired
	private OfferService _offerService;


	@GetMapping(path = "/seeOffers")
	public List<Offer> findOffers() {
		return  _offerService.findAll();
	}
	
}
