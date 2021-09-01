package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.jpa.service.WorkScheduleDermatologistService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/workScheduleDermatologist", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkScheduleDermatologistController {

	private WorkScheduleDermatologistService _workScheduleDermatologist;

	@Autowired
	public WorkScheduleDermatologistController(WorkScheduleDermatologistService workScheduleDermatologist) {
		this._workScheduleDermatologist = workScheduleDermatologist;
	}
	
	
}
