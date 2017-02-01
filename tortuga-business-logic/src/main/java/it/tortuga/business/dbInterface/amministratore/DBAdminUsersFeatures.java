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
public class DBAdminUsersFeatures extends DBWriterFactory {

	public User insertNewUser(User user) {
		try {
			DocumentUserDTO userDocument = MapperBeans.userToDocumentUser(user);
			user_collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(userDocument)));
		} catch (MongoWriteException e) {
			e.printStackTrace();
			User userToSend = new User();
			userToSend.setErrorDescriptors(new ErrorMessage("Utente già registrato"));
			return userToSend;
		}
		return user;
	}

	public Boolean deleteUser(User user) {
		// gmaglio : il metodo ritorna il Document che è stato eliminato, se
		// l'utente non è stato trovato
		// tornerà un valore null, ecco il perchè del return finale.
		String nameIdUser = TortugaUtility.getFieldName(user, user.get_id());
		BasicDBObject removed = user_collection.findOneAndDelete(new BasicDBObject(nameIdUser, user.get_id()));
		for (BasicDBObject document : team_collection.find()) {
			String idSquadraAppartenenza = user.getSquadraAppartenenza().get_id();
			if (document.containsValue(idSquadraAppartenenza)) {
				DocumentSquadraDTO documentTeam = gson.fromJson(document.toJson(), DocumentSquadraDTO.class);

				String idDocumentField = TortugaUtility.getFieldName(documentTeam, documentTeam.getId_users());
				documentTeam.getId_users().remove(user.get_id());

				team_collection.updateOne(new BasicDBObject(idDocumentField, documentTeam.get_id()),
						new Document("$set", new Document(nameIdUser, documentTeam.getId_users())));
			}
		}
		return removed != null;
	}

	public User updateUser(User user) {
		BasicDBObject bsonFilter = new BasicDBObject(TortugaUtility.getFieldName(user, user.get_id()), user.get_id());
		user_collection.updateOne(bsonFilter,
				(BasicDBObject) JSON.parse(gson.toJson(MapperBeans.userToDocumentUser(user))));
		return user;
	}

	public User getUserById(User user) {
		DocumentUserDTO userLogged = null;
		DocumentSquadraDTO teamUserLogged = null;
		DocumentIstitutoAllenamentoDTO istitutoDocument = null;
		List<DocumentUserDTO> usersTeam = new ArrayList<DocumentUserDTO>();
		String nameField = TortugaUtility.getFieldName(user, user.get_id());
		for (BasicDBObject document : user_collection.find(new BasicDBObject(nameField, user.get_id()))) {
			userLogged = gson.fromJson(document.toJson(), DocumentUserDTO.class);
			String idSquadra = userLogged.getId_squadra();
			String idFieldNameTeam = TortugaUtility.getFieldName(userLogged, idSquadra);
			for (BasicDBObject team : team_collection.find(new BasicDBObject(idFieldNameTeam, idSquadra))) {
				teamUserLogged = gson.fromJson(team.toJson(), DocumentSquadraDTO.class);
				break;
			}
			String idIstituto = teamUserLogged.getId_istitutoAppartenenza();
			for (BasicDBObject istituto : istituti_collection
					.find(new BasicDBObject(TortugaUtility.getFieldName(teamUserLogged, idIstituto), idIstituto))) {
				istitutoDocument = gson.fromJson(istituto.toJson(), DocumentIstitutoAllenamentoDTO.class);
			}
			for (BasicDBObject teamUser : user_collection.find(new BasicDBObject(
					TortugaUtility.getFieldName(userLogged, userLogged.getId_squadra()), teamUserLogged.get_id()))) {
				usersTeam.add(gson.fromJson(teamUser.toJson(), DocumentUserDTO.class));
			}

			break;
		}
		return MapperBeans.documentUserToUser(userLogged, teamUserLogged, istitutoDocument, usersTeam);
	}

}
