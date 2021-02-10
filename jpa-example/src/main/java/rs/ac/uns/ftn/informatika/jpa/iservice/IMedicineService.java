package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;

public interface IMedicineService {

	public ArrayList<Medicine> findAllMedicine();
	public ArrayList<Medicine> findAllMedicineForAllergies(Allergy allergy);
	
	public Medicine newMedicine();
	
	public Medicine save(Medicine medicine);
}
