package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IEPrescriptionService {

	void getPharmaciesForPatient(Long patientId, ArrayList<Pharmacy> result);

}
