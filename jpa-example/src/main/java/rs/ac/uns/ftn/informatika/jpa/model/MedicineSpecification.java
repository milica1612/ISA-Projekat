package rs.ac.uns.ftn.informatika.jpa.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MedicineSpecification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medSpecId;
	
	private Double dosage;
	
	@ManyToMany(fetch = FetchType.LAZY)
	public Set<Contraindication> contraindication;
	
	@ManyToMany(fetch = FetchType.LAZY)
	public Set<Ingridient> ingridient;
   
    public MedicineSpecification(Double dosage, Long medSpecId) {
		super();
		this.dosage = dosage;
		this.medSpecId = medSpecId;
		this.contraindication = new HashSet<Contraindication>();
		this.ingridient = new HashSet<Ingridient>();
    }
    
    public MedicineSpecification(Double dosage) {
		super();
		this.dosage = dosage;
		this.contraindication = new HashSet<Contraindication>();
		this.ingridient = new HashSet<Ingridient>();
    }
    
    public MedicineSpecification()
    {
    	
    }
	
	public Double getDosage() {
		return dosage;
	}
	
	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}
	
	public Long getMedSpecId() {
		return medSpecId;
	}
	
	public void setMedSpecId(Long medSpecId) {
		this.medSpecId = medSpecId;
	}
	
	public Set<Contraindication> getContraindication() {
	      if (contraindication == null)
	         contraindication = new HashSet<Contraindication>();
	      return contraindication;
	   }
	   
	   public Iterator getIteratorContraindication() {
	      if (contraindication == null)
	         contraindication = new java.util.HashSet<Contraindication>();
	      return contraindication.iterator();
	   }
	   
	   public void setContraindication(Set<Contraindication> newContraindication) {
	      removeAllContraindication();
	      for (Iterator iter = newContraindication.iterator(); iter.hasNext();)
	         addContraindication((Contraindication)iter.next());
	   }
	   
	   public void addContraindication(Contraindication newContraindication) {
	      if (newContraindication == null)
	         return;
	      if (this.contraindication == null)
	         this.contraindication = new HashSet<Contraindication>();
	      if (!this.contraindication.contains(newContraindication))
	         this.contraindication.add(newContraindication);
	   }
	   
	   public void removeContraindication(Contraindication oldContraindication) {
	      if (oldContraindication == null)
	         return;
	      if (this.contraindication != null)
	         if (this.contraindication.contains(oldContraindication))
	            this.contraindication.remove(oldContraindication);
	   }
	   
	   public void removeAllContraindication() {
	      if (contraindication != null)
	         contraindication.clear();
	   }
	   public Set<Ingridient> getIngridient() {
	      if (ingridient == null)
	         ingridient = new HashSet<Ingridient>();
	      return ingridient;
	   }
	   
	   public Iterator getIteratorIngridient() {
	      if (ingridient == null)
	         ingridient = new java.util.HashSet<Ingridient>();
	      return ingridient.iterator();
	   }
	   
	   public void setIngridient(Set<Ingridient> newIngridient) {
	      removeAllIngridient();
	      for (Iterator iter = newIngridient.iterator(); iter.hasNext();)
	         addIngridient((Ingridient)iter.next());
	   }
	   
	   public void addIngridient(Ingridient newIngridient) {
	      if (newIngridient == null)
	         return;
	      if (this.ingridient == null)
	         this.ingridient = new HashSet<Ingridient>();
	      if (!this.ingridient.contains(newIngridient))
	         this.ingridient.add(newIngridient);
	   }
	   
	   public void removeIngridient(Ingridient oldIngridient) {
	      if (oldIngridient == null)
	         return;
	      if (this.ingridient != null)
	         if (this.ingridient.contains(oldIngridient))
	            this.ingridient.remove(oldIngridient);
	   }
	   
	   public void removeAllIngridient() {
	      if (ingridient != null)
	         ingridient.clear();
	   }
}