package it.tortuga.business.configuration;

import com.mongodb.MongoClient;

public class MongoClientFactory {

	private static MongoClient client;

	public static MongoClient getMongoClientInstance() {
		if (client == null) {
			client = new MongoClient(MongoDBConnectionInfo.URL_CONNECTION);
		}
		return client;
	}

	private MongoClientFactory() {
	}

	public static void closeConnection() {
		if (client != null) {
			client.close();
		}
	}

}
