package rs.ac.uns.isaprojekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.isaprojekat.services.AddressService;

@RestController
@RequestMapping(value = "/")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
}
