package org.tortuga.business.logic;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.Test;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;
import it.tortuga.business.configuration.MailUtility;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

public class ReflectionTest {

	DBAdminFeatures factory = new DBAdminFeatures();

	@Test
	public void testReflection() throws NoSuchAlgorithmException {
		// User user = new User();
		// user.set_id("giuseppe.maglio@hotmail.com");
		// user.setPassword("prova");
		// user = factory.loginUser(user);
		// if (user.getErrorDescriptors() != null) {
		// System.out.println(user.getErrorDescriptors().getDescription());
		// }
	}

	@Test
	public void testMail() {
		// try {
		// MailUtility.sendMail("giuseppe.maglio@hotmail.com",
		// "giuseppe.maglio@hotmail.com", "prova", "provaMail");
		// } catch (MessagingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	@Test
	public void insertUser() {
		 User user = new User();
		 Squadra team = new Squadra();
		 team.set_id("88");
//		 user.setSquadraAppartenenza(team);
		 user.setCodiceFiscale("MGLGPP95T15E986Y");
		 user.setCognome("Maglio");
		 user.set_id("giuseppe.maglio@hotmail.com");
		 user.setNome("Giuseppe");
		 user.setRuoloApplicativo(RuoloApplicativo.AMMINISTRATORE);
		 user.setDataNacita(new Date());
		 user.setPassword("prova");
//		 user.setSquadraAppartenenza(team);
		 factory.updateUser(user);

	}

	@Test
	public void insertIstituto() {
		// IstitutoAllenamento istituto = new IstitutoAllenamento();
		// istituto.set_id("4");
		// istituto.setCitta("Roma");
		// istituto.setIndirizzo("via della magliana 140");
		// istituto.setNomeIstituto("Istituto");
		// istituto.setProvincia("Roma");
		// Squadra team = new Squadra();
		// team.set_id("88");
		// istituto.setSquadraPresente(team);
		// factory.insertNewIstituto(istituto);
	}

	@Test
	public void getUserByEmail() {
		// User user = new User();
		// user.set_id("giuseppe.maglio@hotmail.com");
		// DBAdminFeatures factory = new DBAdminFeatures();
		// user = factory.getUserById(user);
	}

	@Test
	public void deleteTeam() {
		// Squadra team = new Squadra();
		// IstitutoAllenamento istituto = new IstitutoAllenamento();
		// team.setIstitutoAppartenenza(istituto);
		// team.setDataCreazione(new Date());
		// team.set_id("88");
		// team.setNomeSquadra("RUIZ");
		// List<User> users = new ArrayList<>();
		// User user = new User();
		// user.set_id("giuseppe.maglio@hotmail.com");
		// users.add(features.getUserById(user));
		// team.setListaPartecipanti(users);
		// features.deleteTeam(team);
	}

	@Test
	public void getTeamById() {
//		DBAdminFeatures features = new DBAdminFeatures();
//		features.getTeamById("88", false);
	}

	@Test
	public void testTeamReflection() {
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
		 Squadra team = new Squadra();
		 team.set_id("88");
		 team.setDataCreazione(new Date());
		 team.setNomeSquadra("RUIZ");
		 IstitutoAllenamento istituto = new IstitutoAllenamento();
		 istituto.set_id("4");
		 team.setIstitutoAppartenenza(istituto);
		 List<User> users = new ArrayList<>();
		 users.add(user);
//		 team.setListaPartecipanti(users);
		 factory.insertNewTeam(team);

	}

}
