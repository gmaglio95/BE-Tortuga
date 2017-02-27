/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.DBWriterFactory;
import it.tortuga.business.document.bean.DocumentSquadraDTO;

/**
 * @author pc ads
 *
 */
public class DBAdminUsersFeatures extends DBWriterFactory {

	public User insertNewUser(User user) {
		try {
			user.setPassword(TortugaUtility.getMD5Value(user.getPassword()));
			user_collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(user)));
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
			String idSquadraAppartenenza = user.getSquadraAppartenenza();
			if (document.containsValue(idSquadraAppartenenza)) {
				DocumentSquadraDTO documentTeam = gson.fromJson(document.toString(), DocumentSquadraDTO.class);

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
		UpdateResult update = user_collection.replaceOne(bsonFilter, (BasicDBObject) JSON.parse(gson.toJson(user)));
		return getUserById(user);
	}

	public User getUserById(User user) {
		User userToSend = null;
		boolean find = false;
		for (BasicDBObject document : user_collection.find(new BasicDBObject(nameIdField, user.get_id()))) {
			find = true;
			userToSend = gson.fromJson(document.toString(), User.class);
			if (!find) {
				userToSend = new User();
				userToSend.setErrorDescriptors(new ErrorMessage("Nome utente o password inesistenti"));
				return userToSend;
			}
		}
		return userToSend;
	}

	public User loginUser(User user) {
		String password = TortugaUtility.getMD5Value(user.getPassword());
		for (BasicDBObject userDocument : user_collection
				.find(new BasicDBObject(TortugaUtility.getFieldName(user, user.get_id()), user.get_id()))) {
			if (password.equals(userDocument.get(TortugaUtility.getFieldName(user, user.getPassword())))) {
				return getUserById(user);
			} else {
				user.setErrorDescriptors(new ErrorMessage("Password inserita errata"));
				return user;
			}
		}
		user.setErrorDescriptors(new ErrorMessage("Utente inserito inesistente"));
		return user;

	}

}
