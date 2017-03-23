package com.retailio.emailservice.serviceproviders.smtpprovider;


import com.retailio.emailservice.connector.EmailDto;
import com.retailio.emailservice.serviceproviders.Provider;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailGun implements Provider {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailGun.class);

    @Override
    public boolean sendEmail(final EmailDto emailDto) {
        Configuration configuration = new Configuration()
                .domain("postmaster@sandboxe4953a1822d74c408fe438002d0676ea.mailgun.org")
                .apiKey("key-7790f854d466e41c625b37d556a14b46")
                .from("Test account", emailDto.getFrom());
        Mail.using(configuration)
                .to(emailDto.getTo())
                .subject(emailDto.getSubject())
                .text(emailDto.getBody())
                .build()
                .send();
        LOGGER.info("Sent message successfully by MailGun API....");
        return true;
    }
}
