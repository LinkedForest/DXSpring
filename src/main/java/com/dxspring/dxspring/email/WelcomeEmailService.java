package com.dxspring.dxspring.email;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WelcomeEmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail( String emailTo, String emailSubject, String emailBody ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dxspring.social@gmail.com");
        message.setTo(emailTo);
        message.setSubject(emailSubject);
        message.setText(emailBody);
        mailSender.send(message);
        System.out.println("Mail Sent Successfully");
    }
}
