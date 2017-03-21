package com.retailio.email.service;

import com.retailio.email.util.Email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailProvider {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public static void submitEmail(Email email) {

        EXECUTOR_SERVICE.submit(email);
    }
}
