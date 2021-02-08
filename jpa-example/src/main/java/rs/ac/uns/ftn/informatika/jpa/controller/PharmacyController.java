package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.model.Address;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.UserType;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;

@RestController
@RequestMapping(value = "pharmacy")
public class PharmacyController {
	
	@Autowired
	private PharmacyService _pharmacyService;

	@GetMapping(value = "/{id}")
	public Pharmacy getPharmacy(@PathVariable Long id) {
		return (Pharmacy) _pharmacyService.findById(id);
	}
	

	@PostMapping(value = "/createPharmacy")
	public ResponseEntity<Pharmacy> createPharmacy(@RequestBody Pharmacy pharmacy){
		
		if(pharmacy == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Pharmacy _pharmacy = new Pharmacy();
		
		_pharmacy.setName(pharmacy.getName());
		_pharmacy.setRating(pharmacy.getRating());
		_pharmacy.setDermatologist(pharmacy.getDermatologist());
		_pharmacy.setMedicineItem(pharmacy.getMedicineItem());
		_pharmacy.setPharmacist(pharmacy.getPharmacist());
	
		_pharmacy = (Pharmacy) _pharmacyService.save(_pharmacy);	
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}


	@GetMapping(value = "/newPharmacy")
	public Pharmacy getNewPharmacy() {
						
		String name = "";
		Double rating = 0.0;
		return new Pharmacy(name, rating);
	}
}
