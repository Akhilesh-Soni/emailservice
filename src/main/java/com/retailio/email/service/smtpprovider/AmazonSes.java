package com.retailio.email.service.smtpprovider;

import com.retailio.email.service.Provider;

public class AmazonSes implements Provider {
    @Override
    public boolean sendEmail() {
        System.out.println("Email sent by amazon ses");
        return true;
    }
}
