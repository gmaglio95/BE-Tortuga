package it.tortuga.business.dbInterface;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import it.tortuga.beans.TortugaUtility;
import it.tortuga.beans.User;
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
	protected String nameIdField;

	protected DBWriterFactory() {

		JsonSerializer<Date> ser = new JsonSerializer<Date>() {
			@Override
			public JsonElement serialize(Date src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
				// TODO Auto-generated method stub
				return src == null ? null : new JsonPrimitive(src.getTime());
			}
		};

		JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
					JsonDeserializationContext context) throws JsonParseException {
				return json == null ? null : new Date(json.getAsLong());
			}
		};

		this.gson = new GsonBuilder().registerTypeAdapter(Date.class, ser).registerTypeAdapter(Date.class, deser)
				.create();
		// TO SAVE ID GENERAL BEAN
		User user = new User();
		user.set_id("id");
		this.nameIdField = TortugaUtility.getFieldName(user, user.get_id());
		this.client = MongoClientFactory.getMongoClientInstance();
		this.db = client.getDatabase(MongoDBConnectionInfo.DB_NAME);
		this.user_collection = db.getCollection(MongoDBConnectionInfo.USER_COLLECTION, BasicDBObject.class);
		this.team_collection = db.getCollection(MongoDBConnectionInfo.TEAM_COLLECTION, BasicDBObject.class);
		this.istituti_collection = db.getCollection(MongoDBConnectionInfo.ISTITUTI_COLLECTION, BasicDBObject.class);
		this.team_avversari_collection = db.getCollection(MongoDBConnectionInfo.ISTITUTI_COLLECTION,
				BasicDBObject.class);
	}

}
