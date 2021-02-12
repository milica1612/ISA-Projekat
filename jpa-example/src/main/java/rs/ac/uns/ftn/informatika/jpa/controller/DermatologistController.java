package rs.ac.uns.ftn.informatika.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.dto.DermatologistDTO;
import rs.ac.uns.ftn.informatika.jpa.service.DermatologistService;

@RestController
@RequestMapping(value = "/dermatologists", produces = MediaType.APPLICATION_JSON_VALUE)
public class DermatologistController {
	
	private DermatologistService _dermatologistService;
	@Autowired
	public DermatologistController(DermatologistService dermatologistService) {
		this._dermatologistService = dermatologistService;
	}
	
	@GetMapping(path = "/all")
	public List<DermatologistDTO> getAllDermatologist(){
		return _dermatologistService.getAllDermatologist();
	}
}
