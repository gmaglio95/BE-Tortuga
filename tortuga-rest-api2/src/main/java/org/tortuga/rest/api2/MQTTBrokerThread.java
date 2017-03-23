/**
 * 
 */
package org.tortuga.rest.api2;

import it.tortuga.beans.TortugaUtility;

/**
 * @author pc ads
 *
 */
public class MQTTBrokerThread extends Thread {

	@Override
	public void run() {
		MQTTBrokerConnection connection = MQTTBrokerConnection.newInstanceConnection(TortugaUtility.BROKER_URL);
		connection.addAndSubscribeTopic("team/1");
	}
}
