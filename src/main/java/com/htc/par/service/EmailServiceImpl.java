package com.htc.par.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.utilities.EmailDetails;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

   /* public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               SimpleMailMessage template,
                                               String ...templateArgs) {
        String text = String.format(template.getText(), templateArgs);  
        sendSimpleMessage(to, subject, text);
    }

    @Override
    public void sendMessageWithAttachment(String to,
                                          String subject,
                                          String text,
                                          String pathToAttachment) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }*/

	@Override
	public boolean sendEmail(EmailDetails emailDetails) throws ResourceNotFoundException, ResourceNotCreatedException {
		boolean mailStatus=false;
		MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        try {
				helper.setTo(emailDetails.getEmailTo());
				helper.setText(emailDetails.getEmailBody());
				helper.setSubject(emailDetails.getEmailSubject());

				if(emailDetails.getEmailCC()!= null){
				    helper.setCc(emailDetails.getEmailCC());
				}
				
				if(emailDetails.getEmailBCC()!= null){
				    helper.setCc(emailDetails.getEmailBCC());
				}


				emailSender.send(message);
				mailStatus=true;
			} catch (MailException e) {
				 throw new  ResourceNotCreatedException("Failed to send Email Contact support team "+e.getMessage());
			} catch (MessagingException e) {
				 throw new  ResourceNotFoundException("Invalid Recrutier Email id"+e.getMessage());
			}
	return 	mailStatus;
	}
    
}
