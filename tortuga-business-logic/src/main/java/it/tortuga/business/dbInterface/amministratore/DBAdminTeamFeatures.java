/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import java.util.ArrayList;
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
import it.tortuga.business.configuration.MapperBeans;
import it.tortuga.business.dbInterface.DBWriterFactory;
import it.tortuga.business.document.bean.DocumentIstitutoAllenamentoDTO;
import it.tortuga.business.document.bean.DocumentSquadraDTO;
import it.tortuga.business.document.bean.DocumentUserDTO;

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
		Squadra team = gson.fromJson(team_collection.find(filter).first().toString(), Squadra.class);
		if (team != null) {
			filter = new BasicDBObject(nameIdField, team.getIstitutoAppartenenza().get_id());
			IstitutoAllenamento istituto = gson
					.fromJson(team_collection.find(filter).first().toString(), IstitutoAllenamento.class);
			filter = new BasicDBObject(nameIdField, team.get_id());
		} else {
			squadra = new Squadra();
			squadra.setErrorDescriptors(new ErrorMessage("Team non esistente!"));
		}
		return squadra;
	}

}
