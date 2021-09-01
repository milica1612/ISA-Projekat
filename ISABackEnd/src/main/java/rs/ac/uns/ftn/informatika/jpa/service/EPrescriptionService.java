package rs.ac.uns.ftn.informatika.jpa.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javassist.NotFoundException;
import rs.ac.uns.ftn.informatika.jpa.dto.MedicineAvailableInPharmacyDTO;
import rs.ac.uns.ftn.informatika.jpa.dto.QRCodeDTO;
import rs.ac.uns.ftn.informatika.jpa.iservice.IEPrescriptionService;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.model.Medicine;
import rs.ac.uns.ftn.informatika.jpa.model.Pharmacy;
import rs.ac.uns.ftn.informatika.jpa.repository.IEPrescriptionRepository;
import rs.ac.uns.ftn.informatika.jpa.repository.IPharmacyRepository;

@Service
public class EPrescriptionService implements IEPrescriptionService {

	@Autowired
	private IEPrescriptionRepository _ePrescriptionRepository;

	@Autowired
	private IPharmacyRepository _pharmacyRepository;
	
	@Override
	public void getPharmaciesForPatient(Long patientId, ArrayList<Pharmacy> result) {
		ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId) {
				if(!result.contains(ePrescription.getPharmacy())) {
					result.add(ePrescription.getPharmacy());
				}
			}
		}
		
	}

	@Override
	public void getMedicineForRating(Long patientId, ArrayList<Medicine> result) {
		/*ArrayList<EPrescription> all = (ArrayList<EPrescription>) _ePrescriptionRepository.findAll();
		for (EPrescription ePrescription : all) {
			if(ePrescription.getPatient().getUserId() == patientId) {
				if(!result.contains(ePrescription.getMedicine())) {
					result.add(ePrescription.getMedicine());
				}
			}
		}*/
	}

	@Override
	public EPrescription findByCode(String code) {
		return null;
	}
	
	public static String decodeQRCode(File qrCodeimage) throws IOException, NotFoundException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch ( com.google.zxing.NotFoundException n) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }

	@Override
	public ArrayList<QRCodeDTO> getQRCodeMedicine(String decodedText) {
		ArrayList<QRCodeDTO> qrCodeDTOs = new ArrayList<>();
		
		if(decodedText.contains(";")) {
			String []code = decodedText.split("!");
			String []medicines = code[1].split(";");
			
			for(String medicine : medicines) {
				String []medicineParts = medicine.split("_");
				
				qrCodeDTOs.add(new QRCodeDTO(medicineParts[0], medicineParts[1], Integer.parseInt(medicineParts[2])));
			}
		}
		else {
			String []code = decodedText.split("!");
			String []medicineParts = code[1].split("_");
			qrCodeDTOs.add(new QRCodeDTO(medicineParts[0], medicineParts[1], Integer.parseInt(medicineParts[2])));

		}
		
		return qrCodeDTOs;
	}

	@Override
	public ArrayList<MedicineAvailableInPharmacyDTO> getPharmacies(ArrayList<QRCodeDTO> qrCodeDTOs) {
		ArrayList<MedicineAvailableInPharmacyDTO> availablePharmacies = new ArrayList<MedicineAvailableInPharmacyDTO>();
		ArrayList<Pharmacy> pharmacies = (ArrayList<Pharmacy>) _pharmacyRepository.findAll();
		
		return null;
	}

		
}
