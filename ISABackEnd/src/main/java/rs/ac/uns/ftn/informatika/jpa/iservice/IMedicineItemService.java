package rs.ac.uns.ftn.informatika.jpa.iservice;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;

@Service
public interface IMedicineItemService {
	
	public MedicineItem saveQuantityMedicineItem(MedicineItem mi);

}
