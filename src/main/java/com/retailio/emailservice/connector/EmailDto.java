package com.retailio.emailservice.connector;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * It contains following data for post request.<br>
 * {@link #from}<br>
 * {@link #to}<br>
 * {@link #subject}<br>
 * {@link #body}<br>
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDto {

    /**
     * Email address of the sender.
     **/
    @NotBlank(message = "can not be blank.")
    private final String from;

    /**
     * Email address of the recipient.
     **/
    @NotBlank(message = "can not be blank.")
    private final String to;

    /**
     * subject of the mail.
     **/
    @NotBlank(message = "can not be blank.")
    private final String subject;

    /**
     * body of the mail.
     **/
    @NotBlank(message = "can not be blank.")
    private final String body;


    @JsonCreator
    public EmailDto(@JsonProperty("from") final String from,
                    @JsonProperty("to") final String to,
                    @JsonProperty("subject") final String subject,
                    @JsonProperty("body") final String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
