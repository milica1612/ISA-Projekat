package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacyAdminService;
import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.repository.IAddressRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyAdminRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class PharmacyAdminService implements IPharmacyAdminService{
	

	private IPharmacyAdminRepository _pharmacyAdminRepository;
	
	private IAddressRepository _addressRepository;
	
	private IPharmacyRepository _pharmacyRepository;
	
	@Autowired
	public PharmacyAdminService(IPharmacyAdminRepository iPharmacyAdminRepository, IAddressRepository iAddressRepository, IPharmacyRepository iPharmacyRepository) {
		this._pharmacyAdminRepository = iPharmacyAdminRepository;
		this._addressRepository = iAddressRepository;
		this._pharmacyRepository = iPharmacyRepository;
	}	

	@Override
	public PharmacyAdminDTO getPharmacyAdminById(Long id) {
		
		PharmacyAdministrator pAdmin = _pharmacyAdminRepository.findByUserId(id);
		
		Address pAdminAddress = _addressRepository.getOne(pAdmin.getAddress().getAddressId());
		
		Pharmacy pAdminPharmacy = _pharmacyRepository.getOne(pAdmin.getPharmacy().getPharmacyId());
		
		PharmacyAdminDTO phAdminDTO = new PharmacyAdminDTO(pAdmin.getEmail(), pAdmin.getFirstName(), pAdmin.getLastName(), pAdmin.getPhoneNumber(), pAdminAddress.getStreet(), pAdminAddress.getStreetNumber(), pAdminAddress.getCity(), pAdminAddress.getCountry(), pAdminPharmacy.getName());
		
		return phAdminDTO;
	}

}
