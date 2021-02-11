package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IPharmacyService {

	Pharmacy findById(Long id);

	Pharmacy save(Pharmacy pharmacy);
	
	ArrayList<Pharmacy> findAllPharmacy();

}
