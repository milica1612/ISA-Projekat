package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.model.Ingridient;

public class MedicineSpecificationDTO {

	private Long id;
	
	private Double dosage;
	
	public HashSet<Contraindication> contraindication;

	public HashSet<Ingridient> ingridient;
	
	public MedicineSpecificationDTO() {}

	public MedicineSpecificationDTO(Long id, Double dosage, HashSet<Contraindication> contraindication, HashSet<Ingridient> ingridient) {
		super();
		this.id = id;
		this.dosage = dosage;
		this.contraindication = contraindication;
		this.ingridient = ingridient;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public Set<Contraindication> getContraindication() {
		return contraindication;
	}

	public void setContraindication(HashSet<Contraindication> contraindication) {
		this.contraindication = contraindication;
	}

	public Set<Ingridient> getIngridient() {
		return ingridient;
	}

	public void setIngridient(HashSet<Ingridient> ingridient) {
		this.ingridient = ingridient;
	}
	
}
