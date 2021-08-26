package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.RequestDeclineDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IPharmacistVacationService;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacistVacation;
import rs.ac.uns.ftn.informatika.jpa.model.Status;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacistVacationRepository;

@Service
public class PharmacistVacationService implements IPharmacistVacationService {
	   
	private IPharmacistVacationRepository _pharmacistVacationRepository;
	
	@Autowired
	public PharmacistVacationService(IPharmacistVacationRepository pharmacistVacationRepository) {
		this._pharmacistVacationRepository = pharmacistVacationRepository;
	}
	
	@Override
	public List<PharmacistVacation> findAllPharmacistVacation() {
		List<PharmacistVacation> list = _pharmacistVacationRepository.findAll();
		return list;
	}
	
	@Override
	public List<PharmacistVacation> findAllPharmacistVacationWithStatusWaiting() {
		List<PharmacistVacation> allVacation = _pharmacistVacationRepository.findAll();
		List<PharmacistVacation> list = new ArrayList<PharmacistVacation>();
		
		for (PharmacistVacation pVacation : allVacation) {
			if(pVacation.getStatus() == Status.WAITING) {
				list.add(pVacation);
			}
		}
		return list;
	}

	public Boolean accept(Long vacationId) {
		// TODO Auto-generated method stub
		return true;
	}

	public Boolean decline(RequestDeclineDTO requestDeclineDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
