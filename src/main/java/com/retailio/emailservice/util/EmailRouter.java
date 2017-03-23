package com.retailio.emailservice.util;


import com.retailio.emailservice.serviceproviders.Provider;
import com.retailio.emailservice.serviceproviders.ProviderFactory;

import java.util.List;

public class EmailRouter {

    private final List<Provider> providers = ProviderFactory.getPROVIDERS();
    private static int count = 0;
    public void routeEmail(EmailTask emailTask) {


        while (!providers.get(count).sendEmail(emailTask.getEmailDto())) {
            try {
                //Take 2 second pause.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = ++count % ProviderFactory.SIZE;
        }
        System.out.println("Finally Sent");
    }
}
