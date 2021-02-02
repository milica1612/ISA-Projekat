package rs.ac.uns.isaprojekat.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class PharmacyReport {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pharmacyRepId;
	
	//@Column(name = "income", nullable = false)
    private Double income;

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