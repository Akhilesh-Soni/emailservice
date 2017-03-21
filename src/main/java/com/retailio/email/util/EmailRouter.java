package com.retailio.email.util;


import com.retailio.email.service.Provider;
import com.retailio.email.service.ProviderFactory;

import java.util.List;

public class EmailRouter {

    private final List<Provider> providers = ProviderFactory.getPROVIDERS();

    public void routeEmail(Email email) {

        int count = 0;
        while (!providers.get(count).sendEmail()) {
            try {
                //Waiting for 2 Second
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = ++count % ProviderFactory.SIZE;
        }
        System.out.println("Finally Sent");
    }
}
