package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Supplier extends User {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<MedicineItem> medicineItem;
	
	public Supplier() {}

	public Supplier(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, Long userId, UserType userType, Address address, Boolean enabled) {
		super();
		this.medicineItem = new HashSet<MedicineItem>();
	}
	
	public Supplier(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, UserType userType, Address address) {
		super(firstName, lastName, userName, password, email, phoneNumber, userType, address);
		this.medicineItem = new HashSet<MedicineItem>();
	}
	
}