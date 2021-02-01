package rs.ac.uns.isaprojekat.model;

import java.util.*;

public class Query {
   private Long queryId;
   public Medicine[] medicine;
   
public Query(Long queryId, Medicine[] medicine) {
	super();
	this.queryId = queryId;
	this.medicine = medicine;
}
public Long getQueryId() {
	return queryId;
}
public void setQueryId(Long queryId) {
	this.queryId = queryId;
}
public Medicine[] getMedicine() {
	return medicine;
}
public void setMedicine(Medicine[] medicine) {
	this.medicine = medicine;
}

}