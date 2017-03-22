package com.retailio.email.service.smtpprovider;


import com.retailio.email.service.Provider;
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
    public boolean sendEmail() {
        Email from = new Email("akki28feb@gmail.com");
        String subject = "Hello World from the SendGrid Java Library!";
        Email to = new Email("akki28feb@gmail.com");
        Content content = new Content("text/plain", "Hello, Email!");
        Mail mail = new Mail(from, subject, to, content);

        com.sendgrid.SendGrid sg = new com.sendgrid.SendGrid
                ("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");
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            sg.api(request);
        } catch (final IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return true;
    }
}
