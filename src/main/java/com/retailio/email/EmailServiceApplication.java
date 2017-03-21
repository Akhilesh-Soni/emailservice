package com.retailio.email;

import com.retailio.email.connector.EmailConnector;
import com.retailio.email.handler.EmailHandler;
import com.retailio.email.service.ProviderFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EmailServiceApplication extends Application<EmailServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EmailServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "EmailService";
    }

    @Override
    public void initialize(final Bootstrap<EmailServiceConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EmailServiceConfiguration configuration,
                    final Environment environment) {
        ProviderFactory.initialize();
        environment.jersey().register(new EmailConnector(new EmailHandler()));

    }

}
