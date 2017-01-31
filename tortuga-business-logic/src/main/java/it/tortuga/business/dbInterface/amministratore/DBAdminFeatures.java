package it.tortuga.business.dbInterface.amministratore;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.util.JSON;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.DBWriterFactory;
import it.tortuga.business.document.bean.DocumentSquadraDTO;
import it.tortuga.business.document.bean.DocumentUserDTO;

public class DBAdminFeatures extends DBWriterFactory {

	public DBAdminFeatures() {
		super();
	}

	public User insertNewUser(User user) {
		try {
			DocumentUserDTO userDocument = new DocumentUserDTO();
			userDocument.setCodiceFiscale(user.getCodiceFiscale());
			userDocument.setCognome(user.getCognome());
			userDocument.setDataNascita(user.getDataNacita());
			userDocument.set_id(user.get_id());
			userDocument.setId_squadra(user.getSquadraAppartenenza().get_id());
			userDocument.setNome(user.getNome());
			userDocument.setPassword(user.getPassword());
			userDocument.setRuolo(user.getRuolo().toString());
			userDocument.setRuoloApplicativo(user.getRuoloApplicativo().getRuolo());
			user_collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(userDocument)));

		} catch (MongoWriteException e) {
			e.printStackTrace();
			User userToSend = new User();
			userToSend.setErrorDescriptors(new ErrorMessage("Utente già registrato"));
			return userToSend;
		}
		return user;
	}

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
		}
		return team;
	}

	public Boolean deleteUser(User user) {
		// gmaglio : il metodo ritorna il Document che è stato eliminato, se
		// l'utente non è stato trovato
		// tornerà un valore null, ecco il perchè del return finale.
		BasicDBObject removed = user_collection.findOneAndDelete((BasicDBObject) JSON.parse(gson.toJson(user)));
		for (BasicDBObject document : team_collection.find()) {
			String idSquadraAppartenenza = user.getSquadraAppartenenza().get_id();
			if (document.containsField(idSquadraAppartenenza)) {
				
			}
		}
		return removed != null;
	}

	public User cambioRuoloApplicativoUtente(User user) {
		String nameField = TortugaUtility.getFieldName(user, RuoloApplicativo.class);
		if (nameField != null) {
			for (BasicDBObject document : user_collection.find()) {
				if (document.containsValue(user.getCodiceFiscale())) {
					document.replace(nameField, user.getRuoloApplicativo());
					user_collection.findOneAndUpdate(document, document);
				}
			}
		}

		return user;
	}

}
