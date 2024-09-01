package com.aurionpro.mapping.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String toEmail, String subject, String body) {
		 try {
			MimeMessage message = javaMailSender.createMimeMessage();
			 MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(message, true);
			 mimeMessageHelper.setFrom("devankhandagle@gmail.com");
			 mimeMessageHelper.setTo(toEmail);
			 mimeMessageHelper.setSubject(subject);
			 mimeMessageHelper.setText(body, true);
			javaMailSender.send(message);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
