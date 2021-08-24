package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacyAdminDTO;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyAdminService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/pharmacyAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
public class PharmacyAdminController {
	
	private PharmacyAdminService _pharmacyAdminService;
	
	@Autowired
	public PharmacyAdminController(PharmacyAdminService pharmacyAdminService) {
		this._pharmacyAdminService = pharmacyAdminService;
	}
	
	@GetMapping(path = "/{id}")
	public PharmacyAdminDTO findPharmacyAdminById(@PathVariable Long id) {
		return _pharmacyAdminService.getPharmacyAdminById(id);
	}
}
