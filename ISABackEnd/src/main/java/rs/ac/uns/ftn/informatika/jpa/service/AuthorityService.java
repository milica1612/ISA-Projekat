package rs.ac.uns.ftn.informatika.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.iservice.IAuthorityService;
import rs.ac.uns.ftn.informatika.jpa.model.Authority;
import rs.ac.uns.ftn.informatika.jpa.repository.IAuthorityRepository;

@Service
public class AuthorityService implements IAuthorityService {

	@Autowired
	private IAuthorityRepository authorityRepository;
	
	@Override
	public Authority findById(Long id) {
		return authorityRepository.getOne(id);
	}

	@Override
	public Authority findByName(String name) {
		return authorityRepository.findByName(name);
	}

}
