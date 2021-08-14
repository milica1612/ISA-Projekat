package rs.ac.uns.ftn.informatika.jpa.iservice;

import rs.ac.uns.ftn.informatika.jpa.model.Authority;

public interface IAuthorityService {
	Authority findById(Long id);
	Authority findByName(String name);
}
