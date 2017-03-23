package com.retailio.emailservice.serviceproviders.smtpprovider;


import com.retailio.emailservice.connector.EmailDto;
import com.retailio.emailservice.serviceproviders.Provider;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SendGrid implements Provider {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendGrid.class);

    @Override
    public boolean sendEmail(final EmailDto emailDto) {
        Email from = new Email(emailDto.getFrom());
        Email to = new Email(emailDto.getTo());
        Content content = new Content("text/plain", emailDto.getBody());
        Mail mail = new Mail(from, emailDto.getSubject(), to, content);

        com.sendgrid.SendGrid sg = new com.sendgrid.SendGrid
                ("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");
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            sg.api(request);
            LOGGER.info("Sent message successfully by Send Grid API....");
        } catch (final IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return false;
        }
        return true;
    }
}
