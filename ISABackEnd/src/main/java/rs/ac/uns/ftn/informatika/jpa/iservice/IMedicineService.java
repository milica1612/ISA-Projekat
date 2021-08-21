package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.HashSet;

import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineService {

	public ArrayList<Medicine> findAllMedicine();
	public ArrayList<Medicine> findAllMedicineForAllergies(Allergy allergy);
	public ArrayList<Medicine> findMedicineByName(String name);
	public HashSet<Medicine> findAllSubstituteMedicine(Medicine medicine);
}
