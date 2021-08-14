package rs.ac.uns.ftn.informatika.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rs.ac.uns.ftn.informatika.jpa.repository.IConfirmationTokenRepository;
import rs.ac.uns.ftn.informatika.jpa.iservice.IConfirmationTokenService;
import rs.ac.uns.ftn.informatika.jpa.model.ConfirmationToken;
import rs.ac.uns.ftn.informatika.jpa.model.User;

public class ConfirmationTokenService implements IConfirmationTokenService{
	
	private final IConfirmationTokenRepository iConfirmationTokenRepository;
	
	@Autowired
	public ConfirmationTokenService(IConfirmationTokenRepository iConfirmationTokenRepository) {
		this.iConfirmationTokenRepository = iConfirmationTokenRepository;
	}

	@Override
	public ConfirmationToken findByConfirmationToken(String confirmationToken) {
		for (ConfirmationToken confirmationTokenIteration : findAll())
			if (confirmationToken.equals(confirmationTokenIteration.getConfirmationToken()))
				return confirmationTokenIteration;
			
		return null;
	}

	@Override
	public ConfirmationToken saveConfirmationToken(User user) {
		return iConfirmationTokenRepository.save(new ConfirmationToken(user));
	}
	
	public List<ConfirmationToken> findAll() {
		return iConfirmationTokenRepository.findAll();
	}
}
