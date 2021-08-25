package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IWorkSchedulePharmacistService {
	ArrayList<Pharmacy> getAvailablePharmacies(Date date);
	ArrayList<Pharmacist> getAvailablePharmacistsInPharmacy(Date date, Long pharmacyId);
}
