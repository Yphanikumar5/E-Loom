package com.my.utility;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class MailService 
{
	private static final String smtpServer = "smtp.gmail.com";
	private static final String default_from = "support@loadindia.com";
	private static final String gmail_user = "tckreddy89@gmail.com";
	private static final String gmail_password = "TCKREDDY89#@";
	private static final String smtp_port = "465";
	private static final String ssl_factory = "javax.net.ssl.SSLSocketFactory";
	public String send( String p_to, 
            String p_subject, String p_message) 
	{
		String l_result = "<BR><BR><BR><BR><BR><BR><BR>";

		String l_host = "smtp.gmail.com";
		String p_from = "tckreddy89@gmail.com";
		// Gets the System properties
		


		//Puts the SMTP server name to properties object
		Properties props = new Properties();
	    props.put("mail.smtp.host", smtpServer);
	    props.put("mail.smtp.user", gmail_user);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.port", smtp_port);
	    props.put("mail.smtp.socketFactory.port", smtp_port);
	    props.put("mail.smtp.socketFactory.class", ssl_factory);
	    props.put("mail.smtp.socketFactory.fallback", "false");
		//Get the default Session using Properties Object
		Session l_session = Session.getDefaultInstance(props, getAuth());

		l_session.setDebug(true); // Enable the debug mode

		try {
				MimeMessage l_msg = new MimeMessage(l_session); // Create a New message

				//l_msg.setFrom(new InternetAddress(p_from)); // Set the From address

				// Setting the "To recipients" addresses
				l_msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(p_to, false));

					// Setting the "Cc recipients" addresses
				
				l_msg.setSubject(p_subject); // Sets the Subject

				// Create and fill the first message part
				MimeBodyPart l_mbp = new MimeBodyPart();
				l_mbp.setText(p_message);

				// Create the Multipart and its parts to it
				Multipart l_mp = new MimeMultipart();
				l_mp.addBodyPart(l_mbp);


				// Add the Multipart to the message
				l_msg.setContent(l_mp);

				// Set the Date: header
				l_msg.setSentDate(new Date());

				// Send the message
				Transport.send(l_msg);
				// If here, then message is successfully sent.
				// Display Success message
				l_result = l_result + "<FONT SIZE=4 COLOR=\"blue\"><B>Success!</B>"+
				"<FONT SIZE=4 COLOR=\"black\"> "+

				"<HR><FONT color=green><B>Mail was successfully sent to </B></FONT>: "+p_to+"<BR>";
				//if CCed then, add html for displaying info
				
				l_result = l_result+"<BR><HR>";
		} catch (MessagingException mex) { // Trap the MessagingException Error
			// If here, then error in sending Mail. Display Error message.
			l_result = l_result + "<FONT SIZE=4 COLOR=\"blue\"> <B>Error : </B><BR><HR> "+
			"<FONT SIZE=3 COLOR=\"black\">"+mex.toString()+"<BR><HR>";
		} catch (Exception e) {

			// If here, then error in sending Mail. Display Error message.
			l_result = l_result + "<FONT SIZE=4 COLOR=\"blue\"> <B>Error : </B><BR><HR> "+
			"<FONT SIZE=3 COLOR=\"black\">"+e.toString()+"<BR><HR>";

			e.printStackTrace();
		}//end catch block
		
		return l_result;
	} 
	public Authenticator getAuth()
	{
		return new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("bhashahussain","9asha@7299");
			}
		};
	} public static void main(String[] args) {
		new MailService().send("bhashahussain@gmail.com", "hi", "Hi");
	}
	
}
