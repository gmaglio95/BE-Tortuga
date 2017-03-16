/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import com.mongodb.MongoWriteException;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.business.dbInterface.DBWriterFactory;

/**
 * @author pc ads
 *
 */
public class DBAdminIstitutiFeatures extends DBWriterFactory {

	public IstitutoAllenamento insertNewIstituto(IstitutoAllenamento istituto) {
//		DocumentIstitutoAllenamentoDTO istitutoDocument = MapperBeans.istitutoToDocumentIstituto(istituto);
		try {
//			istituti_collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(istitutoDocument)));
		} catch (MongoWriteException e) {
			istituto = new IstitutoAllenamento();
			istituto.setErrorDescriptors(new ErrorMessage("Istituto già registrato"));
		}
		return istituto;
	}
}
