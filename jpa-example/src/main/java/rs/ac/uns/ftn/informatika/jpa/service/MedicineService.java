package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IMedicineService;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.repository.IMedicineRepository;

@Service
public class MedicineService implements IMedicineService{

	@Autowired IMedicineRepository _medicineRepository;

	public ArrayList<Medicine> findAllMedicine() {
		
		return (ArrayList<Medicine>) _medicineRepository.findAll();
	}
}
