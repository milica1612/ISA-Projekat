package rs.ac.uns.ftn.informatika.jpa.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "confirmation_tokens")
public class ConfirmationToken {
	
	@Id
	@SequenceGenerator(name = "mySeqGenConfirmationToken", sequenceName = "mySeqConfirmationToken", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenConfirmationToken")
	@Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    
    public ConfirmationToken() {}
    
    

    public ConfirmationToken(Long id, String confirmationToken, LocalDateTime createdDate, User users) {
		super();
		this.id = id;
		this.confirmationToken = confirmationToken;
		this.createdDate = createdDate;
		this.user = users;
	}



	public ConfirmationToken(User users) {
        this.user = users;
        createdDate = LocalDateTime.now();
        confirmationToken = UUID.randomUUID().toString();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}
    
}
