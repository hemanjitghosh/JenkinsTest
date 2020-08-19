package com.testreport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;







public class SendEmail  {

	static String key,data,from,to,password;
	static String[] AllToAdress;
	static String host = "smtp.gmail.com";


	public void GetData() throws IOException{

		File prop = new File("testdata/credentials.properties");
		FileInputStream input =new FileInputStream(prop);
		Properties props = new Properties();
		props.load(input);

		Enumeration value = props.keys();

		while(value.hasMoreElements()){
			key = (String) value.nextElement();
			data = props.getProperty(key);

			if(key.equals("to")){
				to=data;
			}
			if(key.equals("from")){
				from=data;
			}
			if(key.equals("password")){
				password=data;
			}

		}

		AllToAdress = to.split(",");

	}

	public void mail() throws IOException, AddressException, MessagingException{

		GetData();

		try{
			//	System properties	
			Properties SysmProp = System.getProperties();
			SysmProp.put("mail.smtp.starttls.enable", "true");
			SysmProp.put("mail.smtp.host", host);
			SysmProp.put("mail.smtp.user", from);
			SysmProp.put("mail.smtp.password", password);
			SysmProp.put("mail.smtp.port", "587");
			SysmProp.put("mail.smtp.auth", "true");


			//	Creating session and mime message object	
			//Session session = Session.getInstance(SysmProp);
			Session session = Session.getDefaultInstance(SysmProp);
			MimeMessage message = new MimeMessage(session) ;
			message.setFrom(new InternetAddress(from)); 

			//	Form Internet address array
			InternetAddress[] ia = new InternetAddress[AllToAdress.length];

			for(int i=0; i<AllToAdress.length;i++){
				ia[i] = new InternetAddress(AllToAdress[i]);		
			}

			for(int j=0;j<AllToAdress.length;j++){
				message.addRecipient(Message.RecipientType.TO, ia[j]);		
			}

			Date dt = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			String strDate= formatter.format(dt);  

			//	Set subject and body and adding attachments.
			message.setSubject("Execution report on "+strDate);	
			BodyPart messageBodyPart = new MimeBodyPart();	
			messageBodyPart.setText("Hello, Good day! \n"
					+ "\n"
					+ "All scenarios have been executed. Please find the attached report of the execution.  \n"
					+ "\n"
					+ "Thanks,\n"
					+ "Automation Selenium 2018");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			File file2 =new File("C:\\Bluestrata\\Abhishek-Project-s\\TestReport.html");
			/*messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(file2.getAbsolutePath());
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Report_"+strDate+".html");
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);

			//	Start transportation of message
			Transport trans = session.getTransport("smtp");
			trans.connect(host, from, password);
			trans.sendMessage(message, message.getAllRecipients());

			for(String address:AllToAdress){
				System.out.println("Mail has been sent to "+address);		
			}

			trans.close();*/
			@SuppressWarnings("deprecation")
			String filename = FileUtils.readFileToString(file2);
			 DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         message.setContent(multipart);
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
		}catch(AddressException ae ){
			System.out.println("Address exception: "+ae);
		}catch(MessagingException me){
			System.out.println("Messaging exception: "+me);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void SendMailWithAttachment() throws IOException
	{
		// Recipient's email ID needs to be mentioned.
	      String to = "automation.selenium.2018@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "automation.selenium.2018@gmail.com";

	      final String username = "automation.selenium.2018@gmail.com";//change accordingly
	      final String password = "automation2018";//change accordingly

	   // Create object of Property file
			Properties props = new Properties();
	 
			// this will set host of server- you can change based on your requirement 
			props.put("mail.smtp.host", "smtp.gmail.com");
	 
			// set the port of socket factory 
			props.put("mail.smtp.socketFactory.port", "465");
	 
			// set socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 
			// set the authentication to true
			props.put("mail.smtp.auth", "true");
	 
			// set the port of SMTP server
			props.put("mail.smtp.port", "465");
	 
			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,
	 
					new javax.mail.Authenticator() {
	 
						protected PasswordAuthentication getPasswordAuthentication() {
	 
						return new PasswordAuthentication(username, password);
	 
						}
	 
					});
	 
			try {
	 
				// Create object of MimeMessage class
				Message message = new MimeMessage(session);
	 
				// Set the from address
				message.setFrom(new InternetAddress(from));
	 
				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
	            
	                        // Add the subject link
				message.setSubject("Testing Subject");
	 
				// Create object to add multimedia type content
				BodyPart messageBodyPart1 = new MimeBodyPart();
	 
				// Set the body of email
				messageBodyPart1.setText("This is message body");
	 
				// Create another object to add another content
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	 
				// Mention the file which you want to send
				String filename = "C:\\Bluestrata\\Abhishek-Project-s\\TestReport.html";
	 
				// Create data source and pass the filename
				DataSource source = new FileDataSource(filename);
	 
				// set the handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
	 
				// set the file
				messageBodyPart2.setFileName(filename);
	 
				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();
	 
				// add body part 1
				multipart.addBodyPart(messageBodyPart2);
	 
				// add body part 2
				multipart.addBodyPart(messageBodyPart1);
	 
				// set the content
				message.setContent(multipart);
	 
				// finally send the email
				Transport.send(message);
	 
				System.out.println("=====Email Sent=====");
	 
			} catch (MessagingException e) {
	 
				throw new RuntimeException(e);
	 
			}
	}
	
	
	@SuppressWarnings("deprecation")
	public void sendmail() throws EmailException, IOException
	{
		
		/*File file =returnPath();
		String str = FileUtils.readFileToString(file);*/

		 EmailAttachment emailAttachment=new EmailAttachment();
	        emailAttachment.setPath("TestReport.html");
	        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
	        emailAttachment.setDescription("Picture Attachment");
	        emailAttachment.setName("Picture");
	       //Initialize a new multi part email instance
	        MultiPartEmail email=new MultiPartEmail();
	        //Set email host
	        email.setHostName("smtp.googlemail.com");
	        //Set email authentication username and password
	        email.setAuthenticator(new DefaultAuthenticator("automation.selenium.2018@gmail.com","automation2018"));
	        //Set email host SSL to true
	        email.setSSL(true);
	        try {
	            //Set From email address
	            email.setFrom("automation.selenium.2018@gmail.com");
	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	        //Set email Subject line
	        email.setSubject("Java Test Email");
	        try {
	            //Set Email Message
	            email.setMsg("This is a test from Java Email");
	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	        try {
	            //Set Email To Address
	            email.addTo("automation.selenium.2018@gmail.com");
	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	        //add the attachment
	        try {
	            email.attach(emailAttachment);
	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	        try {
	            //Send Email
	            email.send();
	        } catch (EmailException e) {
	            e.printStackTrace();
	        }
	}

}