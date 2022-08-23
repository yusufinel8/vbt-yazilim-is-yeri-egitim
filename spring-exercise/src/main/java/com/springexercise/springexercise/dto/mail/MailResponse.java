package com.springexercise.springexercise.dto.mail;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {

    private String message;
    private Boolean status;

}
