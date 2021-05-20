package rs.ac.uns.ftn.informatika.jpa.iservice;

import rs.ac.uns.ftn.informatika.jpa.dto.RegistrationRequest;
import rs.ac.uns.ftn.informatika.jpa.model.User;

public interface ISystemAdminService {

    public User createPharmacist(RegistrationRequest request);

    public User createSupplier(RegistrationRequest request);

    public User createDermatologist(RegistrationRequest request);
    
  //  public Pharmacy createPharmacy(PharmacyDTO request);
    
}
