package rs.ac.uns.ftn.informatika.jpa.model;

public class UserTokenState {
	private String role;
	private String accessToken;
	private Long expiresIn;
	
	public UserTokenState() {
		this.role = "NONE";
		this.accessToken = null;
		this.expiresIn = null;
	}
	
	public UserTokenState(String role, String accessToken, long expiresIn) {
		this.role = role.equals("DERMATOLOGIST") || role.equals("PHARMACIST") || role.equals("PH_ADMINISTRATOR") || role.equals("SYS_ADMINISTRATOR")
				|| role.equals("ROLE_PATIENT") || role.equals("SUPPLIER") ? role : "NONE";
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	
}
