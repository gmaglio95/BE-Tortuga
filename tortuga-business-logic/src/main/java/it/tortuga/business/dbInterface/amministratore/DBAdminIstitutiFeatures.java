/**
 * 
 */
package it.tortuga.business.dbInterface.amministratore;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.util.JSON;

import it.tortuga.beans.ErrorMessage;
import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.business.configuration.MapperBeans;
import it.tortuga.business.dbInterface.DBWriterFactory;
import it.tortuga.business.document.bean.DocumentIstitutoAllenamentoDTO;

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
