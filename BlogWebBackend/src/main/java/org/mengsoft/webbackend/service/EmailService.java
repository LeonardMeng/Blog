package org.mengsoft.webbackend.service;


import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
@Slf4j
public class EmailService {


    @Value("${reset.password.email.address}")
    private String email;
    @Value("${reset.password.email.password}")
    private String password;


    @Async("emailPoolTaskExecutor")
    public void SendEmail(long id) {
        try{
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
//
//            Session session = Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });

            Thread.sleep(3000);
            log.info("User " + id + " send success");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
