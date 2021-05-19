package rs.ac.uns.ftn.informatika.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="patient")
public class Patient extends User {

	@Column(name = "penalty")
	private int penalty;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Allergy allergy;
	   
	public Patient()
	{
		
	}
	public Patient(String firstName, String lastName, String userName, String password, String email,
				String phoneNumber, Long userId, UserType userType, Address address) {
			super(firstName, lastName, userName, password, email, phoneNumber, userId, userType, address);
			// TODO Auto-generated constructor stub
	}
	
	
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	public Allergy getAllergy() {
		return allergy;
	}
	public void setAllergy(Allergy allergy) {
		this.allergy = allergy;
	}


}