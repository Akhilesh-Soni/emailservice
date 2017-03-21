package com.retailio.email.handler;


import com.retailio.email.service.EmailProvider;
import com.retailio.email.util.Email;

public class EmailHandler implements Handler {
    

    @Override
    public void handleEmail() {
        Email email = new Email();
        EmailProvider.submitEmail(email);

    }
}
