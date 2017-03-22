package com.retailio.email.connector;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Nonnull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDto {

    @Nonnull
    @NotBlank(message = "can not be blank.")
    private final String from;

    @Nonnull
    @NotBlank(message = "can not be blank.")
    private final String to;

    @Nonnull
    @NotBlank(message = "can not be blank.")
    private final String subject;

    @Nonnull
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
