package br.com.mundo_organico.Mundo_Organico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
    @Autowired
    JavaMailSender emailSenderA;


    public void sendRequestAlterPassword(String destino, String verificador) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("mundorganicoc@gmail.com");
            message.setTo(destino);
            message.setSubject("Redefinição de senha");
            message.setText("Para redefinir sua senha digite o código: " + verificador);

            emailSenderA.send(message);

        } catch (MailException e) {
            e.printStackTrace();
        }

    }

}
