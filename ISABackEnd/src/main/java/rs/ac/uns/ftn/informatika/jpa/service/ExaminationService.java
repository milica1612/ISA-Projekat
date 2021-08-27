package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IExaminationService;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.repository.IExaminationRepository;

@Service
public class ExaminationService implements IExaminationService{
	@Autowired
	private IExaminationRepository _examinationRepository;

	@Override
	public ArrayList<ExaminationDTO> getByPharmacy(Long pharmacyId) {
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
		
		for (Examination examination : allExaminations) { 
			if(examination.getDateAndTime().after(new Date()) && examination.getPharmacy().getPharmacyId() == pharmacyId) {
				if(examination.getPatient() == null || examination.getCancelled() == true) {
			result.add(new ExaminationDTO(examination.getAppointmentId(),examination.getDateAndTime().toString(),
					examination.getDuration(),examination.getPrice(),examination.getPoints(),examination.getDermatologist(),
					null, examination.getPharmacy()));
				}
			}
		}
		return result;
	}

	@Override
	public void scheduleExamination(ExaminationDTO examination) {
		Optional<Examination> oldExamination = _examinationRepository.findById(examination.getAppointmentId());
		Examination e = oldExamination.get();
		e.setPatient(examination.patient);
		e.setCancelled(false);
		_examinationRepository.save(e);
		
	}

	@Override
	public ArrayList<ExaminationDTO> getByPatient(Long patientId) {
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
		
		for (Examination examination : allExaminations) { 
			if(examination.getDateAndTime().after(new Date()) && examination.getPatient() != null) {
				if(examination.getPatient().getUserId() == patientId && examination.getCancelled() == false) {
			result.add(new ExaminationDTO(examination.getAppointmentId(),examination.getDateAndTime().toString(),
					examination.getDuration(),examination.getPrice(),examination.getPoints(),examination.getDermatologist(),
					examination.getPatient(), examination.getPharmacy()));
				}
			}
		}
		return result;
	}

	@Override
	public boolean cancelExamination(ExaminationDTO examination) {
		Optional<Examination> oldExamination = _examinationRepository.findById(examination.getAppointmentId());
		Examination e = oldExamination.get();
		if(isSoonerThan24hours(e)) {
			return false;
		}
		e.setCancelled(true);
		_examinationRepository.save(e);
		return true;
	}

	@Override
	public boolean isSoonerThan24hours(Examination examination) {
		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(new Date());               // sets calendar time/date
		cal.add(Calendar.HOUR_OF_DAY, 24);      
		
		if(examination.getDateAndTime().before(cal.getTime())) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Examination> findAllExamination(){
		return (ArrayList<Examination>) _examinationRepository.findAll();
	}
}
