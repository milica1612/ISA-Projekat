package rs.ac.uns.ftn.informatika.jpa.service;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.jpa.model.Patient;
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
	

}