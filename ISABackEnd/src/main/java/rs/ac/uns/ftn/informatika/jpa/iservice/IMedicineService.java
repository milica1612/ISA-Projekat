package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.HashSet;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRegistrationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineService {

	public ArrayList<Medicine> findAllMedicine();
	public ArrayList<Medicine> findAllMedicineForAllergies(Allergy allergy);
	public ArrayList<Medicine> findMedicineByName(String name);
	
	public Medicine addNewMedicine(MedicineRegistrationDTO medicineRegistration);
}
