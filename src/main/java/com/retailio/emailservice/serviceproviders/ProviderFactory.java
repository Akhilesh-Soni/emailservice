package com.retailio.emailservice.serviceproviders;


import com.retailio.emailservice.serviceproviders.smtpprovider.GoogleMail;
import com.retailio.emailservice.serviceproviders.smtpprovider.MailGun;
import com.retailio.emailservice.serviceproviders.smtpprovider.SendGrid;
import com.retailio.emailservice.serviceproviders.smtpprovider.SparkPost;

import java.util.ArrayList;
import java.util.List;

public class ProviderFactory {

    private final static List<Provider> PROVIDERS = new ArrayList<>();
    public final static int SIZE = 4;

    public static void initialize() {
        PROVIDERS.add(new SparkPost());
        PROVIDERS.add(new GoogleMail());
        PROVIDERS.add(new SendGrid());
        PROVIDERS.add(new MailGun());
    }

    public static List<Provider> getPROVIDERS() {
        return PROVIDERS;
    }
}
