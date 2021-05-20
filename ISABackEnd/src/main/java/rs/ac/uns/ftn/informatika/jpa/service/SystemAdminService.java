package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.iservice.ISystemAdminService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.repository.IDermatologistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.ISupplierRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.ISystemAdminRepository;

@Service
public class SystemAdminService implements ISystemAdminService{
	
		@Autowired
	    private AuthorityService authorityService;

		@Autowired
		private PasswordEncoder _passwordEncoder;
		
	    @Autowired
	    private IPharmacistRepository pharmacistRepository;

	    @Autowired
	    private IDermatologistRepository dermatologistRepository;
	    
	    @Autowired
	    private ISupplierRepository supplierRepository;

	    @Autowired
	    private ISystemAdminRepository systemAdminRepository;

		@Override
		public User createPharmacist(RegistrationRequest request) {

			Address address = new Address();
			address.setStreet(request.getStreet());
			address.setStreetNumber(request.getStreetNumber());
			address.setCity(request.getCity());
			address.setCountry(request.getCountry());
			address.setLatitude(null);
			address.setLongitude(null);
			
			Pharmacist p = new Pharmacist();
			p.setAddress(address);
			p.setFirstName(request.getFirstName());
			p.setLastName(request.getLastName());
			p.setEmail(request.getEmail());
			p.setPassword(_passwordEncoder.encode(request.getPassword()));
			p.setPhoneNumber(request.getPhoneNumber());
			p.setUserType(UserType.PHARMACIST);
			
			p.setEnabled(true);
			List<Authority> auth = authorityService.findByName("PHARMACIST");
			p.setAuthorities(auth);
			return pharmacistRepository.save(p);
		}

		@Override
		public User createSupplier(RegistrationRequest request) {

			Address address = new Address();
			address.setStreet(request.getStreet());
			address.setStreetNumber(request.getStreetNumber());
			address.setCity(request.getCity());
			address.setCountry(request.getCountry());
			address.setLatitude(null);
			address.setLongitude(null);
			
			Supplier s = new Supplier();
			s.setAddress(address);
			s.setFirstName(request.getFirstName());
			s.setLastName(request.getLastName());
			s.setEmail(request.getEmail());
			s.setPassword(_passwordEncoder.encode(request.getPassword()));
			s.setPhoneNumber(request.getPhoneNumber());
			s.setUserType(UserType.SUPPLIER);
			
			s.setEnabled(true);
			List<Authority> auth = authorityService.findByName("SUPPLIER");
			s.setAuthorities(auth);
			return supplierRepository.save(s);
		}

		@Override
		public User createDermatologist(RegistrationRequest request) {

			Address address = new Address();
			address.setStreet(request.getStreet());
			address.setStreetNumber(request.getStreetNumber());
			address.setCity(request.getCity());
			address.setCountry(request.getCountry());
			address.setLatitude(null);
			address.setLongitude(null);
			
			Dermatologist d = new Dermatologist();
			d.setAddress(address);
			d.setFirstName(request.getFirstName());
			d.setLastName(request.getLastName());
			d.setEmail(request.getEmail());
			d.setPassword(_passwordEncoder.encode(request.getPassword()));
			d.setPhoneNumber(request.getPhoneNumber());
			d.setUserType(UserType.DERMATOLOGIST);
			
			d.setEnabled(true);
			List<Authority> auth = authorityService.findByName("DERMATOLOGIST");
			d.setAuthorities(auth);
			return dermatologistRepository.save(d);
		}

	    

}
