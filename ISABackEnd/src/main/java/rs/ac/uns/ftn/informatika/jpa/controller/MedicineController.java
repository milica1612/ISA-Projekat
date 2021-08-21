package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRegistrationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineService _medicineService ;
	
	@GetMapping(value = "")
	public ArrayList<Medicine> findAllMedicine(){
		return _medicineService.findAllMedicine();
	}
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/getMedicineByName/{name}")
	public ArrayList<Medicine> findMedicineByName(@PathVariable String name){
		return _medicineService.findMedicineByName(name);
	}
	
	@PutMapping(value = "/forAllergies")
	public ArrayList<Medicine> findAllMedicineForAllergies(@RequestBody Allergy allergy){
		return _medicineService.findAllMedicineForAllergies(allergy);
	}

	@PostMapping("/addMedicine")
    public ResponseEntity<?> addNewMedicine(@RequestBody MedicineRegistrationDTO medicineRegistration)
    {
		try {
			  return new ResponseEntity<>(this._medicineService.addNewMedicine(medicineRegistration), HttpStatus.CREATED);
			} catch (Exception e) { 
				return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
			}
    }
	
}
