package com.retailio.emailservice.serviceproviders;

import com.retailio.emailservice.connector.EmailDto;

public interface Provider {

    public boolean sendEmail(EmailDto emailDto);
}
