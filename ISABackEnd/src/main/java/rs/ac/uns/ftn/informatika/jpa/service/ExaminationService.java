package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.informatika.jpa.dto.ExaminationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IExaminationService;
import rs.ac.uns.ftn.informatika.jpa.model.AppointmentStatus;
import rs.ac.uns.ftn.informatika.jpa.model.Dermatologist;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Supplier;
import rs.ac.uns.ftn.informatika.jpa.model.TimeInterval;
import rs.ac.uns.ftn.informatika.jpa.model.User;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.repository.IExaminationRepository;

@Service
public class ExaminationService implements IExaminationService{
	
	private IExaminationRepository _examinationRepository;
	
	@Autowired
	public ExaminationService(IExaminationRepository examinationRepository) {
		this._examinationRepository = examinationRepository;
	}
	
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
	public Examination scheduleExamination(ExaminationDTO examination) {
		Optional<Examination> oldExamination = _examinationRepository.findById(examination.getAppointmentId());
		Examination e = oldExamination.get();
		e.setPatient(examination.patient);
		e.setCancelled(false);
		return _examinationRepository.save(e);
		
	}

	//metoda koja dobavalja zakazane preglede koji se jos nisu odrzali
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
			if(examination.getPatient() != null) {
				if(examination.getPatient().getUserId() == patientId && examination.getAppointmentStatus() == AppointmentStatus.FINISHED) {
					if(!result.contains(examination.getPharmacy())) {
						result.add(examination.getPharmacy());
					}
				}
			}
		}
	}
	
	@Override
	public Examination startExamination(Date date) {
		
		Calendar eS = Calendar.getInstance();
		eS.setTime(date);
		eS.add(Calendar.MINUTE, -15);
		
		Calendar eE = Calendar.getInstance(); // creates calendar
		eE.setTime(eS.getTime());               // sets calendar time/date
		eE.add(Calendar.MINUTE, 30);
		
		Long eStart = eS.getTimeInMillis();
		Long eEnd = eE.getTimeInMillis(); 
		
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		for(Examination e: allExaminations) {
			Calendar examS = Calendar.getInstance();
			examS.setTime(e.getDateAndTime());
			
			Long examStart = examS.getTimeInMillis();
			
			if(examStart >= eStart && examStart < eEnd) {
				e.setAppointmentStatus(AppointmentStatus.STARTED);
				this._examinationRepository.save(e);
				return e;
			}
		}
		return new Examination();
	}
	
	@Override
	public Examination endExamination(Long id) {
		
		Examination e = findById(id);
		
			if(e.getAppointmentStatus().equals(AppointmentStatus.STARTED)){
				e.setAppointmentStatus(AppointmentStatus.FINISHED);
				this._examinationRepository.save(e);
				return e;
		
		}
		return null;
	}

	@Override
	public Examination findById(Long id) {
		return _examinationRepository.findById(id).orElse(null);
	}
	
	public ArrayList<Dermatologist> getAllDermatologistByPatient(Long patientId) {
		
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<Dermatologist> result = new ArrayList<Dermatologist>();
		
		for(Examination examination: allExaminations) {
			if(examination.getPatient() != null) {
				if(examination.getPatient().getUserId() == patientId && examination.getAppointmentStatus() == AppointmentStatus.FINISHED) {
					if(!result.contains(examination.getDermatologist())) {
						result.add(examination.getDermatologist());
					}	
				}
			}
		}
		return result;	
	}

	@Override
	public ArrayList<ExaminationDTO> getPreviousExaminations(Long patientId) {
		ArrayList<Examination> allExaminations = (ArrayList<Examination>) _examinationRepository.findAll();
		ArrayList<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
		
		for (Examination examination : allExaminations) {
			if(examination.getPatient() != null) {
				if(examination.getPatient().getUserId() == patientId && examination.getAppointmentStatus() == AppointmentStatus.FINISHED) {
					result.add(new ExaminationDTO(examination.getAppointmentId(),examination.getDateAndTime().toString(),
							examination.getDuration(),examination.getPrice(),examination.getPoints(),examination.getDermatologist(),
							null, examination.getPharmacy()));
				}
			}
		}
		
		return result;
	}
	
	@Override
	public List<Examination> getByDermatologist(Long id, TimeInterval timeInterval){
		
		List<Examination> all = _examinationRepository.findAll();
		List<Examination> result = new ArrayList<>();
		
		
		for(Examination e: all) {
			if(e.getDermatologist() != null) {
				if(id.equals(e.getDermatologist().getUserId())) {
					if(e.getDateAndTime().after(timeInterval.getStartDate()) && e.getDateAndTime().before(timeInterval.getEndDate())) {
						result.add(e);
					}
				}
			}
		}
		
		return result;
	}
	
	public List<ExaminationDTO> findAllScheduledExaminationInPharmacyByDermatologist(Long dermatologistId) {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Examination> allExamination = _examinationRepository.findAll();
		List<ExaminationDTO> list = new ArrayList<ExaminationDTO>();
	
		for(Examination e : allExamination) {
			if (e.getDermatologist().getUserId() == dermatologistId
					&& e.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {
				ExaminationDTO examinationDTO = new ExaminationDTO(e.getAppointmentId(),e.getDateAndTime().toString(), e.getDuration(), e.getPrice(), e.getPoints(), e.getDermatologist(), e.getPatient(), e.getPharmacy());
				list.add(examinationDTO);
			}
		}
	
	return list;
	}
}
