package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IWorkSchedulePharmacistService;
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
			
			Calendar cal = Calendar.getInstance(); // creates calendar
			cal.setTime(date);               // sets calendar time/date
			cal.add(Calendar.MINUTE, 30);
			
			if(valid.getStartDate().before(date) && valid.getEndDate().after(date)) {
				System.out.println(shift.getStartDate().getHours());
				System.out.println(date.getHours());
				if(shift.getStartDate().getHours() < date.getHours()) {
					if(shift.getEndDate().getHours() > cal.getTime().getHours()) {
						pharmacies.add(workSchedule.getPharmacy());
						}
					
					}
			}
		}
		return pharmacies;
	}
}
