package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IDermatologistVacationService;
import rs.ac.uns.ftn.informatika.jpa.model.DermatologistVacation;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.repository.IDermatologistVacationRepository;

@Service
public class DermatologistVacationService implements IDermatologistVacationService {
	
	private IDermatologistVacationRepository _dermatologistVacationRepository;
	private EmailService _emailService;
	
	@Autowired
	public DermatologistVacationService(IDermatologistVacationRepository dermatologistVacationRepository, EmailService emailService) {
		this._dermatologistVacationRepository = dermatologistVacationRepository;
		this._emailService = emailService;
	}

	@Override
	public List<DermatologistVacation> findAllDermatologistVacation() {
		List<DermatologistVacation> list = _dermatologistVacationRepository.findAll();
		return list;
	}

	@Override
	public List<DermatologistVacation> findAllDermatologistVacationWithStatusWaiting() {
		List<DermatologistVacation> allVacation = _dermatologistVacationRepository.findAll();
		List<DermatologistVacation> list = new ArrayList<DermatologistVacation>();
		
		for (DermatologistVacation dVacation : allVacation) {
			if(dVacation.getStatus() == Status.WAITING) {
				list.add(dVacation);
			}
		}
		return list;
	}

	@Override
	public DermatologistVacation accept(Long vacationId) {
		DermatologistVacation dermatologistVacation = _dermatologistVacationRepository.getOne(vacationId);
		dermatologistVacation.setStatus(Status.ACCEPTED);
		if(sendAcceptedVacationEmail(dermatologistVacation))
			return _dermatologistVacationRepository.save(dermatologistVacation);
		
		return null;
	}

	private boolean sendAcceptedVacationEmail(DermatologistVacation dermatologistVacation) {
		try {
			_emailService.sendAcceptedVactionEmailForDermatologistAsync(dermatologistVacation);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	@Override
	public DermatologistVacation decline(RequestDeclineDTO requestDeclineDTO) {
		DermatologistVacation dermatologistVacation = _dermatologistVacationRepository.getOne(requestDeclineDTO.getVacationId());
		dermatologistVacation.setStatus(Status.DECLINED);
		if(sendDeclinedVacationEmail(dermatologistVacation, requestDeclineDTO.getExplanation()))
			return _dermatologistVacationRepository.save(dermatologistVacation);
		
		return null;
	}

	private boolean sendDeclinedVacationEmail(DermatologistVacation dermatologistVacation, String explanation) {
		try {
			_emailService.sendDeclinedVactionEmailForDermatologistAsync(dermatologistVacation, explanation);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

}
