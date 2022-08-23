package com.springexercise.springexercise.service;

import com.springexercise.springexercise.dto.mail.MailRequest;
import com.springexercise.springexercise.dto.mail.MailResponse;

import java.util.Map;

public interface SendEmail {
    
    public MailResponse sendEmail(MailRequest mailRequest);
}
