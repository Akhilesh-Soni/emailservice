package com.retailio.email.connector;


import com.retailio.email.handler.EmailHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/email")
public class EmailConnector {

    private final EmailHandler emailHandler;

    public EmailConnector(final EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @GET
    @Produces("text/plain")
    public String hello() {
        emailHandler.handleEmail();
        return "hello";
    }
}
