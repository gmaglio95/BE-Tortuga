package it.tortuga.business.dbInterface.amministratore;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.DBWriterFactory;

public class DBAdminFeatures extends DBWriterFactory {

	private DBAdminTeamFeatures teamFeatures;
	private DBAdminUsersFeatures usersFeatures;
	private DBAdminIstitutiFeatures istitutiFeatures;

	public DBAdminFeatures() {
		super();
		teamFeatures = new DBAdminTeamFeatures();
		usersFeatures = new DBAdminUsersFeatures();
		istitutiFeatures = new DBAdminIstitutiFeatures();
	}

	public User insertNewUser(User user) {
		return usersFeatures.insertNewUser(user);
	}

	public Boolean deleteUser(User user) {
		return usersFeatures.deleteUser(user);
	}

	public User updateUser(User user) {
		return usersFeatures.updateUser(user);
	}

	public Squadra insertNewTeam(Squadra team) {
		return teamFeatures.insertNewTeam(team);
	}

	public IstitutoAllenamento insertNewIstituto(IstitutoAllenamento istituto) {
		return istitutiFeatures.insertNewIstituto(istituto);
	}

	public User getUserById(User user) {
		return usersFeatures.getUserById(user);
	}
}
