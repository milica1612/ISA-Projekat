package rs.ac.uns.ftn.informatika.jpa.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javassist.NotFoundException;
import rs.ac.uns.ftn.informatika.jpa.dto.EPrescriptionDTO;
import rs.ac.uns.ftn.informatika.jpa.model.EPrescription;
import rs.ac.uns.ftn.informatika.jpa.service.EPrescriptionService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/ePrescription", produces = MediaType.APPLICATION_JSON_VALUE)
public class EPrescriptionController {

	@Autowired
	public EPrescriptionService _ePrescriptionService;
	
	@PostMapping("/file")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    ResponseEntity<EPrescriptionDTO> searchDrugsBasedOnQRCode(@RequestParam("file") MultipartFile file) throws IOException, NotFoundException {

        if (!file.isEmpty()) {
            try {
                BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
                File destination = new File("src/main/resources/qrCodes/" + file.getOriginalFilename());
                ImageIO.write(src, "png", destination);
                String decodedText = _ePrescriptionService.decodeQRCode(new File("src/main/resources/qrCodes/" + file.getOriginalFilename()));
  
                if (decodedText == null) {
                    throw new IllegalArgumentException("Please upload valid QR code!");
                } else {
              /*      String code = _ePrescriptionService.getEReceiptCode(decodedText);
                    EPrescription ePrescription = _ePrescriptionService.findByCode(code);
                    if(ePrescription!=null) {
                        throw new IllegalArgumentException("This ePrescription is already used!");
                    }
                    
                   // ArrayList<QRCodeDTO> qrCodeDrugs = _ePrescriptionService.getDrugsInQRcode(decodedText);
                /*    if(qrCodeDrugs==null) {
                        throw new IllegalArgumentException("Please try later, there are no drugs!");
                    }
                    
                  //  ArrayList<MedicineAvai> pharmacyDrugAvailabilityDTOs = _ePrescriptionService.getAvailabilityInPharmacies(qrCodeDrugs);
                    EPrescriptionDTO ePrescriptionDTO = new EPrescriptionDTO(qrCodeDrugs,code,pharmacyDrugAvailabilityDTOs);
                    return pharmacyDrugAvailabilityDTOs == null ?
                            new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                            ResponseEntity.ok(ePrescriptionDTO);
*/
                }
            } catch (IOException | NotFoundException e) {
                throw new IllegalArgumentException("Please upload valid QR code!");}
        }
        throw new IllegalArgumentException("Please upload valid QR code!");
    }
	
}
