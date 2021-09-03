package rs.ac.uns.ftn.informatika.jpa.iservice;

import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IWorkScheduleDermatologistService {

	Boolean addNewExaminationToWorkSchedule(Examination e);
	
	String getShiftByDermatologistId(Long dermatologistId);

	String getValidForByDermatologistId(Long dermatologistId);

}
