package com.springexercise.springexercise.service.impl;

import com.springexercise.springexercise.utill.SendMail;
import com.springexercise.springexercise.dto.mail.MailRequest;
import com.springexercise.springexercise.dto.mail.MailResponse;
import com.springexercise.springexercise.service.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SendEmailimpl implements SendEmail {

    private final SendMail sendMail;

    @Override
    public MailResponse sendEmail(MailRequest mailRequest) {
        return sendMail.sendEmail(mailRequest);
    }


}
