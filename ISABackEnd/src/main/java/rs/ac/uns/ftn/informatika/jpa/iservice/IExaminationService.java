package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IExaminationService {
	public ArrayList<Examination> getByPharmacy(Long pharmacyId);
}
