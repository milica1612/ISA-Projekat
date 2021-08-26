package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRegistrationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IMedicineService {

	public ArrayList<Medicine> findAllMedicine();
	public ArrayList<Medicine> findAllMedicineForAllergies(Allergy allergy);
	public ArrayList<Medicine> findMedicineByName(String name);
	
	public Medicine addNewMedicine(MedicineRegistrationDTO medicineRegistration);
	 
	public List<Pharmacy> findPharmacyForMedicineItem(String name);
	

}
