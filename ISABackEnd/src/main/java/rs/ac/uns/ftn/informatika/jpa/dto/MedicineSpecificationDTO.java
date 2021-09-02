package rs.ac.uns.ftn.informatika.jpa.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Contraindication;
import rs.ac.uns.ftn.informatika.jpa.model.Ingridient;

public class MedicineSpecificationDTO {

	private Long id;
	
	private Double dosage;
	
	public String name;

	public String description;
	
	public MedicineSpecificationDTO() {}
	
	public MedicineSpecificationDTO(Long id, Double dosage, String name, String description) {
		super();
		this.id = id;
		this.dosage = dosage;
		this.name = name;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
