/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.util.JSON;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.DBWriterFactory;

/**
 * @author pc ads
 *
 */
public class DBAdminTeamFeatures extends DBWriterFactory {

	public Squadra insertNewTeam(Squadra team) {

		try {
			team_collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(team)));
			if (team.getIstitutoAppartenenza() != null) {
				IstitutoAllenamento istituto = team.getIstitutoAppartenenza();
				BasicDBObject filter = new BasicDBObject(TortugaUtility.getFieldName(istituto, istituto.get_id()),
						istituto.get_id());
				istituti_collection.findOneAndUpdate(filter,
						new Document("$set",
								new Document(TortugaUtility.getFieldName(istituto, istituto.getSquadraPresente()),
										istituto.getSquadraPresente())));
			}
		} catch (MongoWriteException e) {
			Squadra teamToSend = new Squadra();
			teamToSend.setErrorDescriptors(new ErrorMessage("Squadra Gia' esistente"));
			team = teamToSend;
		}
		return team;
	}

	public Boolean deleteTeam(Squadra team) {
		// WORK-around
		User user = new User();
		user.setSquadraAppartenenza("2");
		// Work-Around
		IstitutoAllenamento istituto = new IstitutoAllenamento();
		istituto.setSquadraPresente("3");
		BasicDBObject filter = new BasicDBObject(TortugaUtility.getFieldName(team, team.get_id()), team.get_id());
		user_collection.updateMany(filter, new Document("$set",
				new Document(TortugaUtility.getFieldName(user, user.getSquadraAppartenenza()), "")));
		filter = new BasicDBObject(TortugaUtility.getFieldName(istituto, istituto.getSquadraPresente()), team.get_id());
		istituti_collection.updateOne(filter, new Document("$set",
				new Document(TortugaUtility.getFieldName(istituto, istituto.getSquadraPresente()), "")));
		filter = new BasicDBObject(TortugaUtility.getFieldName(team, team.get_id()), team.get_id());
		BasicDBObject result = team_collection.findOneAndDelete(filter);
		return result != null;
	}

	public Squadra getTeamById(String idTeam, Boolean avversario) {
		Squadra squadra = null;

		BasicDBObject filter = new BasicDBObject(this.nameIdField, idTeam);
		squadra = gson.fromJson(team_collection.find(filter).first().toString(), Squadra.class);
		if (squadra == null) {
			squadra = new Squadra();
			squadra.setErrorDescriptors(new ErrorMessage("Squadra Inesistente!"));
		}
		return squadra;
	}

	public Squadra updateTeam(Squadra updateTeam) {
		IstitutoAllenamento istituto = new IstitutoAllenamento();
		istituto.setSquadraPresente("prova");
		BasicDBObject filter = new BasicDBObject(this.nameIdField, updateTeam.get_id());
		Squadra teamPersisted = gson.fromJson(team_collection.find(filter).first().toString(), Squadra.class);
		BasicDBObject replaced = team_collection.findOneAndReplace(filter,
				(BasicDBObject) JSON.parse(gson.toJson(updateTeam)));
		if (replaced != null) {
			filter = new BasicDBObject(istituto.getSquadraPresente(), updateTeam.get_id());
			replaced = istituti_collection.findOneAndReplace(filter,
					(BasicDBObject) JSON.parse(gson.toJson(updateTeam.getIstitutoAppartenenza())));
			if (updateTeam.getListaPartecipanti() != null && teamPersisted.getListaPartecipanti() != null) {
				List<User> users = updateTeam.getListaPartecipanti();
				for (User user : users) {
					if (!teamPersisted.getListaPartecipanti().contains(user)) {
						filter = new BasicDBObject(this.nameIdField, user.get_id());
						user_collection.updateOne(filter,
								new Document("$set",
										new Document(TortugaUtility.getFieldName(user, user.getSquadraAppartenenza()),
												updateTeam.get_id())));
					}
				}

					for (User user : teamPersisted.getListaPartecipanti()) {
						if (!users.contains(user)) {
							user_collection.updateOne(filter, new Document("$set", new Document(
									TortugaUtility.getFieldName(user, user.getSquadraAppartenenza()), "")));
						}
					}
			}
		} else {
			updateTeam = new Squadra();
			updateTeam.setErrorDescriptors(new ErrorMessage("Update del team non riuscito"));
		}
		return updateTeam;
	}

}
