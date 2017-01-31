package org.tortuga.business.logic;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

/**
 * Unit test for simple App.
 */
public class AppTest {
	Gson gson = new Gson();

	@Test
	public void dbConnectionUnit() {
		Bean bean = new Bean();
		bean.setCodFiscale("SMRPNN67E45Z133F");
		bean.setCognome("prova");
		bean.setNome("GIUSEPPE");
		bean.setId("2");

		BeanAltro beanAltro = new BeanAltro();
		beanAltro.setId("8");
		beanAltro.setId_bean("1");
		beanAltro.setName("ANTONIUZZO");
		MongoClient client = new MongoClient("localhost");
//		client.get
		MongoDatabase db = client.getDatabase("prova2");
		MongoCollection<BasicDBObject> collection = db.getCollection("prova", BasicDBObject.class);
		Map<String, Object> map = new HashMap<>();
		try {
			collection.insertOne((BasicDBObject) JSON.parse(gson.toJson(beanAltro)));
			collection.find();
			Bean obj = null;
			for (BasicDBObject document : collection.find()) {
				String nome = (String) document.get("nome");
				System.out.println(nome);
				// obj = gson.fromJson(document.toJson(), Bean.class);
			}
			if (obj != null) {
				// System.out.println(obj.getNome() + " " +
				// obj.getCognome());
			}
		} catch (MongoWriteException e) {
			System.out.println("UTENTE GIA INSERITO");
		}
	}

}
