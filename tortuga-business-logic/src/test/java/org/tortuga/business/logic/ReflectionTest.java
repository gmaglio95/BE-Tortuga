package org.tortuga.business.logic;

import java.util.Date;

import org.junit.Test;

import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

public class ReflectionTest {

	@Test
	public void testReflection() {
		DBAdminFeatures factory = new DBAdminFeatures();
		User user = new User();
		user.setCodiceFiscale("MGLGPP95T15E986Y");
		user.setCognome("Maglio");
		user.set_id("giuseppe.maglio@hotmail.com");
		user.setNome("Giuseppe");
		user.setDataNacita(new Date());
		user.setPassword("prova");
		user.setRuoloApplicativo(RuoloApplicativo.AMMINISTRATORE);
		// factory.cambioRuoloApplicativoUtente(user);
//		factory.insertNewUser(user);
		user.setRuoloApplicativo(RuoloApplicativo.PARTECIPANTE);
		factory.cambioRuoloApplicativoUtente(user);

	}

}
