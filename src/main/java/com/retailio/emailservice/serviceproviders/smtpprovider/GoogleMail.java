package com.retailio.emailservice.serviceproviders.smtpprovider;

import com.retailio.emailservice.connector.EmailDto;
import com.retailio.emailservice.serviceproviders.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GoogleMail implements Provider {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleMail.class);

    @Override
    public boolean sendEmail(final EmailDto emailDto) {

        final String username = "testemailforcode@gmail.com";
        final String password = "Test@123456";


        // Recipient's emailservice ID needs to be mentioned.
        String to = emailDto.getTo();

        // Sender's emailservice ID needs to be mentioned
        String from = emailDto.getFrom();

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");


        // Get the default Session object.
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(emailDto.getSubject());

            // Now set the actual message
            message.setText(emailDto.getBody());

            // Send message
            Transport.send(message);
            LOGGER.info("Sent message successfully by Java Mail API....");
        } catch (final MessagingException mex) {
            LOGGER.error(mex.getMessage(), mex);
            return false;
        }
        return true;
    }
}