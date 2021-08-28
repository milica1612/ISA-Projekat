package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;

public interface IWorkSchedulePharmacistService {
	ArrayList<Pharmacy> getAvailablePharmacies(Date date);
	ArrayList<Pharmacist> getAvailablePharmacistsInPharmacy(Date date, Long pharmacyId);
	void addNewConsultationToWorkSchedule(Consultation c);
	Boolean addConsToWorkSchedule(Consultation c);
}
