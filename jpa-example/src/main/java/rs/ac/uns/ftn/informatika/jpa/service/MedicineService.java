package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineService;
import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineForm;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;
import rs.ac.uns.ftn.informatika.jpa.model.PrescriptionType;

import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineRepository;

@Service
public class MedicineService implements IMedicineService{

	@Autowired
	private IMedicineRepository _medicineRepository;

	@Override
	public ArrayList<Medicine> findAllMedicine() {	
		return (ArrayList<Medicine>) _medicineRepository.findAll();
	}
	
	@Override
	public ArrayList<Medicine> findAllMedicineForAllergies(Allergy allergy) {
		
		ArrayList<Medicine> medicine = findAllMedicine();
		HashSet<Medicine> medicineInAllergy = (HashSet<Medicine>) allergy.getMedicine();
		ArrayList<Medicine> result = new ArrayList<Medicine>();
		boolean found = false;
		for (Medicine m : medicine) {
			for (Medicine m2 : medicineInAllergy) {
				if(m2.getMedicineId() == m.getMedicineId()) {
					found = true;
				break;
			}		
		}
			if(!found)
			{
			result.add(m);
			}
			found = false;
			
		}
		
		return result;
	}
	
	@Override
	public Medicine newMedicine() {
		
		String name = "";
		String medicineCode = "";
		String type = " ";
		String manufacturer = "";
		int loyaltyPoints = 0;
		Double dosage = 0.0;
		String precautions = "";
		
		return new Medicine(name, medicineCode, type, manufacturer, precautions, loyaltyPoints,
				new MedicineSpecification(dosage), MedicineForm.PILL, PrescriptionType.PRESCRIPTION);
	}

	@Override
	public Medicine save(Medicine medicine) {
		return _medicineRepository.save(medicine);
	}
	
}
