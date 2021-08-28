package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ConsultationDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IWorkSchedulePharmacistService;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacist;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.model.TimeInterval;
import rs.ac.uns.ftn.informatika.jpa.model.WorkSchedulePharmacist;
import rs.ac.uns.ftn.informatika.jpa.repository.IWorkSchedulePharmacistRepository;

@Service
public class WorkSchedulePharmacistService implements IWorkSchedulePharmacistService{

	@Autowired
	private IWorkSchedulePharmacistRepository _workScheduleRepository;

	@Override
	public ArrayList<Pharmacy> getAvailablePharmacies(Date date) {
		ArrayList<WorkSchedulePharmacist> all = (ArrayList<WorkSchedulePharmacist>) _workScheduleRepository.findAll();
		ArrayList<Pharmacy> pharmacies = new ArrayList<Pharmacy>();
		for (WorkSchedulePharmacist workSchedule : all) {
		
			TimeInterval valid = workSchedule.getValidFor();
			TimeInterval shift = workSchedule.getShift();
			Set<Consultation> consultations = workSchedule.getScheduledConsultations();
			
			Calendar cal = Calendar.getInstance(); // creates calendar
			cal.setTime(date);               // sets calendar time/date
			cal.add(Calendar.MINUTE, 30);
			boolean notAvailable = false;
			if(valid.getStartDate().before(date) && valid.getEndDate().after(date)) {
				System.out.println(shift.getStartDate().getHours());
				System.out.println(date.getHours());
				if(shift.getStartDate().getHours() < date.getHours()) {
					if(shift.getEndDate().getHours() > cal.getTime().getHours()) {
						for (Consultation c : consultations) {
							System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
							Calendar endCons = Calendar.getInstance(); // creates calendar
							endCons.setTime(c.getDateAndTime());               // sets calendar time/date
							endCons.add(Calendar.MINUTE, c.getDuration());

							if(c.getCancelled() == true) {
								System.out.println("cancelled");
								break;
							}else if(date.before(c.getDateAndTime()) && cal.before(endCons.getTime())) {
								System.out.println("notAvailable");
								notAvailable = true;
								break;
							}else if(date.after(c.getDateAndTime()) && cal.after(endCons.getTime())){
								System.out.println("notAVailable");
								notAvailable = true;
								break;
							}
						}
						if(notAvailable) {
							notAvailable = false;
						}else if (!pharmacies.contains(workSchedule.getPharmacy())){
							System.out.println("dodaj");
							pharmacies.add(workSchedule.getPharmacy());
						}
					
					}
			}
		}
		
	}
		return pharmacies;
}

	@Override
	public ArrayList<Pharmacist> getAvailablePharmacistsInPharmacy(Date date, Long pharmacyId) {
		ArrayList<WorkSchedulePharmacist> all = (ArrayList<WorkSchedulePharmacist>) _workScheduleRepository.findAll();
		ArrayList<Pharmacist> pharmacists = new ArrayList<Pharmacist>();
		for (WorkSchedulePharmacist workSchedule : all) {
		if(workSchedule.getPharmacy().getPharmacyId() == pharmacyId) {
			TimeInterval valid = workSchedule.getValidFor();
			TimeInterval shift = workSchedule.getShift();
			Set<Consultation> consultations = workSchedule.getScheduledConsultations();
			
			Calendar cal = Calendar.getInstance(); // creates calendar
			cal.setTime(date);               // sets calendar time/date
			cal.add(Calendar.MINUTE, 30);
			boolean notAvailable = false;
			if(valid.getStartDate().before(date) && valid.getEndDate().after(date)) {
				System.out.println(shift.getStartDate().getHours());
				System.out.println(date.getHours());
				if(shift.getStartDate().getHours() < date.getHours()) {
					if(shift.getEndDate().getHours() > cal.getTime().getHours()) {
						for (Consultation c : consultations) {
							Calendar endCons = Calendar.getInstance(); // creates calendar
							endCons.setTime(c.getDateAndTime());               // sets calendar time/date
							endCons.add(Calendar.MINUTE, c.getDuration());
						 if(date.before(c.getDateAndTime()) && cal.before(endCons.getTime())) {
								notAvailable = true;
								break;
							}else if(date.after(c.getDateAndTime()) && cal.after(endCons.getTime())){
								notAvailable = true;
								break;
							}
						}
						if(notAvailable) {
							notAvailable = false;
						}else {
						pharmacists.add(workSchedule.getPharmacist());
						}
					
					}
			}
		}
	}
		
	}
		return pharmacists;
	}
	
	public WorkSchedulePharmacist findWorkScheduleForPharmacistInPeriod(Consultation consultation) {
		ArrayList<WorkSchedulePharmacist> all = (ArrayList<WorkSchedulePharmacist>) _workScheduleRepository.findAll();

		Calendar examS = Calendar.getInstance();
		examS.setTime(consultation.getDateAndTime());
		examS.add(Calendar.HOUR, -1);
		
		Calendar endExam = Calendar.getInstance(); // creates calendar
		endExam.setTime(examS.getTime());               // sets calendar time/date
		endExam.add(Calendar.MINUTE, 30);
		
		Long examStart = examS.getTimeInMillis();
		Long examEnd = endExam.getTimeInMillis(); 
		System.out.println(examStart + " " + examEnd);
			
		for (WorkSchedulePharmacist workSchedule : all) {
			if(workSchedule.getPharmacist().getUserId() == consultation.getPharmacist().getUserId()) {
				System.out.println("Pronasao je za farmaceuta");
				
				Calendar validS = Calendar.getInstance();
				validS.setTime(workSchedule.getValidFor().getStartDate());
				
				Calendar validE = Calendar.getInstance(); // creates calendar
				validE.setTime(workSchedule.getValidFor().getEndDate());               // sets calendar time/date
				
				Calendar shiftS = Calendar.getInstance();
				shiftS.setTime(workSchedule.getShift().getStartDate());
				
				Calendar shiftE = Calendar.getInstance(); // creates calendar
				shiftE.setTime(workSchedule.getShift().getEndDate());               // sets calendar time/date
			
				Long validStart = validS.getTimeInMillis();
				Long validEnd = validE.getTimeInMillis(); 		
				
				Long shiftStart = shiftS.getTimeInMillis();
				Long shiftEnd = shiftE.getTimeInMillis(); 		
				System.out.println(shiftStart + " " + shiftEnd);
				
				if(validStart <= examStart && validEnd >= examStart) {
					System.out.println("Pronasao je period");
				if(shiftStart <= examStart) {
					System.out.println("Pronasao je smjenu ");
					if(shiftEnd > examEnd ) {
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
	public void addNewConsultationToWorkSchedule(Consultation c) {
		WorkSchedulePharmacist workSchedule = findWorkScheduleForPharmacistInPeriod(c);
		if(workSchedule == null) {
			return;
		}
		workSchedule.getScheduledConsultations().add(c);
		_workScheduleRepository.save(workSchedule);
		
	}
	
	@Override
	public Boolean addConsToWorkSchedule(Consultation c) {
		WorkSchedulePharmacist workSchedule = findWorkScheduleForPharmacistInPeriod(c);
		if(workSchedule == null) {
			return false;
		}
		workSchedule.getScheduledConsultations().add(c);
		_workScheduleRepository.save(workSchedule);
		return true;
	}
}
