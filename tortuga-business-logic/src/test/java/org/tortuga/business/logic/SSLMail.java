package org.tortuga.business.logic;

import org.junit.Test;

import it.tortuga.business.configuration.MailSender;

public class SSLMail {

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use
	 * authentication) Use Authentication: Yes Port for SSL: 465
	 */

	@Test
	public void testEmail() {
		final String fromEmail = "noreply.tortuga@gmail.com"; // requires valid
																// gmail id
		final String password = "tortuga2017"; // correct password for gmail id
		final String toEmail = "giuseppe.maglio@hotmail.com"; // can be
		MailSender sender = new MailSender(fromEmail, password);
		try {
			sender.sendMail("Soggetto", "Lallero", fromEmail, toEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}