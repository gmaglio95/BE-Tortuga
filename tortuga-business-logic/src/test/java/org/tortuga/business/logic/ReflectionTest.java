package org.tortuga.business.logic;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

public class ReflectionTest {

	@Test
	public void testReflection() throws NoSuchAlgorithmException {
		DBAdminFeatures factory = new DBAdminFeatures();
		User user = new User();
		Squadra team = new Squadra();
		team.set_id("88");
		user.setSquadraAppartenenza(team);
		user.setCodiceFiscale("MGLGPP95T15E986Y");
		user.setCognome("Gesualdo");
		user.set_id("giuseppe.maglio@hotmail.com");
		user.setNome("Antonio");
		user.setDataNacita(new Date());
		user.setPassword("prova");
		// factory.deleteUser(user);
		// user.setRuoloApplicativo(RuoloApplicativo.AMMINISTRATORE);
		// factory.insertNewUser(user);
		user.setRuoloApplicativo(RuoloApplicativo.AMMINISTRATORE);
		factory.updateUser(user);
	}

	@Test
	public void insertUser() {
		// User user = new User();
		// Squadra team = new Squadra();
		// user.setSquadraAppartenenza(team);
		// user.setCodiceFiscale("MGLGPP95T15E986Y");
		// user.setCognome("Maglio");
		// user.set_id("giuseppe.maglio@hotmail.com");
		// user.setNome("Giuseppe");
		// user.setDataNacita(new Date());
		// user.setPassword("prova");

	}

	@Test
	public void insertTeam() {

	}

	@Test
	public void insertIstituto() {
		IstitutoAllenamento istituto = new IstitutoAllenamento();
	}

	@Test
	public void getUserByEmail() {
		// User user = new User();
		// user.set_id("giuseppe.maglio@hotmail.com");
		// DBAdminFeatures factory = new DBAdminFeatures();
		// user = factory.getUserById(user);
	}

	@Test
	public void testTeamReflection() {
		// User user = new User();
		// DBAdminFeatures factory = new DBAdminFeatures();
		// user.setCodiceFiscale("MGLGPP95T15E986Y");
		// user.setCognome("Maglio");
		// user.set_id("giuseppe.maglio@hotmail.com");
		// user.setNome("Giuseppe");
		// user.setDataNacita(new Date());
		// user.setPassword("prova");
		// user.setRuoloApplicativo(RuoloApplicativo.AMMINISTRATORE);
		// // factory.cambioRuoloApplicativoUtente(user);
		// // factory.insertNewUser(user);
		// user.setRuoloApplicativo(RuoloApplicativo.PARTECIPANTE);
		// // factory.cambioRuoloApplicativoUtente(user);
		// Squadra team = new Squadra();
		// team.set_id("88");
		// team.setDataCreazione(new Date());
		// team.setNomeSquadra("RUIZ");
		// IstitutoAllenamento istituto = new IstitutoAllenamento();
		// istituto.set_id("6");
		// team.setIstitutoAppartenenza(istituto);
		// List<User> users = new ArrayList<>();
		// users.add(user);
		// user = new User();
		// user.set_id("pippo.pippo@pippons.it");
		// users.add(user);
		// team.setListaPartecipanti(users);
		// factory.insertNewTeam(team);

	}

}
