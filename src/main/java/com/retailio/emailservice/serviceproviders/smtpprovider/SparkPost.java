package com.retailio.emailservice.serviceproviders.smtpprovider;


import com.retailio.emailservice.connector.EmailDto;
import com.retailio.emailservice.serviceproviders.Provider;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SparkPost implements Provider {

    private static final Logger LOGGER = LoggerFactory.getLogger(SparkPost.class);

    @Override
    public boolean sendEmail(final EmailDto emailDto) {
        String API_KEY = "ee8de4c25d20522c087882dc87fc3577a9e0a2c4";
        Client client = new Client(API_KEY);

        try {
            client.sendMessage(
                    emailDto.getFrom(),
                    emailDto.getTo(),
                    emailDto.getSubject(),
                    emailDto.getBody(),
                    "");
            LOGGER.info("Sent message successfully by Spark Post API....");
        } catch (final SparkPostException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
        return true;
    }
}
