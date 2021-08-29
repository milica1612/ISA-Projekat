package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineAvailableInPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineItemService;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineItemRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class MedicineItemService implements IMedicineItemService{

	private IMedicineItemRepository _medicineItemRepository;

	private IPharmacyRepository _pharmacyRepository;
	
	@Autowired
	public MedicineItemService(IMedicineItemRepository medicineItemRepository, IPharmacyRepository pharmacyRepository) {
		this._medicineItemRepository = medicineItemRepository;
		this._pharmacyRepository = pharmacyRepository;
	}
	
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

	@Override
	public void findMedicineItmeAndChangeQuantity(MedicineAvailableInPharmacyDTO dto) {
		Set<MedicineItem> all = dto.getPharmacy().getMedicineItem();
		for (MedicineItem m : all) {
			if(m.getMedicine().getName().equals(dto.getPriceTag().getMedicine().getName())) {
				saveQuantityMedicineItem(m);
				break;
			}
		}
	
		}

	@Override
	public List<MedicineItem> findMedicineItemsByPharmacy(Long pharmacyId) {
		Pharmacy pharmacy = _pharmacyRepository.getOne(pharmacyId);
		List<MedicineItem> medicineItems = new ArrayList<MedicineItem>();
		
		// manual convert Set to List
		for (MedicineItem medicineItem : pharmacy.getMedicineItem()) {
			medicineItems.add(medicineItem);			
		}
		
		return medicineItems;
	}

}
