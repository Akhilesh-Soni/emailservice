package com.retailio.email.connector;


import com.retailio.email.handler.EmailHandler;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/email")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmailConnector {

    private final EmailHandler emailHandler;

    public EmailConnector(final EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @POST
    public Response deliverEmail(@Valid EmailDto emailDto) {
        emailHandler.handleEmail();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
