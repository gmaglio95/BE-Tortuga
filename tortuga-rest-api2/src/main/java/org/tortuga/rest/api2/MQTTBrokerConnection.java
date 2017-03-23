/**
 * 
 */
package org.tortuga.rest.api2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author pc ads
 *
 */
public class MQTTBrokerConnection implements MqttCallback {

	private static MQTTBrokerConnection connection;
	private MqttClient myClient;
	private MqttConnectOptions connOpt;
	private String BROKER_URL;
	private List<String> topics = new ArrayList<String>();

	private MQTTBrokerConnection(String brokerUrl) {
		this.BROKER_URL = brokerUrl;
	}

	/**
	 * Override connection if exits
	 * 
	 * @author gmaglio
	 * @param brokerUrl
	 * @return
	 */
	public static MQTTBrokerConnection newInstanceConnection(String brokerUrl) {
		connection = new MQTTBrokerConnection(brokerUrl);
		connection.run();
		return connection;
	}

	public static MQTTBrokerConnection getConnection() {
		return connection;
	}

	public void addAndSubscribeTopic(String topic) {
		topics.add(topic);
		subcribeTopics();

	}

	public void sendMessageToThisTopic(String topic, String message) {
		try {
			myClient.publish(topic, new MqttMessage(message.getBytes()));
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessageToThisTopic(String topic, MqttMessage message) {
		try {
			myClient.publish(topic, message);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mosquittoConnection() {
		for (int i = 0; i < 10; i++) {
			if (!run()) {
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				return;
			}
		}
	}

	public void subcribeTopics() {
		if (myClient != null && myClient.isConnected()) {
			for (String topic : this.topics) {
				try {
					myClient.subscribe(topic);
				} catch (MqttException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private boolean run() {
		connOpt = new MqttConnectOptions();
		boolean connected = false;
		connOpt.setCleanSession(true);
		connOpt.setKeepAliveInterval(30);
		// Connect to Broker
		try {
			MemoryPersistence persistence = new MemoryPersistence();
			myClient = new MqttClient(BROKER_URL, "Sending", persistence);
			myClient.setCallback(this);
			myClient.connect(connOpt);
		} catch (MqttException e) {
			e.printStackTrace();
			return connected;
		}
		connected = true;
		return connected;
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost!");
		cause.printStackTrace();
		mosquittoConnection();
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println(message.toString());
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}
}
