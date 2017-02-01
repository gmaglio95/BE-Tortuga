package it.tortuga.business.dbInterface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import it.tortuga.business.configuration.MongoClientFactory;
import it.tortuga.business.configuration.MongoDBConnectionInfo;

public abstract class DBWriterFactory {

	protected Gson gson;
	protected MongoClient client;
	protected MongoDatabase db;

	protected MongoCollection<BasicDBObject> user_collection;
	protected MongoCollection<BasicDBObject> team_collection;
	protected MongoCollection<BasicDBObject> istituti_collection;
	protected MongoCollection<BasicDBObject> team_avversari_collection;

	protected DBWriterFactory() {
		this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		this.client = MongoClientFactory.getMongoClientInstance();
		this.db = client.getDatabase(MongoDBConnectionInfo.DB_NAME);
		this.user_collection = db.getCollection(MongoDBConnectionInfo.USER_COLLECTION, BasicDBObject.class);
		this.team_collection = db.getCollection(MongoDBConnectionInfo.TEAM_COLLECTION, BasicDBObject.class);
		this.istituti_collection = db.getCollection(MongoDBConnectionInfo.ISTITUTI_COLLECTION, BasicDBObject.class);
		this.team_avversari_collection = db.getCollection(MongoDBConnectionInfo.ISTITUTI_COLLECTION,
				BasicDBObject.class);
	}

}
