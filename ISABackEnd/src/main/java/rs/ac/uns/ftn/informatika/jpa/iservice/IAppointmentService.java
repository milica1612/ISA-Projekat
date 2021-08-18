package rs.ac.uns.ftn.informatika.jpa.iservice;

import java.util.ArrayList;
import java.util.Set;

import rs.ac.uns.ftn.informatika.jpa.model.Appointment;

public interface IAppointmentService {

	public ArrayList<Appointment> getAppointmentsByPharmacy(Long pharmacyId);
}
