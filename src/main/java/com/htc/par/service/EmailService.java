package com.htc.par.service;

import org.springframework.stereotype.Service;

import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.utilities.EmailDetails;

@Service
public interface EmailService {
	
	/*public void sendSimpleMessage(String to,
                           String subject,
                           String text);
    
    public void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String ...templateArgs);
    
    public void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);*/
    
    public boolean sendEmail(EmailDetails emailDetails) throws ResourceNotFoundException, ResourceNotCreatedException;
    
}
