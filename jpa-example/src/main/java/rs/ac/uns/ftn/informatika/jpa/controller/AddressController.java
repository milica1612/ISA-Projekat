package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.service.AddressService;
import rs.ac.uns.ftn.informatika.jpa.service.UserService;


@RestController
@RequestMapping(value = "address")
public class AddressController {

	

	@Autowired
	private AddressService _addressService ;
	

	@GetMapping(value = "/{id}")
	public Address getAddressId(@PathVariable Long id) {
		return (Address) _addressService.findById(id);
	}

}
