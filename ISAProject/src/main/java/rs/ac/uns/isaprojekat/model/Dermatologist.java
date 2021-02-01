package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Dermatologist extends PharmacyEmployee {
   

	public java.util.Collection<Pharmacy> pharmacy;
	
   
	public Dermatologist(Double rating) {
		super(rating);
		this.pharmacy = new ArrayList<Pharmacy>();
	}

	public java.util.Collection<Pharmacy> getPharmacy() {
	      if (pharmacy == null)
	         pharmacy = new java.util.HashSet<Pharmacy>();
	      return pharmacy;
	   }
   
    public java.util.Iterator getIteratorPharmacy() {
       if (pharmacy == null)
           pharmacy = new java.util.HashSet<Pharmacy>();
       return pharmacy.iterator();
    }
   
    public void setPharmacy(java.util.Collection<Pharmacy> newPharmacy) {
       removeAllPharmacy();
       for (java.util.Iterator iter = newPharmacy.iterator(); iter.hasNext();)
          addPharmacy((Pharmacy)iter.next());
    }
   
    public void addPharmacy(Pharmacy newPharmacy) {
	      if (newPharmacy == null)
	         return;
	      if (this.pharmacy == null)
	         this.pharmacy = new java.util.HashSet<Pharmacy>();
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