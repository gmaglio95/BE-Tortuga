/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.util.JSON;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.DBWriterFactory;
import it.tortuga.business.document.bean.DocumentSquadraDTO;
import it.tortuga.business.document.bean.DocumentUserDTO;

/**
 * @author pc ads
 *
 */
public class DBAdminUsersFeatures extends DBWriterFactory {

	public User insertNewUser(User user) {
		try {
			DocumentUserDTO userDocument = new DocumentUserDTO();
			userDocument.setCodiceFiscale(user.getCodiceFiscale());
			userDocument.setCognome(user.getCognome());
			userDocument.setDataNascita(user.getDataNacita());
			userDocument.set_id(user.get_id());
			userDocument.setId_squadra(user.getSquadraAppartenenza().get_id());
			userDocument.setNome(user.getNome());
			userDocument.setPassword(TortugaUtility.getMD5Value(user.getPassword()));
			userDocument.setRuolo(user.getRuolo() != null ? user.getRuolo().toString() : "");
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

	public User cambioRuoloApplicativoUtente(User user) {
		String nameField = TortugaUtility.getFieldName(user, user.getRuoloApplicativo());
		BasicDBObject bsonFilter = new BasicDBObject(TortugaUtility.getFieldName(user, user.get_id()), user.get_id());
		user_collection.updateOne(bsonFilter,
				new Document("$set", new Document(nameField, JSON.parse(gson.toJson(user.getRuoloApplicativo())))));
		return user;
	}

	public User getUserById(User user) {
		User userLogged = null;
		String nameField = TortugaUtility.getFieldName(user, user.get_id());
		// userLogged = user_collection.find(new BasicDBObject(nameField,
		// user.get_id()));
		return userLogged;
	}

}
