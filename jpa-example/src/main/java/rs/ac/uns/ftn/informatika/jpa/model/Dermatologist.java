package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Dermatologist extends PharmacyEmployee {
	
   @ManyToMany(fetch = FetchType.LAZY)
	public Set<Pharmacy> pharmacy;
	
   
	public Dermatologist(Double rating) {
		super(rating);
		this.pharmacy = new HashSet<Pharmacy>();
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