package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="dermatologist")
public class Dermatologist extends User {
	

	@ManyToMany(cascade = CascadeType.MERGE)
	public Set<Pharmacy> pharmacy;
   
   @Column(name = "rating")
	public Double rating;

	public Dermatologist(String firstName, String lastName, String userName, String password, String email,
			String phoneNumber, UserType userType, Address address, Double rating) {
		super(firstName, lastName, userName, password, email, phoneNumber, userType, address);
		this.pharmacy = new HashSet<Pharmacy>();
		this.rating = rating;
	}
	

	public Dermatologist()
	{
		
	}

	 public Double getRating() {
			return rating;
		}

		public void setRating(Double rating) {
			this.rating = rating;
		}
	public Collection<Pharmacy> getPharmacy() {
	      if (pharmacy == null)
	         pharmacy = new java.util.HashSet<Pharmacy>();
	      return pharmacy;
	   }
   
    public Iterator getIteratorPharmacy() {
       if (pharmacy == null)
           pharmacy = new java.util.HashSet<Pharmacy>();
       return pharmacy.iterator();
    }
   
    public void setPharmacy(Collection<Pharmacy> newPharmacy) {
       removeAllPharmacy();
       for (Iterator iter = newPharmacy.iterator(); iter.hasNext();)
          addPharmacy((Pharmacy)iter.next());
    }
   
    public void addPharmacy(Pharmacy newPharmacy) {
	      if (newPharmacy == null)
	         return;
	      if (this.pharmacy == null)
	         this.pharmacy = new HashSet<Pharmacy>();
	      if (!this.pharmacy.contains(newPharmacy))
	         this.pharmacy.add(newPharmacy);
   }
   
    public void removePharmacy(Pharmacy oldPharmacy) {
    	if (oldPharmacy == null)
    		return;
    	if (this.pharmacy != null)
    		if (this.pharmacy.contains(oldPharmacy))
    			this.pharmacy.remove(oldPharmacy);
    }
   
    public void removeAllPharmacy() {
    	if (pharmacy != null)
    		pharmacy.clear();
    }

}