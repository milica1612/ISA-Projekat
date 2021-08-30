package rs.ac.uns.ftn.informatika.jpa.iservice;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintEmployeeDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.ComplaintPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintEmployee;
import rs.ac.uns.ftn.informatika.jpa.model.ComplaintPharmacy;

@Service
public interface IComplaintEmployeeService {

	ComplaintEmployee createComplaint(ComplaintEmployeeDTO complaintEmployeeDTO);

	ComplaintPharmacy createComplaintForPharmacy(ComplaintPharmacyDTO complaintPharmacyDTO);
}
