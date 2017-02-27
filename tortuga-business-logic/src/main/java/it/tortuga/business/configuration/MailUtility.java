/**
 * 
 */
package it.tortuga.business.configuration;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

/**
 * @author pc ads
 *
 */
public class MailUtility {

	public static void sendMail(String dest, String mitt, String oggetto, String testoEmail) throws MessagingException {
		// config
		// Sender's email ID needs to be mentioned
		String from = "gmaglio@gmaglio.it";

		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtp.host", "gmaglio.it");
		properties.setProperty("mail.smtp.port", "25");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.user", "gmaglio@gmaglio.it");
		properties.setProperty("mail.password", "prova1");
		// properties.put("mail.debug", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(dest));

			message.setSubject(oggetto);
			message.setText(testoEmail);

			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
