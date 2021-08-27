package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.MedicineRegistrationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineService;
import rs.ac.uns.ftn.informatika.jpa.model.Allergy;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineItem;
import rs.ac.uns.ftn.informatika.jpa.model.MedicineSpecification;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IAllergyRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineItemRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class MedicineService implements IMedicineService{

	@Autowired IMedicineRepository _medicineRepository;
	
	@Autowired
	private IPharmacyRepository _pharmacyRepository;

	@Autowired
	private IMedicineItemRepository _medicineItemRepository;
	
	@Override
	public ArrayList<Medicine> findAllMedicine() {
		
		return (ArrayList<Medicine>) _medicineRepository.findAll();
	}
	
	@Override
	public ArrayList<Medicine> findAllMedicineForAllergies(Allergy allergy) {
		
		ArrayList<Medicine> medicine = findAllMedicine();
		HashSet<Medicine> medicineInAllergy = (HashSet<Medicine>) allergy.getMedicine();
		ArrayList<Medicine> result = new ArrayList<Medicine>();
		boolean found = false;
		for (Medicine m : medicine) {
			for (Medicine m2 : medicineInAllergy) {
				if(m2.getMedicineId() == m.getMedicineId()) {
					found = true;
				break;
			}		
		}
			if(!found)
			{
			result.add(m);
			}
			found = false;
			
		}
		
		return result;
	}
	

	@Override
	public ArrayList<Medicine> findMedicineByName(String name) {
		ArrayList<Medicine> medicine = findAllMedicine();
		ArrayList<Medicine> result = new ArrayList<Medicine>();
		
		for (Medicine med : medicine) {
			if(med.getName().contains(name))
				result.add(med);
		}
		return result;
	}

	@Override
	public Medicine addNewMedicine(MedicineRegistrationDTO medicineRegistration) {

		Medicine medicine = new Medicine();
		
		medicine.setName(medicineRegistration.getName());
		medicine.setMedicineCode(medicineRegistration.getCode());
		medicine.setLoyaltyPoints(medicineRegistration.getLoyaltyPoints());
		
		medicine.setMedicineForm(medicineRegistration.getMedicineForm());
		medicine.setType(medicineRegistration.getType());
		medicine.setReplacementMedicine(medicineRegistration.getReplacementMedicine());
		medicine.setManufacturer(medicineRegistration.getManufacturer());
		medicine.setPrecautions(medicineRegistration.getPrecautions());
		
		MedicineSpecification med_spec = new MedicineSpecification();
		
		med_spec.setContraindication(medicineRegistration.getMedicineSpecification().getContraindication());
		med_spec.setDosage(medicineRegistration.getMedicineSpecification().getDosage());
		med_spec.setIngridient(medicineRegistration.getMedicineSpecification().getIngridient());
		medicine.setMedicineSpecification(med_spec);
		
		return _medicineRepository.save(medicine);
	}
	
	@Override
	public List<Pharmacy> findPharmacyForMedicineItem(String name) {
		System.out.println("service");
		
		List<Pharmacy> pharmacies = _pharmacyRepository.findAll();
		List<MedicineItem> medicineItems = _medicineItemRepository.findAll();
		
		HashSet<MedicineItem> items = new HashSet<>();
		List<Pharmacy> pharmacy = new ArrayList<>();
		
		for(MedicineItem m: medicineItems) {
			if(m.getMedicine().getName().equals(name)) {
				items.add(m);
				System.out.println(m.getMedicine().getName());
			}
		}
		System.out.println(items.size());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(Pharmacy p: pharmacies) {
			for(MedicineItem m: items) {
				if(p.getMedicineItem().contains(m) && m.getQuantity() > 0) {
					pharmacy.add(p);
				}
			}
		}
		System.out.println(pharmacy.size());
		return pharmacy;
	}
}
