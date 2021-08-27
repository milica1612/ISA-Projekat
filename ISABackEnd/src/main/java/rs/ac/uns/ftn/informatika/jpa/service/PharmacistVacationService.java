package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.PharmacistVacationDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacistVacationService;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacistVacation;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacistVacationRepository;

@Service
public class PharmacistVacationService implements IPharmacistVacationService {
	   
	private IPharmacistVacationRepository _pharmacistVacationRepository;
	private EmailService _emailService;
	@Autowired
	public PharmacistVacationService(IPharmacistVacationRepository pharmacistVacationRepository, EmailService emailService) {
		this._pharmacistVacationRepository = pharmacistVacationRepository;
		this._emailService = emailService;
	}
	
	@Override
	public List<PharmacistVacation> findAllPharmacistVacation() {
		List<PharmacistVacation> list = _pharmacistVacationRepository.findAll();
		return list;
	}
	
	@Override
	public List<PharmacistVacationDTO> findAllPharmacistVacationWithStatusWaiting() {
		List<PharmacistVacation> allVacation = _pharmacistVacationRepository.findAll();
		List<PharmacistVacationDTO> list = new ArrayList<PharmacistVacationDTO>();
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		for (PharmacistVacation pVacation : allVacation) {
			if(pVacation.getStatus() == Status.WAITING && pVacation.getPharmacist().getPharmacy().getPharmacyId() == pAdmin.getPharmacy().getPharmacyId()) {
				String startDate = new SimpleDateFormat("dd.MM.yyyy.").format(pVacation.getStartDate());
				String endDate = new SimpleDateFormat("dd.MM.yyyy.").format(pVacation.getEndDate());
				PharmacistVacationDTO pVacationDTO = new PharmacistVacationDTO(pVacation.getVacationId(), pVacation.getPharmacist().getUserId(), pVacation.getPharmacist().getFirstName(), pVacation.getPharmacist().getLastName(), pVacation.getPharmacist().getEmail(), startDate, endDate, pVacation.getStatus());
				list.add(pVacationDTO);
			}
		}
		return list;
	}

	public PharmacistVacation accept(Long vacationId) {
		
		PharmacistVacation pharmacistVacation = _pharmacistVacationRepository.getOne(vacationId);
		pharmacistVacation.setStatus(Status.ACCEPTED);
		if(sendAcceptedVacationEmail(pharmacistVacation))
			return _pharmacistVacationRepository.save(pharmacistVacation);
		
		return null;
	}

	private boolean sendAcceptedVacationEmail(PharmacistVacation pharmacistVacation) {
		try {
			_emailService.sendAcceptedVactionEmailForPharmacistAsync(pharmacistVacation);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	public PharmacistVacation decline(RequestDeclineDTO requestDeclineDTO) {
		PharmacistVacation pharmacistVacation = _pharmacistVacationRepository.getOne(requestDeclineDTO.getVacationId());
		pharmacistVacation.setStatus(Status.DECLINED);
		if(sendDeclinedVacationEmail(pharmacistVacation, requestDeclineDTO.getExplanation()))
			return _pharmacistVacationRepository.save(pharmacistVacation);
		
		return null;
	}

	private boolean sendDeclinedVacationEmail(PharmacistVacation pharmacistVacation, String explanation) {
		try {
			_emailService.sendDeclinedVactionEmailForPharmacistAsync(pharmacistVacation, explanation);
			return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}
}
