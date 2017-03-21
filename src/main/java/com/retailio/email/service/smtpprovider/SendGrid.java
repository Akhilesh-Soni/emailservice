package com.retailio.email.service.smtpprovider;


import com.retailio.email.service.Provider;

public class SendGrid implements Provider {
    @Override
    public boolean sendEmail() {
        System.out.println("Email sent by send grid");
        return false;
    }
}
