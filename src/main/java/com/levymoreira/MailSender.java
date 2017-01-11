package com.levymoreira;

import org.joda.time.LocalDateTime;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    public static void sendMail(String text) {
        final String username = ""; //your mail like levymoreira.ce@gmail.clom
        final String password = ""; //your password like xxxxxxkjfslkjfsfjkxx

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(username)); //add here if more someone need receive the mail
            message.setSubject("GNIB !!! GNIB !!! CORRE!!! ");
            message.setText(text);

            Transport.send(message);

            System.out.println("**************************************************************");
            System.out.println("**************************************************************");
            System.out.println("Mail sent. (" + new LocalDateTime().toString("dd/MM/yyyy hh:mm:ss") + "): " + text);
            System.out.println("**************************************************************");
            System.out.println("**************************************************************");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
