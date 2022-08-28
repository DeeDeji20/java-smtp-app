package com.eci.email.ciemailsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String toEmail,
                          String body,
                          String subject,
                          String from){
        String emailFrom;
        switch (from){
            case "AEDC"-> emailFrom= "noreply@aedc.com";
            case "BEDC"-> emailFrom= "noreply@bedc.com";
            case "EKEDP"-> emailFrom= "noreply@ekedp.com";
            default -> emailFrom = "noreply@cicod.com";
            
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setFrom(emailFrom);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        mailSender.send(simpleMailMessage);
        System.out.println("Sent");


    }
}
