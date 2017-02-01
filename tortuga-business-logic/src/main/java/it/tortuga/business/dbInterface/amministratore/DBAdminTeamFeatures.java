/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.util.JSON;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.DBWriterFactory;
import it.tortuga.business.document.bean.DocumentSquadraDTO;

/**
 * @author pc ads
 *
 */
public class DBAdminTeamFeatures extends DBWriterFactory {

	public Squadra insertNewTeam(Squadra team) {
		DocumentSquadraDTO teamDocument = new DocumentSquadraDTO();
		teamDocument.set_id(team.get_id());
		teamDocument.setDataCreazione(team.getDataCreazione());
		teamDocument.setId_istitutoAppartenenza(team.getIstitutoAppartenenza().get_id());
		teamDocument.setNomeSquadra(team.getNomeSquadra());
		List<String> id_users = new ArrayList<>();
		for (User user : team.getListaPartecipanti()) {
			id_users.add(user.get_id());
		}
		teamDocument.setId_users(id_users);
		try {
			team_collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(teamDocument)));
		} catch (MongoWriteException e) {
			Squadra teamToSend = new Squadra();
			teamToSend.setErrorDescriptors(new ErrorMessage("Squadra Gia' esistente"));
			team = teamToSend;
		}
		return team;
	}
}
