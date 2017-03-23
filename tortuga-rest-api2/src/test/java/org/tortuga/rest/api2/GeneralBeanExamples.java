/**
 * 
 */
package org.tortuga.rest.api2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;

/**
 * @author pc ads
 *
 */
public class GeneralBeanExamples {

	private GeneralBeanExamples() {
	};

	public static User getUserById() {
		User user = new User();
		user.set_id("gino.lello@prova.it");
		user.setPassword("prova1");
		return user;
	}

	public static User getUserExample() {
		User user = new User();
		user.set_id("gino.lello@prova.it");
		user.setCodiceFiscale("MGLGPP95T15E986Y");
		user.setDataNacita(new Date());
		user.setNome("Giuseppe");
		user.setPassword("prova1");
		user.setCognome("Edoardo");
		user.setRuoloApplicativo(RuoloApplicativo.AMMINISTRATORE);
		user.setSquadraAppartenenza("1");
		return user;
	}

	public static Squadra getTeamExample() {
		Squadra team = new Squadra();
		team.set_id("1");
		team.setDataCreazione(new Date());
		team.setIstitutoAppartenenza(GeneralBeanExamples.getIstitutoExample());
		List<User> userTeams = new ArrayList<>();
		userTeams.add(GeneralBeanExamples.getUserExample());
		team.setListaPartecipanti(userTeams);
		team.setNomeSquadra("RUIZ");
		return team;
	}

	public static IstitutoAllenamento getIstitutoExample() {
		IstitutoAllenamento istituto = new IstitutoAllenamento();
		istituto.set_id("2");
		istituto.setCitta("Roma");
		istituto.setIndirizzo("Viale africa 140");
		istituto.setNomeIstituto("RUIZ");
		istituto.setProvincia("RM");
		istituto.setSquadraPresente("1");
		return istituto;
	}
}
