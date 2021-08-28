package rs.ac.uns.ftn.informatika.jpa.iservice;

import rs.ac.uns.ftn.informatika.jpa.model.Promotion;

public interface IPromotionService {
	
	Promotion savePromotionAndSendEmail(Promotion promotion);
	
	void subscribeToPharmacy(Long pharmacyId) throws Exception;
	
	void unsubscribeToPharmacy(Long pharmacyId) throws Exception;

}
