package com.registration.kaval.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("karolisvalatka0@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);

        System.out.println("Email sent");
    }
}
