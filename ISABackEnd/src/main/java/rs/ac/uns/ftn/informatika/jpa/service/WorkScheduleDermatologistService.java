package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IWorkScheduleDermatologistService;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.TimeInterval;
import rs.ac.uns.ftn.informatika.jpa.model.WorkScheduleDermatologist;
import rs.ac.uns.ftn.informatika.jpa.repository.IWorkScheduleDermatologistRepository;

@Service
public class WorkScheduleDermatologistService implements IWorkScheduleDermatologistService{ 

	private IWorkScheduleDermatologistRepository _workScheduleRepository;

	@Autowired
	public WorkScheduleDermatologistService(IWorkScheduleDermatologistRepository workScheduleDermatologistRepository) {
		this._workScheduleRepository = workScheduleDermatologistRepository;
	}

	public  WorkScheduleDermatologist findWorkScheduleForDermatologistInPeriod(Examination examination) {
		ArrayList<WorkScheduleDermatologist> all = (ArrayList<WorkScheduleDermatologist>) _workScheduleRepository.findAll();

		Calendar examS = Calendar.getInstance();
		examS.setTime(examination.getDateAndTime());
		
		Calendar endExam = Calendar.getInstance(); // creates calendar
		endExam.setTime(examS.getTime());               // sets calendar time/date
		endExam.add(Calendar.MINUTE, 30);
		
		Long examStart = examS.getTimeInMillis();
		Long examEnd = endExam.getTimeInMillis(); 
		System.out.println(examStart + " " + examEnd);
		
		int startTime = examination.getDateAndTime().getHours()*60 + examination.getDateAndTime().getMinutes();
		int endTime = startTime + 30;
			
		for (WorkScheduleDermatologist workSchedule : all) {
			if(workSchedule.getDermatologist().getUserId() == examination.getDermatologist().getUserId()) {
				System.out.println("Pronasao je za dermatologa");
				
				Calendar validS = Calendar.getInstance();
				validS.setTime(workSchedule.getValidFor().getStartDate());
				
				Calendar validE = Calendar.getInstance(); // creates calendar
				validE.setTime(workSchedule.getValidFor().getEndDate());               // sets calendar time/date
				
				int shiftStart = workSchedule.getShift().getStartDate().getHours()*60 + workSchedule.getShift().getStartDate().getMinutes();
				int shiftEnd = workSchedule.getShift().getEndDate().getHours()*60 + workSchedule.getShift().getEndDate().getMinutes();              // sets calendar time/date
			
				Long validStart = validS.getTimeInMillis();
				Long validEnd = validE.getTimeInMillis(); 		
				
				if(validStart <= examStart && validEnd >= examEnd) {
					System.out.println("Pronasao je period");
				if(shiftStart <= startTime) {
					System.out.println("Pronasao je smjenu ");
					if(shiftEnd > endTime ) {
						System.out.println("Nije");
						return workSchedule;
					}
				}
			}
			}
		}
		return null;
	}


	@Override
	public Boolean addNewExaminationToWorkSchedule(Examination e) {
		WorkScheduleDermatologist workSchedule = findWorkScheduleForDermatologistInPeriod(e);
		if(workSchedule == null) {
			return false;
		}
		workSchedule.getScheduledExaminations().add(e);
		_workScheduleRepository.save(workSchedule);
		return true;
	}

	@Override
	public String getShiftByDermatologistId(Long dermatologistId) {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<WorkScheduleDermatologist> allWorkScheduleDermatologists = _workScheduleRepository.findAll();
		StringBuilder shift = new StringBuilder();
		for (WorkScheduleDermatologist w : allWorkScheduleDermatologists) {
			if (w.getDermatologist().getUserId() == dermatologistId && w.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {
				TimeInterval timeShift = w.getShift();
				shift.append("The dermatologist ");
				shift.append(w.getDermatologist().getFirstName());
				shift.append(" " + w.getDermatologist().getLastName());
				shift.append(" ");
				shift.append("in our pharmacy works in shifts");
				shift.append(" from ");
				String shiftStartStr = timeShift.getStartDate().toString();
				String[] shiftStartTime = shiftStartStr.split(" ", 2);
				shift.append(shiftStartTime[1].substring(0, shiftStartTime.length));
				shift.append(" to ");
				String shiftEndStr = timeShift.getEndDate().toString();
				String[] shiftEndTime = shiftEndStr.split(" ", 2);
				shift.append(shiftEndTime[1].substring(0, shiftEndTime.length));
				shift.append(" h");
			}
		}
		
		return shift.toString();
	}
	
	@Override
	public String getValidForByDermatologistId(Long dermatologistId) {
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<WorkScheduleDermatologist> allWorkScheduleDermatologists = _workScheduleRepository.findAll();
		StringBuilder validFor = new StringBuilder();
		for (WorkScheduleDermatologist w : allWorkScheduleDermatologists) {
			if (w.getDermatologist().getUserId() == dermatologistId && w.getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {
				TimeInterval validForDates = w.getValidFor();
				validFor.append("This working time for dermatologist ");
				validFor.append(w.getDermatologist().getFirstName());
				validFor.append(" " + w.getDermatologist().getLastName());
				validFor.append(" ");
				validFor.append("is valid from ");
				String validForStartStr = validForDates.getStartDate().toString();
				String[] validForStartDate = validForStartStr.split(" ", 2);
				validFor.append(validForStartDate[0]);
				validFor.append(" to ");
				String validForEndStr = validForDates.getEndDate().toString();
				String[] validForEndDate = validForEndStr.split(" ", 2);
				validFor.append(validForEndDate[0]);
			}
		}
		
		return validFor.toString();
	}
}
