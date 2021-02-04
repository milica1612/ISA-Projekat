package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IAddressService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.repository.IAddressRepository;

@Service
public class AddressService implements IAddressService{

	
	@Autowired
	private IAddressRepository _addressRepository;
	
	public Address findById(Long id) {
		return _addressRepository.findById(id).orElse(null);
	}

}
