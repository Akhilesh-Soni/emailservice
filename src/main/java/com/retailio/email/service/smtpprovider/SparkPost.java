package com.retailio.email.service.smtpprovider;


import com.retailio.email.service.Provider;

public class SparkPost implements Provider {
    @Override
    public boolean sendEmail() {
        System.out.println("Email sent by spark post");
        return true;
    }
}
