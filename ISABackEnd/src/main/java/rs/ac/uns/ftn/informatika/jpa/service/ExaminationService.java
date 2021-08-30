package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IExaminationService;
import rs.ac.uns.ftn.informatika.jpa.model.AppointmentStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.repository.IExaminationRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IUserRepository;

@Service
public class ExaminationService implements IExaminationService{
	@Autowired
	private IExaminationRepository _examinationRepository;

	@Autowired
	private IUserRepository _userRepository;
	
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
	public ArrayList<Examination> getExaminationsByPatient(Long patientId) {
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<Examination> result = new ArrayList<Examination>();
		
		for (Examination examination : allExaminations) { 
			if(examination.getDateAndTime().after(new Date()) && examination.getPatient() != null) {
				if(examination.getPatient().getUserId() == patientId && examination.getCancelled() == false) {
			result.add(examination);
				}
			}
		}
		return result;
	}
	
	@Override
	public ArrayList<ExaminationDTO> getByDermatologist(Long dermatologistId){
		
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
		
		for (Examination examination : allExaminations) { 
			if(examination.getDateAndTime().after(new Date()) &&
			   examination.getDermatologist().getUserId().equals(dermatologistId)) {
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
	
	
	@Override
	public Examination save(ExaminationDTO dto) {
		String d = dto.getDateAndTime() + ":00";
	    Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d);
			System.out.println(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		Examination examination = new Examination();
		examination.setAppointmentStatus(AppointmentStatus.NONE);
		examination.setCancelled(false);
		examination.setDateAndTime(date);
		examination.setDermatologist(dto.getDermatologist());
		examination.setPatient(dto.getPatient());
		examination.setPrice(dto.getPrice());
		examination.setPharmacy(dto.getPharmacy());
		examination.setDuration(30);
		return this._examinationRepository.save(examination);
		
	}
	
	@Override
	public Examination saveExamination(Examination e) {
		
		Examination examination = new Examination();
		examination.setAppointmentStatus(AppointmentStatus.NONE);
		examination.setCancelled(false);
		examination.setDateAndTime(e.getDateAndTime());
		examination.setDermatologist(e.getDermatologist());
		examination.setPatient(e.getPatient());
		examination.setPrice(e.getPrice());
		examination.setPharmacy(e.getPharmacy());
		examination.setDuration(30);
		return this._examinationRepository.save(examination);
		
	}

	@Override
	public void getPharmaciesForPatient(Long patientId, ArrayList<Pharmacy> result) {
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		for (Examination examination : allExaminations) {
			if(examination.getPatient().getUserId() == patientId) {
				if(!result.contains(examination.getPharmacy())) {
					result.add(examination.getPharmacy());
				}
			}
		}
	}
	
	@Override
	public ArrayList<Dermatologist> getAllDermatologistByPatient() {
		
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<Dermatologist> result = new ArrayList<Dermatologist>();
		
		Patient currentUser = (Patient) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Patient patient = (Patient) _userRepository.findById(currentUser.getUserId()).orElse(null);
		
		for(Examination examination: allExaminations) {
			if(examination.getPatient().getUserId() == patient.getUserId() && examination.getAppointmentStatus() == AppointmentStatus.FINISHED) {
				if(result.contains(examination.getDermatologist())) {
					throw new IllegalArgumentException("Dermatologist is already added!");
				}else {
					result.add(examination.getDermatologist());
				}	
			}
		}
		return result;
	}
	
}
