package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IWorkScheduleDermatologistService;
import rs.ac.uns.ftn.informatika.jpa.model.Examination;
import rs.ac.uns.ftn.informatika.jpa.model.TimeInterval;
import rs.ac.uns.ftn.informatika.jpa.model.WorkScheduleDermatologist;
import rs.ac.uns.ftn.informatika.jpa.repository.IWorkScheduleDermatologistRepository;

@Service
public class WorkScheduleDermatologistService implements IWorkScheduleDermatologistService{ 

	@Autowired
	private IWorkScheduleDermatologistRepository _workScheduleRepository;

	
	public WorkScheduleDermatologist findWorkScheduleForDermatologistInPeriod(Examination e) {
		ArrayList<WorkScheduleDermatologist> all = (ArrayList<WorkScheduleDermatologist>) _workScheduleRepository.findAll();

		Calendar cal = Calendar.getInstance(); // creates calendar
		cal.setTime(e.getDateAndTime());               // sets calendar time/date
		cal.add(Calendar.MINUTE, e.getDuration());
		for (WorkScheduleDermatologist workSchedule : all) {
			if(workSchedule.getDermatologist().getUserId() == e.getDermatologist().getUserId()) {
				System.out.println("Pronasao je za dermatologa");
				TimeInterval valid = workSchedule.getValidFor();
				TimeInterval shift = workSchedule.getShift();
				if(valid.getStartDate().before(e.getDateAndTime()) && valid.getEndDate().after(e.getDateAndTime())) {
					System.out.println("Pronasao je period");
				if(shift.getStartDate().getHours() < e.getDateAndTime().getHours()) {
					System.out.println("Pronasao je smjenu ");
					if(shift.getEndDate().getHours() > cal.getTime().getHours()) {
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
}
