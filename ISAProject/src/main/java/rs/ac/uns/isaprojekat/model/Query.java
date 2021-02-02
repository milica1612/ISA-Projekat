package rs.ac.uns.isaprojekat.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Entity
public class Query {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long queryId;
	public Medicine medicine;
   
	public Query(Long queryId, Medicine medicine) {
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
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
}