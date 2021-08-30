package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;

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
	ArrayList<Dermatologist> getAllDermatologistByPatient();

}
