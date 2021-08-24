package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IPromotionService;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacyAdministrator;
import rs.ac.uns.ftn.informatika.jpa.model.Promotion;
import rs.ac.uns.ftn.informatika.jpa.repository.IPromotionRepository;

@Service
public class PromotionService implements IPromotionService {

	private EmailService _emailService;
	private IPromotionRepository _promotionRepository;
	private PatientService _patientService;
	
	@Autowired
	public PromotionService(EmailService emailService, IPromotionRepository iPromotionRepository, PatientService patientService) {
		this._emailService = emailService;
		this._promotionRepository = iPromotionRepository;
		this._patientService = patientService;	
	}

	@Override
	public Promotion savePromotionAndSendEmail(Promotion promotion) {
		Promotion p = _promotionRepository.save(promotion);
		
		if(sendPromotionEmail(p))
			return p;
		
		return null;
	}

	private boolean sendPromotionEmail(Promotion p) {
		// Kada se loguje korisnik setuju se podaci
		// SecurityContextHolder.getContext().setAuthentication(authentication);
		// User user = (User) authentication.getPrincipal();
		PharmacyAdministrator pAdmin = (PharmacyAdministrator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Patient> subscribedPatients = _patientService.findAllSubscribedPatientsByPharmacyId(pAdmin.getPharmacy().getPharmacyId());
		
		try {
			for (Patient subscribedPatient : subscribedPatients) {
				_emailService.sendPromotionEmailNotificationAsync(p, subscribedPatient);
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public void subscribeToPharmacy(Long pharmacyId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribeToPharmacy(Long pharmacyId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
