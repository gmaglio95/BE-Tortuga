package org.tortuga.business.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;
import it.tortuga.business.document.bean.DocumentSquadraDTO;

public class ReflectionTest {

	@Test
	public void testReflection() {
		DBAdminFeatures factory = new DBAdminFeatures();
		User user = new User();
		Squadra team = new Squadra();
		user.setSquadraAppartenenza(team);
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
		// factory.cambioRuoloApplicativoUtente(user);
		factory.deleteUser(user);

	}

	@Test
	public void testTeamReflection() {
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
		// factory.insertNewUser(user);
		user.setRuoloApplicativo(RuoloApplicativo.PARTECIPANTE);
		// factory.cambioRuoloApplicativoUtente(user);
		DocumentSquadraDTO squadra = new DocumentSquadraDTO();
		squadra.set_id("2");
		squadra.setDataCreazione(new Date());
		squadra.setId_istitutoAppartenenza("8");
		List<String> list = new ArrayList<String>();
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		squadra.setId_users(list);
		String name = TortugaUtility.getFieldName(squadra, squadra.getId_users());
	}

}
