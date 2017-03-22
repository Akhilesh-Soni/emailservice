package com.retailio.email.service.smtpprovider;


import com.retailio.email.service.Provider;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;

public class MailGun implements Provider {

    @Override
    public boolean sendEmail() {
        System.out.println("Email Sent by mail gun");
        Configuration configuration = new Configuration()
                .domain("postmaster@sandboxe4953a1822d74c408fe438002d0676ea.mailgun.org")
                .apiKey("key-7790f854d466e41c625b37d556a14b46")
                .from("Test account", "akki28feb@live.com");
        Mail.using(configuration)
                .to("akki28feb@live.com")
                .subject("This is the subject")
                .text("Hello world!")
                .build()
                .send();
        return true;
    }

}
