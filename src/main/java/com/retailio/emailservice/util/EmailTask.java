package com.retailio.emailservice.util;


import com.retailio.emailservice.connector.EmailDto;

public class EmailTask implements Runnable {

    private final EmailDto emailDto;

    public EmailTask(EmailDto emailDto) {
        this.emailDto = emailDto;
    }

    @Override
    public void run() {
        new EmailRouter().routeEmail(this);
    }

    public EmailDto getEmailDto() {
        return emailDto;
    }
}
