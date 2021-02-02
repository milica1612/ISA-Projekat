package rs.ac.uns.isaprojekat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import rs.ac.uns.isaprojekat.model.Address;
import rs.ac.uns.isaprojekat.repository.IAddressRepository;

@Service
public class AddressService {

	@Autowired
	private IAddressRepository addressRepository;
	
	public Page<Address> findAll(Pageable page) {
		return addressRepository.findAll(page);
	}	
}
