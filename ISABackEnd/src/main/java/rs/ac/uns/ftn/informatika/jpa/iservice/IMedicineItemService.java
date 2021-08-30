package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineAvailableInPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineItemDTO;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;

@Service
public interface IMedicineItemService {
	
	public MedicineItem saveQuantityMedicineItem(MedicineItem mi);

	void findMedicineItmeAndChangeQuantity(MedicineAvailableInPharmacyDTO dto);
	
	List<MedicineItemDTO> findMedicineItemsByPharmacy(Long pharmacyId);

	List<MedicineItemDTO> findPotentiallyNewMedicineItemsForPharmacy(Long pharmacyId);

}
