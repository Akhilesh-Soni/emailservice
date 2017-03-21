package com.retailio.email.service.smtpprovider;


import com.retailio.email.service.Provider;

public class MailGun implements Provider {
    @Override
    public boolean sendEmail() {
        System.out.println("Email Sent by mail gun");

        return false;
    }
}
