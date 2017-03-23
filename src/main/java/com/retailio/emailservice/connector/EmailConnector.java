package com.retailio.emailservice.connector;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * It is the rest resource exposed to send the mail.
 **/

@Path("/send-email")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmailConnector {

    private final EmailHandler emailHandler;

    public EmailConnector(final EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    /**
     * Entry point to send the mail.
     * It will validate the request body {@link EmailDto}
     * <br>
     * Example of JSON payload:
     * <p>
     * {<br>
     * "from" : "testemailforcode@gmail.com",<br>
     * "to" : "akki28feb@gmail.com",<br>
     * "subject" : "Testing Email Via Rest API",<br>
     * "body" : "Hi, How you doing?"<br>
     * }
     *
     * @return {@link Response} <br>
     * 204 if successful<br>
     * 422 if {@link EmailDto} validation failed
     **/
    @POST
    public Response deliverEmail(@Valid EmailDto emailDto) {
        emailHandler.handleEmail(emailDto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
