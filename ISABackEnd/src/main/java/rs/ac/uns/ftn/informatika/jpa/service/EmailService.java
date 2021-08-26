package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Consultation;
import rs.ac.uns.ftn.informatika.jpa.model.DermatologistVacation;
import rs.ac.uns.ftn.informatika.jpa.model.Patient;
import rs.ac.uns.ftn.informatika.jpa.model.PharmacistVacation;
import rs.ac.uns.ftn.informatika.jpa.model.Promotion;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/*
	 * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
	 */
	@Autowired
	private Environment env;

	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
	 */
	
	@Async
	public void sendNotificaitionAsync(String emailAddress, String subject, String text) throws MailException, InterruptedException {
		
		System.out.println(env.getProperty("spring.mail.username")); // Email sa koga se salje
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailAddress);
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject(subject);
		mail.setText(text);
		javaMailSender.send(mail);
		System.out.println("Email successfully sent!");
	}

	public void sendPromotionEmailNotificationAsync(Promotion promotion, Patient subscribedPatient) {
		System.out.println(env.getProperty("spring.mail.username"));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(subscribedPatient.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject(promotion.getCaption());
		
		// konverzija datuma
		String startOfPromotion = new SimpleDateFormat("dd.MM.yyyy.").format(promotion.getStartOfPromotion());
	    String endOfPromotion = new SimpleDateFormat("dd.MM.yyyy.").format(promotion.getEndOfPromotion());
	        
		StringBuilder text = new StringBuilder();
		
		text.append("Dear " + subscribedPatient.getFirstName() + " "  + subscribedPatient.getLastName() + ",");
		text.append("\n\n");
		text.append(promotion.getContent());
		text.append("\nThe promotion will be active from " + startOfPromotion + " to " + endOfPromotion);
		text.append("\n\nYour pharmacy, " + promotion.getPharmacy().getName());
		
		mail.setText(text.toString());
		
		javaMailSender.send(mail);
		System.out.println("Promotion email successfully sent to subscribed user/patient!");
	}
	
	public void sendConsultationConfirmation(Consultation consultation) {
		System.out.println(env.getProperty("spring.mail.username"));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(consultation.getPatient().getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Consultation confirmation");
		
		String date = new SimpleDateFormat("dd.MM.yyyy. hh:mm:ss").format(consultation.getDateAndTime());
		StringBuilder text = new StringBuilder();
		
		text.append("Dear " + consultation.getPatient().getFirstName() + " "  + consultation.getPatient().getLastName() + ",");
		text.append("\n\n");
		text.append("\nYou have successfully scheduled a consultation.");
		text.append("\nConsultation information:");
		text.append("\nPHARMACY: " + consultation.getPharmacy().getName());
		text.append("\nDATE AND TIME: " + date);
		text.append("\nPHARMACIST: " + consultation.getPharmacist().getFirstName() + " " + consultation.getPharmacist().getLastName());
		text.append("\n\nYour pharmacy, " + consultation.getPharmacy().getName());
		
		mail.setText(text.toString());
		
		javaMailSender.send(mail);
		System.out.println("Confirmation email successfully sent to user/patient!");
	}


	public void sendAcceptedVactionEmailForPharmacistAsync(PharmacistVacation pharmacistVacation) {
		System.out.println(env.getProperty("spring.mail.username"));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(pharmacistVacation.getPharmacist().getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Accepted vacation");
		
		String startOfVacation = new SimpleDateFormat("dd.MM.yyyy.").format(pharmacistVacation.getStartDate());
	    String endOfVacation = new SimpleDateFormat("dd.MM.yyyy.").format(pharmacistVacation.getEndDate());
	        
		StringBuilder text = new StringBuilder();
		
		text.append("Dear " + pharmacistVacation.getPharmacist().getUserType() + ", " + pharmacistVacation.getPharmacist().getFirstName() + " "  + pharmacistVacation.getPharmacist().getLastName() + ",");
		text.append("\n\n");
		text.append("You are on vacation from  " + startOfVacation + " to " + endOfVacation + " .");
		text.append("\n\n\r\n"
				+ "All the best");
		
		mail.setText(text.toString());
		
		javaMailSender.send(mail);
		System.out.println("Accepted vacation email successfully sent!");
	}
	
	public void sendDeclinedVactionEmailForPharmacistAsync(PharmacistVacation pharmacistVacation, String explanation) {
		System.out.println(env.getProperty("spring.mail.username"));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(pharmacistVacation.getPharmacist().getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Declined vacation");
		
		StringBuilder text = new StringBuilder();
		
		text.append("Dear " + pharmacistVacation.getPharmacist().getUserType() + ", " + pharmacistVacation.getPharmacist().getFirstName() + " "  + pharmacistVacation.getPharmacist().getLastName() + ",");
		text.append("\n\n");
		text.append("Unfortunately, we had to decline your vacation request.");
		text.append("\nReson, " + explanation + ".");
		text.append("\nOf course, you still have the right to take advantage of your days off, but on another occasion.");
		text.append("\n\n\r\n"
				+ "Greeting");
		
		mail.setText(text.toString());
		
		javaMailSender.send(mail);
		System.out.println("Declined vacation email successfully sent!");
	}
	
	public void sendAcceptedVactionEmailForDermatologistAsync(DermatologistVacation dermatologistVacation) {
		System.out.println(env.getProperty("spring.mail.username"));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(dermatologistVacation.getDermatologist().getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Accepted vacation");
		
		String startOfVacation = new SimpleDateFormat("dd.MM.yyyy.").format(dermatologistVacation.getStartDate());
	    String endOfVacation = new SimpleDateFormat("dd.MM.yyyy.").format(dermatologistVacation.getEndDate());
	        
		StringBuilder text = new StringBuilder();
		
		text.append("Dear " + dermatologistVacation.getDermatologist().getUserType() + ", " + dermatologistVacation.getDermatologist().getFirstName() + " "  + dermatologistVacation.getDermatologist().getLastName() + ",");
		text.append("\n\n");
		text.append("You are on vacation from  " + startOfVacation + " to " + endOfVacation + " .");
		text.append("\n\n\r\n"
				+ "All the best");
		
		mail.setText(text.toString());
		
		javaMailSender.send(mail);
		System.out.println("Accepted vacation email successfully sent!");
	}
	
	
	public void sendDeclinedVactionEmailForDermatologistAsync(DermatologistVacation dermatologistVacation, String explanation) {
		System.out.println(env.getProperty("spring.mail.username"));
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(dermatologistVacation.getDermatologist().getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Declined vacation");
		
		StringBuilder text = new StringBuilder();
		
		text.append("Dear " + dermatologistVacation.getDermatologist().getUserType() + ", " + dermatologistVacation.getDermatologist().getFirstName() + " "  + dermatologistVacation.getDermatologist().getLastName() + ",");
		text.append("\n\n");
		text.append("Unfortunately, we had to decline your vacation request.");
		text.append("\nReson, " + explanation + ".");
		text.append("\nOf course, you still have the right to take advantage of your days off, but on another occasion.");
		text.append("\n\n\r\n"
				+ "Greeting");
		
		mail.setText(text.toString());
		
		javaMailSender.send(mail);
		System.out.println("Declined vacation email successfully sent!");
	}
	
}