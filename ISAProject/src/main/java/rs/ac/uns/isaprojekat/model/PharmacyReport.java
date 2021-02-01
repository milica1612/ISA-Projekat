package rs.ac.uns.isaprojekat.model;

import java.util.*;
	
	public class PharmacyReport {
	   private Double income;
	   private Long pharmacyRepId;
	   
	public PharmacyReport(Double income, Long pharmacyRepId) {
		super();
		this.income = income;
		this.pharmacyRepId = pharmacyRepId;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Long getPharmacyRepId() {
		return pharmacyRepId;
	}
	public void setPharmacyRepId(Long pharmacyRepId) {
		this.pharmacyRepId = pharmacyRepId;
	}
}