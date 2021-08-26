package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.model.DermatologistVacation;

public interface IDermatologistVacationService {
	
	List<DermatologistVacation> findAllDermatologistVacation();
	
	List<DermatologistVacation> findAllDermatologistVacationWithStatusWaiting();
	
	DermatologistVacation accept(Long vacationId);
	
	DermatologistVacation decline(RequestDeclineDTO requestDeclineDTO);
}
