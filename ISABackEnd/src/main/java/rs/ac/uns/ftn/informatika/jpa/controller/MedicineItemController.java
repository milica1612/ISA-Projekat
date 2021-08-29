package rs.ac.uns.ftn.informatika.jpa.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/medicineItem", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedicineItemController {

	public MedicineItemController() {
		// TODO Auto-generated constructor stub
	}

}
