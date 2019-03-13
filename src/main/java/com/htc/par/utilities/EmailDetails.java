package com.htc.par.utilities;

import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Component;

@Component
public class EmailDetails {

    private InternetAddress[] emailTo;
    private String emailSubject;
    private InternetAddress[] emailCC;
    private InternetAddress[] emailBCC;
    private String emailBody;

    public EmailDetails(){

    }
    
    
	public EmailDetails(InternetAddress[] emailTo, String emailSubject, InternetAddress[] emailCC,
			InternetAddress[] emailBCC, String emailBody) {
		super();
		this.emailTo = emailTo;
		this.emailSubject = emailSubject;
		this.emailCC = emailCC;
		this.emailBCC = emailBCC;
		this.emailBody = emailBody;
	}

	

	public EmailDetails(InternetAddress[] emailTo, String emailSubject, String emailBody) {
		super();
		this.emailTo = emailTo;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}

	

	public EmailDetails(InternetAddress[] emailTo, String emailSubject, InternetAddress[] emailCC, String emailBody) {
		super();
		this.emailTo = emailTo;
		this.emailSubject = emailSubject;
		this.emailCC = emailCC;
		this.emailBody = emailBody;
	}



	public InternetAddress[] getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(InternetAddress[] emailTo) {
		this.emailTo = emailTo;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public InternetAddress[] getEmailCC() {
		return emailCC;
	}

	public void setEmailCC(InternetAddress[] emailCC) {
		this.emailCC = emailCC;
	}

	public InternetAddress[] getEmailBCC() {
		return emailBCC;
	}

	public void setEmailBCC(InternetAddress[] emailBCC) {
		this.emailBCC = emailBCC;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

   
}