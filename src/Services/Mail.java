/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author grupo10sc
 */
public class Mail {

    public void sendHtmlEmail(String toAddress, String subject, String message, String pathChart)
            throws AddressException, MessagingException, IOException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("grupo10sc.inf513@gmail.com", "grupo10grupo10");
            }
        };
        Session session = Session.getInstance(properties, auth);
        try {
            MimeMessage mime = new MimeMessage(session);
            mime.setFrom(new InternetAddress("grupo10sc.inf513@gmail.com"));
            mime.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            mime.setSubject(subject);
            BodyPart texto = new MimeBodyPart();
            texto.setContent(message, "text/html");
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!pathChart.isEmpty()) {
                BodyPart adjunto = new MimeBodyPart();
                try {
                    adjunto.setDataHandler(new DataHandler(new FileDataSource(new File(pathChart))));
                    multiParte.addBodyPart(adjunto);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                adjunto.setFileName("Grafico");
            }
            mime.setContent(multiParte);
            System.out.println("Envie MAIL: to=" + toAddress + " subject=" + subject + " data:" + message);
            Transport.send(mime);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
