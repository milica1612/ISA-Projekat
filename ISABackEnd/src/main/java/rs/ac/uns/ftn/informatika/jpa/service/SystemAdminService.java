package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.dto.UserDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.ISystemAdminService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.SystemAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.repository.ISystemAdminRepository;

@Service
public class SystemAdminService implements ISystemAdminService {
	
	@Autowired
	private ISystemAdminRepository _systemAdminRepository;
	
	@Autowired
	private AuthorityService _authorityService;

	@Autowired
	private PasswordEncoder _passwordEncoder;

	@Autowired
	private AddressService _addressService;
	
	
	@Override
	public User findById(Long id) {
		return _systemAdminRepository.findById(id).orElse(null);
	}
	
	@Override
	public User saveSystemAdmin(RegistrationRequest request) {
		Address a = new Address();
		
		SystemAdministrator sys_Admin = new SystemAdministrator();
		
		sys_Admin.setEmail(request.getEmail());
		sys_Admin.setPassword(_passwordEncoder.encode(request.getPassword()));
		sys_Admin.setFirstName(request.getFirstName());
		sys_Admin.setLastName(request.getLastName());

		sys_Admin.setPhoneNumber(request.getPhoneNumber());

		a = request.getAddress();
		sys_Admin.setAddress(a);
		this._addressService.createAddress(request.getAddress());
		sys_Admin.setUserType(UserType.SYS_ADMINISTRATOR);
		
		sys_Admin.setEnabled(true);
		sys_Admin.setFirstLogin(false);
		
		List<Authority> auth = _authorityService.findByName("ROLE_SYS_ADMIN");
		sys_Admin.setAuthorities(auth);
		
		this._systemAdminRepository.save(sys_Admin);
		return sys_Admin;	
	}

	@Override
	public User findByEmail(String email) {
		return _systemAdminRepository.findByEmail(email);
	}

	@Override
	public Pharmacy createPharmacy(PharmacyDTO pharmacy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User savePharmacyAdmin(RegistrationRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveDermatologist(RegistrationRequest request) {
		return null;
	}

	@Override
	public User saveSupplier(RegistrationRequest request) {
		Address a = new Address();
		
		Supplier supplier = new Supplier();
		
		supplier.setEmail(request.getEmail());
		supplier.setPassword(_passwordEncoder.encode(request.getPassword()));
		supplier.setFirstName(request.getFirstName());
		supplier.setLastName(request.getLastName());

		supplier.setPhoneNumber(request.getPhoneNumber());

		a = request.getAddress();
		supplier.setAddress(a);
		this._addressService.createAddress(request.getAddress());
		supplier.setUserType(UserType.SUPPLIER);
		
		supplier.setEnabled(true);
		supplier.setFirstLogin(false);
		
		List<Authority> auth = _authorityService.findByName("ROLE_SUPPLIER");
		supplier.setAuthorities(auth);
		
		this._systemAdminRepository.save(supplier);
		return supplier;	

	}

}
