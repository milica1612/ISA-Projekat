package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Ingridient {
   private String name;
   private Long ingridientId;
   
   
public Ingridient(String name, Long ingridientId) {
	super();
	this.name = name;
	this.ingridientId = ingridientId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Long getIngridientId() {
	return ingridientId;
}
public void setIngridientId(Long ingridientId) {
	this.ingridientId = ingridientId;
}

}