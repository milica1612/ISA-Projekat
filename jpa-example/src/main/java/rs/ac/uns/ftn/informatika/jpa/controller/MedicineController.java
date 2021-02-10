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
import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.model.Ingridient;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineService;
import rs.ac.uns.ftn.informatika.jpa.service.MedicineSpecificationService;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineController {

	@Autowired
	private MedicineService _medicineService ;
	
	@Autowired
	private MedicineSpecificationService _specificationService;
	
	@GetMapping(value = "")
	public ArrayList<Medicine> findAllMedicine(){
		return _medicineService.findAllMedicine();
	}
	
	@PutMapping(value = "/forAllergies")
	public ArrayList<Medicine> findAllMedicineForAllergies(@RequestBody Allergy allergy){
		return _medicineService.findAllMedicineForAllergies(allergy);
	}
	
	@PostMapping(value = "/addMedicine")
	public Medicine addMedicine(@RequestBody MedicineDTO medicineDTO){
		
		if(medicineDTO == null) {
			return null;
		}
		
		Medicine medicine = new Medicine();
		MedicineSpecification medicineSpecification = new MedicineSpecification();
		
		Contraindication contr = new Contraindication();
		Ingridient ingridient = new Ingridient();
		
		HashSet<Medicine> medicineRepl = (HashSet<Medicine>) medicine.getReplacementMedicine();
		
		medicine.setName(medicineDTO.getName());
		medicine.setMedicineCode(medicineDTO.getMedicineCode());
		medicine.setType(medicineDTO.getMedicineType());
		medicine.setLoyaltyPoints(medicineDTO.getLoyaltyPoint());
		medicine.setReplacementMedicine(medicineRepl);
		medicine.setManufacturer("Galenika");
		medicine.setPrecautions("Nema");
		contr.setDescription(medicineDTO.getContraindications());
		ingridient.setName(medicineDTO.getIngridients());
		medicineSpecification.setDosage(medicineDTO.getDosage());
		
	//	medicine.setMedicineSpecification(medicineSpecification);
		_medicineService.save(medicine);
		return medicine;
	}
	
	@GetMapping(value = "/newMedicine")
	public Medicine newMedicine() {
		return _medicineService.newMedicine();
	}
}
