package rs.ac.uns.ftn.informatika.jpa.dto;

public class AvailablePharmacistsDTO {
	
	private String pharmacyId;
	private String date;
	private String time;
	
	public AvailablePharmacistsDTO(String pharmacyId, String date, String time) {
		super();
		this.pharmacyId = pharmacyId;
		this.date = date;
		this.time = time;
	}
	
	public AvailablePharmacistsDTO() {
		
	}

	public String getPharmacyId() {
		return pharmacyId;
	}

	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
