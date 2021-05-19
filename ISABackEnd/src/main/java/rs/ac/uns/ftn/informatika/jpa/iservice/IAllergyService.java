package rs.ac.uns.ftn.informatika.jpa.iservice;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface IAllergyService {
	public Set<Medicine> addMedicineToAllergy(Medicine medicine,Long id);
}
