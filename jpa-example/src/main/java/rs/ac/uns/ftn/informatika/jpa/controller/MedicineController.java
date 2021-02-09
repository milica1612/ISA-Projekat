package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineService;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineService _medicineService ;
	
	@GetMapping(value = "")
	public ArrayList<Medicine> findAllMedicine(){
		return _medicineService.findAllMedicine();
	}
	
	@PutMapping(value = "/forAllergies")
	public ArrayList<Medicine> findAllMedicineForAllergies(@RequestBody Allergy allergy){
		return _medicineService.findAllMedicineForAllergies(allergy);
	}
	
	@PostMapping(value = "/addMedicine")
	public ResponseEntity<Patient> createPatient(@RequestBody MedicineDTO medicineDTO){

		
		if(medicineDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Medicine _medicine = new Medicine();
		MedicineSpecification specification = new MedicineSpecification();

		_medicine.setName(medicineDTO.getName());
		_medicine.setType(medicineDTO.getMedicineType());
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
}
