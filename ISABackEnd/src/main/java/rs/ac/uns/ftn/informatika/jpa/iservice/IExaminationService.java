package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.Date;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IExaminationService {
	public ArrayList<ExaminationDTO> getByPharmacy(Long pharmacyId);
	public void scheduleExamination(ExaminationDTO examination);
	public ArrayList<ExaminationDTO> getByPatient(Long patientId);
	public boolean cancelExamination(ExaminationDTO examination);
	public boolean isSoonerThan24hours(Examination examination);
	ArrayList<Examination> findAllExamination();
	ArrayList<ExaminationDTO> getByDermatologist(Long dermatologistId);
	Examination save(ExaminationDTO dto);
	ArrayList<Examination> getExaminationsByPatient(Long patientId);
	Examination saveExamination(Examination e);
	Examination startExamination(Date date);
	Examination endExamination(Long id);
	Examination findById(Long id);
}
