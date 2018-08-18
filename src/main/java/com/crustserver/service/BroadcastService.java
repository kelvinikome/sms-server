package com.crustserver.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class BroadcastService {
	
	@Autowired
	private JavaMailSender sender;
	private String admissionLetter = 
			"[Recipient Name]\n" + 
			"[Title]\n" + 
			"[Company Name]\n" + 
			"[Street Address]\n" + 
			"[City, ST Zip Code]\n" + 
			"Dear [Recipient]:\n" + 
			"We are pleased to inform you that you have been offered a spot in the class of 2015 for the University of Oklahoma!\n" + 
			"After reviewing your application and all the supporting documents, we have determined that you are exactly the kind of student that we are looking for to carry on the University of Oklahoma tradition.\n" + 
			"Attached to this letter you will find a full admissions package, along with specific information on how to accept this offer. We ask that you respond within 4 weeks, as there are many other candidates who are waiting for any unaccepted spots!\n" + 
			"Once again, congratulations. We hope to hear from you soon!\n" + 
			"\n" + 
			"Sincerely,\n" + 
			"University";

	public boolean sendEmail(String subject, String recipient, String content) {
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(recipient);
			helper.setText(content);
			helper.setSubject(subject);
			sender.send(message);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	public void broadCastMail(List<String> list, final String content) {
		if (!list.isEmpty())
		list.stream().forEach(address -> {
			try {
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);
				helper.setTo(address);
				helper.setText(content);
				helper.setSubject("School Admission");
				sender.send(message);
			}catch(Exception ex) {
				
			}
		});
	}

	public void broadCastMail(String address, final String content) {
		if (!address.isEmpty())
			try {
				MimeMessage message = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);
				helper.setTo(address);
				helper.setText(content);
				helper.setSubject("School Admission");
				sender.send(message);
			}catch(Exception ex) {
				
			}
	}

	public String getAdmissionLetter() {
		return admissionLetter;
	}

	public void setAdmissionLetter(String admissionLetter) {
		this.admissionLetter = admissionLetter;
	}
	
	

}
