package com.retailio.email.service;


import com.retailio.email.service.smtpprovider.AmazonSes;
import com.retailio.email.service.smtpprovider.MailGun;
import com.retailio.email.service.smtpprovider.SendGrid;
import com.retailio.email.service.smtpprovider.SparkPost;

import java.util.ArrayList;
import java.util.List;

public class ProviderFactory {

    private final static List<Provider> PROVIDERS = new ArrayList<>();
    public final static int SIZE = 4;

    public static void initialize() {
        PROVIDERS.add(new SendGrid());
        PROVIDERS.add(new MailGun());
        PROVIDERS.add(new SparkPost());
        PROVIDERS.add(new AmazonSes());
    }

    public static List<Provider> getPROVIDERS() {
        return PROVIDERS;
    }
}
