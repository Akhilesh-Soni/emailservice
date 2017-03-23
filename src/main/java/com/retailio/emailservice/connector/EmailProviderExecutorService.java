package com.retailio.emailservice.connector;

import com.retailio.emailservice.util.EmailTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailProviderExecutorService {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public static void submitEmail(EmailTask emailTask) {

        EXECUTOR_SERVICE.submit(emailTask);
    }
}
