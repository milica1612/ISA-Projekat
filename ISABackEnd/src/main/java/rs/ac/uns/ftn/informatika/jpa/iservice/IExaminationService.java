package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;

public interface IExaminationService {
	public ArrayList<ExaminationDTO> getByPharmacy(Long pharmacyId);
	public void scheduleExamination(ExaminationDTO examination);
	public ArrayList<ExaminationDTO> getByPatient(Long patientId);
}
