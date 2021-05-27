package com.assignment.OrderUseCase;

import java.util.logging.Logger;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TaskListnerforEmail implements TaskListener{

	
	private final Logger LOGGER = Logger.getLogger(TaskListnerforEmail.class.getName());
	
	 private static final String HOST = "smtp.gmail.com";
	    private static final String USER = "nitinborge5@gmail.com";
	    private static final String PWD = "owyorhgurkaleshv";
	    
	    
	@Override
	public void notify(DelegateTask arg0) {
		// TODO Auto-generated method stub
   // String assignee = arg0.getAssignee();
	     //   String taskId = arg0.getId();

	        /*if (assignee != null) {
	            IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
	            User user = identityService.createUserQuery().userId(assignee).singleResult();

	            if (user != null) {
	                String recipient = user.getEmail();*/
//	                Email email = new SimpleEmail();
//	                email.setCharset("utf-8");
//	                email.setHostName(HOST);
//	                email.setSmtpPort(587);
//	                email.setSSLCheckServerIdentity(true);
//	                email.setStartTLSEnabled(false);
//	                email.setAuthentication(USER, PWD);

	                Properties props = new Properties();
	                props.setProperty("mail.transport.protocol", "smtp");
	                props.setProperty("mail.host", "smtp.gmail.com");
	                props.put("mail.smtp.auth", "true");
	                props.put("mail.smtp.port", "465");
	                props.put("mail.debug", "true");
	                props.put("mail.smtp.socketFactory.port", "465");
	                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	                props.put("mail.smtp.socketFactory.fallback", "false");
	                Session session = Session.getDefaultInstance(props,
	                        new javax.mail.Authenticator() {
	                            protected PasswordAuthentication getPasswordAuthentication() {
	                                return new PasswordAuthentication(USER,PWD);
	                            }
	                        });


	                try {
//	                    email.setFrom("noreply@camunda.org");
//	                    email.setSubject("Task assigned: " + delegateTask.getName());
//	                    email.setMsg("Please complete: http://localhost:8085/camunda/app/tasklist/default/#/task=" + taskId);
//	                    email.addTo(recipient);
//	                    email.send();

	                	String recipient = "nitinborge5@gmail.com";
	                	
	                   Transport transport = session.getTransport();
	                    InternetAddress addressFrom = new InternetAddress(USER);

	                    MimeMessage message = new MimeMessage(session);
	                    message.setSender(addressFrom);
	                    message.setSubject("Task assigned: " + " to You");
	                    message.setContent("Please complete: task", "text/plain");
	                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

	                    transport.connect();
	                    Transport.send(message);
	                    transport.close();

	                    LOGGER.info("Task Assignment Email successfully sent to user '" + USER + "' with address '" + recipient + "'.");

	                } catch (Exception e) {
	                    LOGGER.log(Level.WARNING, "Could not send email to assignee", e);
	                }
	            
	}

}
