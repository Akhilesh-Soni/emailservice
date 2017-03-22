package com.retailio.email.service.smtpprovider;


import com.retailio.email.service.Provider;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SparkPost implements Provider {

    private static final Logger LOGGER = LoggerFactory.getLogger(SparkPost.class);

    @Override
    public boolean sendEmail() {
        System.out.println("Email sent by spark post");
        String API_KEY = "ee8de4c25d20522c087882dc87fc3577a9e0a2c4";
        Client client = new Client(API_KEY);

        try {
            client.sendMessage(
                    "postmaster@mydomain.com",
                    "akki28feb@live.com",
                    "Spark Post Mail",
                    "Hi, its my first Mail",
                    "");
        } catch (final SparkPostException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }

        return true;
    }
}
