package com.springexercise.springexercise.dto.mail;

import lombok.*;

@Data
@NoArgsConstructor
public class MailRequest {

    private String name;
    private String to ;
    private String from;
    private String subject;

    public MailRequest(String name, String to, String from, String subject) {
        this.name = name;
        this.to = to;
        this.from = from;
        this.subject = subject;
    }
}
