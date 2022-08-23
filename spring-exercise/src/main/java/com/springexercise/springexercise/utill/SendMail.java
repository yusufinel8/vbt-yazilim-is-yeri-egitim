package com.springexercise.springexercise.utill;

import com.springexercise.springexercise.dto.mail.MailRequest;
import com.springexercise.springexercise.dto.mail.MailResponse;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SendMail {

    private final JavaMailSender sender;

    private final Configuration configuration;

    public MailResponse sendEmail(MailRequest mailRequest) {
        MailResponse response = new MailResponse();
        MimeMessage message = sender.createMimeMessage();

        int min = 100000;
        int max = 999999;

        int kod = ThreadLocalRandom.current().nextInt(min, max + 1);
        String code = String.valueOf(kod);
        try {

            MimeMessageHelper helper = new MimeMessageHelper(message);
            Template template = configuration.getTemplate("Email.ftlh");

            Map<String, Object> model = new HashMap<>();
            model.put("Name", mailRequest.getName());
            model.put("kod", code);

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setTo(mailRequest.getTo());
            helper.setText(html, true);
            helper.setSubject(mailRequest.getSubject());
            helper.setFrom(mailRequest.getFrom());

            sender.send(message);
            response.setMessage("Mail send to   : " + mailRequest.getTo());
            response.setStatus(Boolean.TRUE);

        } catch (MessagingException | IOException | TemplateException e) {

            response.setMessage("Mail failure    : " + e.getMessage());
            response.setStatus(Boolean.FALSE);
        }

        return response;
    }


}
