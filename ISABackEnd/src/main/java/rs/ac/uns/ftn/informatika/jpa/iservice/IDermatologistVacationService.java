package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistVacationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ResponseVacationDTO;
import rs.ac.uns.ftn.informatika.jpa.model.DermatologistVacation;

public interface IDermatologistVacationService {
	
	List<DermatologistVacationDTO> findAllDermatologistVacation();
	
	List<DermatologistVacationDTO> findAllDermatologistVacationWithStatusWaiting();
	
	DermatologistVacation accept(Long vacationId);
	
	DermatologistVacation decline(RequestDeclineDTO requestDeclineDTO);
	
	List<ResponseVacationDTO> isOnVacation(Long dermatologistId);
}
