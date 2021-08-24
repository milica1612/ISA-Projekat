package rs.ac.uns.ftn.informatika.jpa.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineItemService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineItemRepository;

@Service
public class MedicineItemService implements IMedicineItemService{
	
	@Autowired
	private IMedicineItemRepository _medicineItemRepository;
	
	@Override
	public MedicineItem saveQuantityMedicineItem(@Valid MedicineItem mi) {
		
		int quantity = mi.getQuantity() - 1;
		
		MedicineItem medicineItem = _medicineItemRepository.findById(mi.getMedicine().getMedicineId()).orElse(null);
		medicineItem.setMedicine(mi.getMedicine());
		medicineItem.setQuantity(quantity);
		System.out.println(quantity +  "*****************");
		this._medicineItemRepository.save(medicineItem);
		return medicineItem;
	}

}
