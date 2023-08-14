package com.notification.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.entities.Mail;
import com.notification.entities.Notification;

@Service
public class NotificationService {
	
	@Autowired
	MailService mailService;
	
	//	Send the otp through mail
	public boolean sendNotification(Notification notification) {

		Mail mail = new Mail();
		mail.setMailFrom("arshiyashaik7869@gmail.com");

			mail.setMailTo("harshiyashaik@virtusa.com");
			mail.setMailSubject("Appointment Remainder");

			String content = "Hi Team,<br>"
					+ "This is to notify that [[appointmentLastRemainderCount]] remainder <br>"
					+ "Please take necessary action.<br>"
					+ "Thank you,<br>"
					+ "Arshiya.";
			
		
			content = content.replace("[[appointmentLastRemainderCount]]",notification.getAppointmentLastRemainderCount());
			
			
			mail.setMailContent(content);

			mailService.sendEmail(mail);
			return true;
		}
}