package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Contraindication {
   private String description;
   private Long contraindicationId;
   
public Contraindication(String description, Long contraindicationId) {
	super();
	this.description = description;
	this.contraindicationId = contraindicationId;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Long getContraindicationId() {
	return contraindicationId;
}
public void setContraindicationId(Long contraindicationId) {
	this.contraindicationId = contraindicationId;
}

}