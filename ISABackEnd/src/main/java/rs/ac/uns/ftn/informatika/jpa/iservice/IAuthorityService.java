package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.List;

import rs.ac.uns.ftn.informatika.jpa.model.Authority;

public interface IAuthorityService {

	List<Authority> findById(Long id);
	List<Authority> findByName(String name);
}
