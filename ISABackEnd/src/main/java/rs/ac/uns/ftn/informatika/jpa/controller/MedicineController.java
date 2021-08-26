package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Offer;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.model.User;
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
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		try {
			  return new ResponseEntity<>(this._medicineService.addNewMedicine(medicineRegistration), HttpStatus.CREATED);
			} catch (Exception e) { 
				return new ResponseEntity<>(e.getMessage() + " ovde je propalo", HttpStatus.BAD_REQUEST);
			}
    }
	
	static class SubstitutesWithoutAllergy{
		Medicine oldMedicine;
		HashSet<Medicine> medicinesWithoutAllergy;
	}
	
	@PutMapping(value = "/substituteMedicine")
	public HashSet<Medicine> findAllSubstituteMedicine(@RequestBody SubstitutesWithoutAllergy swa){
		
		HashSet<Medicine> substituteMedicines = new HashSet<Medicine>();
		HashSet<Medicine> allSubstitutes = (HashSet<Medicine>) swa.oldMedicine.getReplacementMedicine();
		boolean found = false;
		for (Medicine m : swa.medicinesWithoutAllergy) {
			for(Medicine m2: allSubstitutes) {
				if (m2.getMedicineId() == m.getMedicineId())
					found = true;
				break;
			}		
		
			if(!found)
			{
			substituteMedicines.add(m);
			}
			found = false;
			
		}
		
		return substituteMedicines;
		
	}
	
	@GetMapping(path = "/filtrate/{rating}")
	public List<Medicine> filtrateMedicine(@PathVariable int rating){
		
		List<Medicine> medicines = findAllMedicine();
		
		List<Medicine> filtrateMedicines = new ArrayList<>();

		for(Medicine m : medicines) {
			if(m.getRating() == rating) {
				filtrateMedicines.add(m);				}
		}
		
		return filtrateMedicines; 
	}
	
	@GetMapping(path = "/checkMedicineInPharmacy/{name}")
	public List<Pharmacy> findAvailableMedicineInPharmacy(@PathVariable String name){	
		return _medicineService.findPharmacyForMedicineItem(name); 
	}
}
