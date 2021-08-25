package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IWorkSchedulePharmacistService;
import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
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
							Calendar endCons = Calendar.getInstance(); // creates calendar
							endCons.setTime(c.getDateAndTime());               // sets calendar time/date
							endCons.add(Calendar.MINUTE, c.getDuration());

							if(c.getCancelled() == true) {
								break;
							}else if(date.before(c.getDateAndTime())&& date.before(endCons.getTime())) {
								notAvailable = true;
								break;
							}else if(cal.after(c.getDateAndTime()) && cal.before(endCons.getTime())){
								notAvailable = true;
								break;
							}
						}
						if(notAvailable) {
							notAvailable = false;
						}else {
						pharmacies.add(workSchedule.getPharmacy());
						}
					
					}
			}
		}
		
	}
		return pharmacies;
}
}
