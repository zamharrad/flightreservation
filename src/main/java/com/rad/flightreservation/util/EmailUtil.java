package com.rad.flightreservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    @Value("${com.rad.flightreservation.email.subject}")
    private String EMAIL_SUBJECT;

    @Value("${com.rad.flightreservation.email.body}")
    private String EMAIL_BODY;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendItinerary(String toAddress, String path) {
        LOGGER.info("Inside the sendItinerary()");
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setText(EMAIL_BODY);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.addAttachment("", new File(path));
            javaMailSender.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Exception inside the send itinerary "+e);
        }

    }
}
