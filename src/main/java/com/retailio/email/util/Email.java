package com.retailio.email.util;


import com.retailio.email.service.EmailProvider;
import com.retailio.email.service.ProviderFactory;

public class Email implements Runnable {
    @Override
    public void run() {
        new EmailRouter().routeEmail(this);
    }
}
