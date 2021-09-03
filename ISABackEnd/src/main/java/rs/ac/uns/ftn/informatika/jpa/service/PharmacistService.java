package rs.ac.uns.ftn.informatika.jpa.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.CreatePharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyPharmacistDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacistService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacistRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class PharmacistService implements IPharmacistService{

	private IPharmacistRepository _pharmacistRepository;
	private AuthorityService _authorityService;
	private AddressService _addressService;
	private IPharmacyRepository _pharmacyRepository;
	private IUserRepository _userRepository;
	
	@Autowired
	public PharmacistService(IPharmacistRepository pharmacistRepository, AuthorityService authorityService, AddressService addressService, IPharmacyRepository pharmacyRepository, IUserRepository userRepository) {
		this._pharmacistRepository = pharmacistRepository;
		this._authorityService = authorityService;
		this._addressService = addressService;
		this._pharmacyRepository = pharmacyRepository;
		this._userRepository = userRepository;
	}

	@Override
	public List<PharmacistDTO> getAllPharmacist() {
		return _pharmacistRepository.findAll().stream()
				.map(p-> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<PharmacistDTO> searchPharmacistsByFirstName(String firstName) {
		return _pharmacistRepository.findAllByFirstName(firstName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());

	}
	
	@Override
	public List<PharmacistDTO> searchPharmacistsByLastName(String lastName) {
		return _pharmacistRepository.findAllByLastName(lastName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public List<PharmacistDTO> searchPharmacist(String firstName, String lastName) {
		return _pharmacistRepository.findAllByFirstNameAndLastName(firstName, lastName).stream()
				.map(p -> new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()))
				.collect(Collectors.toList());
		
	}
	
	@Override
	public List<PharmacistDTO> findPharmacistsByPharmacy(Long pharmacyId) {
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
	
		for (Pharmacist p : pharmacists)
			if (p.getPharmacy().getPharmacyId() == pharmacyId)
				pharmacistDTOs.add(new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	}
	
	@Override
	public List<PharmacistDTO> filterPharmacistByRating(Double minRating, Double maxRating) {
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacistDTO> pharmacistDTOs = new ArrayList<PharmacistDTO>();
		
		for (Pharmacist p : pharmacists)
			if (p.getRating() >= minRating && p.getRating() <= maxRating)
				pharmacistDTOs.add(new PharmacistDTO(p.getFirstName(), p.getLastName(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	
	}

	@Override
	public void updateRating(Long userId, Double newRating) {
		Pharmacist existing = _pharmacistRepository.findById(userId).orElse(null);
		if(existing!= null) {
			existing.setRating(newRating);
			_pharmacistRepository.save(existing);
		}
		
		
	}

	@Override
	public List<PharmacyPharmacistDTO> getPharmacistsByPharmacy() {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		List<Pharmacist> pharmacists = _pharmacistRepository.findAll();
		List<PharmacyPharmacistDTO> pharmacistDTOs = new ArrayList<PharmacyPharmacistDTO>();
	
		for (Pharmacist p : pharmacists)
			if (p.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId())
				pharmacistDTOs.add(new PharmacyPharmacistDTO(p.getUserId(), p.getFirstName(), p.getLastName(), p.getPhoneNumber(), p.getEmail(), p.getAddress().getStreet(), p.getAddress().getStreetNumber(), p.getAddress().getCity(), p.getRating(), p.getPharmacy().getName()));
		
		return pharmacistDTOs;
	}
	
	@Override
	public Pharmacist createPharmacistByPharmacyAdmin(CreatePharmacistDTO createPharmacistDTO) {
		Pharmacy pharmacy = _pharmacyRepository.getOne(createPharmacistDTO.getPharmacyId());
		User findUser = _userRepository.findByEmail(createPharmacistDTO.getEmail()); 
		if (findUser != null) {
			return null;
		}
		Pharmacist newPharmacist = new Pharmacist();
		Address pharmacistAddress = new Address();
		pharmacistAddress = createPharmacistDTO.getAddress();
		newPharmacist.setAddress(pharmacistAddress);
		this._addressService.createAddress(pharmacistAddress);
		newPharmacist.setEnabled(true);
		newPharmacist.setFirstLogin(false);
		newPharmacist.setFirstName(createPharmacistDTO.getFirstName());
		newPharmacist.setLastName(createPharmacistDTO.getFirstName());
		newPharmacist.setEmail(createPharmacistDTO.getEmail());
		newPharmacist.setUserType(UserType.PHARMACIST);
		byte[] salt = generateSalt();
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		newPharmacist.setSalt(encodedSalt);
		String rawPassword = generatePasswordWithSalt(createPharmacistDTO.getPassword(), encodedSalt); 
		String securePassword = hashPassword(rawPassword);
		newPharmacist.setPassword(securePassword);
		newPharmacist.setPhoneNumber(createPharmacistDTO.getPhoneNumber());
		List<Authority> authorities = _authorityService.findByName("ROLE_PHARMACIST");
		newPharmacist.setAuthorities(authorities);
		// newPharmacist.setPharmacy(pharmacy);
		return _pharmacistRepository.save(newPharmacist);
	}
	
	private static byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] genSalt = new byte[16];
		random.nextBytes(genSalt);
		return genSalt;
	}
	
	private String generatePasswordWithSalt(String userPassword, String salt) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(userPassword);
		stringBuilder.append(salt);
		return stringBuilder.toString();
	}
	
	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	

}
