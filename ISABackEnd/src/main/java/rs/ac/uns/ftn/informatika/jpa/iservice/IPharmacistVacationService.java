package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacistVacation;

public interface IPharmacistVacationService {
	
	List<PharmacistVacation> findAllPharmacistVacation();
	
	List<PharmacistVacation> findAllPharmacistVacationWithStatusWaiting();
	
	PharmacistVacation accept(Long vacationId);
	
	PharmacistVacation decline(RequestDeclineDTO requestDeclineDTO);
}
