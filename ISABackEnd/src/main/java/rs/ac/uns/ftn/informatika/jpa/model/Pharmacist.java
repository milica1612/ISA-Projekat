package rs.ac.uns.ftn.informatika.jpa.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;


@Entity
public class Pharmacist extends PharmacyEmployee {
	private static final long serialVersionUID = -5330789200370606931L;
	
	@ManyToMany(fetch = FetchType.LAZY)
	public Set<Pharmacy> pharmacy;
	
	public Pharmacist(){}
	
    public Pharmacist(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Pharmacy pharmacy, Boolean enabled, Date lastResetPasswordDate, Boolean firstLogin) {
		super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address, enabled, lastResetPasswordDate, firstLogin);
		this.pharmacy = new HashSet<Pharmacy>();
    }

	public Set<Pharmacy> getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Set<Pharmacy> pharmacy) {
		this.pharmacy = pharmacy;
	}

}