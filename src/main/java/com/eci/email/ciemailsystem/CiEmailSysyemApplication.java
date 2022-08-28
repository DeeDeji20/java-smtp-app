package com.eci.email.ciemailsystem;

import com.eci.email.ciemailsystem.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CiEmailSysyemApplication {
    final
    EmailSenderService emailSenderService;

    public CiEmailSysyemApplication(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CiEmailSysyemApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public  void triggerMail(){
//        emailSenderService.sendEmail("deolaoladeji@gmail.com", "Hi from here", "D subject", "AEDC");
        emailSenderService.sendEmail("deolaoladeji@gmail.com", "Hi from here", "D subject", "AEDC");
    }
}
