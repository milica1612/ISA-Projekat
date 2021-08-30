package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineAvailableInPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineItemDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineItemService;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineItemRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class MedicineItemService implements IMedicineItemService{

	private IMedicineItemRepository _medicineItemRepository;

	private IPharmacyRepository _pharmacyRepository;
	
	private IMedicineRepository _medicineRepository;
	
	@Autowired
	public MedicineItemService(IMedicineItemRepository medicineItemRepository, IPharmacyRepository pharmacyRepository, IMedicineRepository medicineRepository) {
		this._medicineItemRepository = medicineItemRepository;
		this._pharmacyRepository = pharmacyRepository;
		this._medicineRepository = medicineRepository;
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
	public List<MedicineItemDTO> findMedicineItemsByPharmacy(Long pharmacyId) {
		Pharmacy pharmacy = _pharmacyRepository.getOne(pharmacyId);
		List<MedicineItemDTO> medicineItems = new ArrayList<MedicineItemDTO>();
		
		// manual convert Set to List
		for (MedicineItem medicineItem : pharmacy.getMedicineItem()) {
			Medicine m = medicineItem.getMedicine();
			MedicineItemDTO medicineDTO = new MedicineItemDTO(m.getName(), m.getMedicineId(), m.getMedicineCode(), m.getType(), m.getManufacturer(), m.getMedicineForm(), m.getPrescriptionType(), medicineItem.getQuantity());
			medicineItems.add(medicineDTO);			
		}
		
		return medicineItems;
	}
	
	@Override
	public List<MedicineItemDTO> findPotentiallyNewMedicineItemsForPharmacy(Long pharmacyId) {
		Pharmacy pharmacy = _pharmacyRepository.getOne(pharmacyId);
		Set<MedicineItem> medicineItemsInPharmacy = pharmacy.getMedicineItem();
		List<Medicine> allMedicine = _medicineRepository.findAll();
		List<MedicineItemDTO> potentiallyNewMedicineItemList = new ArrayList<MedicineItemDTO>();
		
		for (Medicine m : allMedicine)
		{
			Boolean isInPharmacy = false;
			for (MedicineItem mItem : medicineItemsInPharmacy) {
				if(mItem.getMedicine().getMedicineId() == m.getMedicineId())
					isInPharmacy = true;
			}
			
			if (!isInPharmacy) {
				MedicineItemDTO medicineItemDTO = new MedicineItemDTO(m.getName(), m.getMedicineId(), m.getMedicineCode(), m.getType(), m.getManufacturer(), m.getMedicineForm(), m.getPrescriptionType(), 0);
				potentiallyNewMedicineItemList.add(medicineItemDTO);
			}
			
		}
		
		return potentiallyNewMedicineItemList;
	}

}
