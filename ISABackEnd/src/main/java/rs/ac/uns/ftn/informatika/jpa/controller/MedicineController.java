package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
import rs.ac.uns.ftn.informatika.jpa.dto.NotificationDTO;

import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineService;
import rs.ac.uns.ftn.informatika.jpa.service.NotificationService;
import rs.ac.uns.ftn.informatika.jpa.service.PharmacyService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineService _medicineService ;
	
	@Autowired
	private PharmacyService _pharmacyService;
	
	@Autowired
	private NotificationService _notificationService;
	
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
	
	
	static class CheckAvailability{
		public Long pharmacyId;
		public Medicine medicineAvailable;
	}
	
	@PutMapping(value = "/checkAvailability")
	public Boolean checkAvailability(@RequestBody CheckAvailability ca) {
		
		Pharmacy pharmacy = _pharmacyService.findById(ca.pharmacyId);
			
		Set<MedicineItem> medicineItems =  pharmacy.getMedicineItem();
		
		for(MedicineItem m : medicineItems) {
			if (m.getMedicine().getMedicineId() == ca.medicineAvailable.getMedicineId() && m.getQuantity() > 0) {
				return true;
			}
		}
		
		NotificationDTO n = new NotificationDTO();
		n.setContent(ca.medicineAvailable.getName() + " is not available.");
		n.setPharmacyId(pharmacy.getPharmacyId());
		
		_notificationService.saveNotification(n);
		return false;
	}
	
	static class SubstitutesWithoutAllergy{
		public Medicine oldMedicine;
		public HashSet<Medicine> medicinesWithoutAllergy;
	}
	
	@PutMapping(value = "/substituteMedicine")
	public HashSet<Medicine> findAllSubstituteMedicine(@RequestBody SubstitutesWithoutAllergy swa){
		
		HashSet<Medicine> substituteMedicines = new HashSet<Medicine>();
		HashSet<Medicine> allSubstitutes = (HashSet<Medicine>) swa.oldMedicine.getReplacementMedicine();
		boolean found = false;
		for (Medicine m : allSubstitutes) {
			for(Medicine m2: swa.medicinesWithoutAllergy) {
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
}
