package it.tortuga.business.dbInterface.amministratore;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;
import it.tortuga.business.configuration.MailSender;
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

		user = usersFeatures.insertNewUser(user);

		return user;
	}

	public Boolean deleteUser(User user) {

		Boolean isDeleted = usersFeatures.deleteUser(user);

		return isDeleted;
	}

	public User updateUser(User user) {

		user = usersFeatures.updateUser(user);

		return user;
	}

	public Boolean deleteTeam(Squadra team) {
		return teamFeatures.deleteTeam(team);
	}

	public Squadra insertNewTeam(Squadra team) {

		team = teamFeatures.insertNewTeam(team);

		return team;
	}

	public IstitutoAllenamento insertNewIstituto(IstitutoAllenamento istituto) {

		istituto = istitutiFeatures.insertNewIstituto(istituto);

		return istituto;
	}

	public User getUserById(User user) {

		user = usersFeatures.getUserById(user);

		return user;
	}

	public User loginUser(User user) {

		user = usersFeatures.loginUser(user);

		return user;
	}

	public Squadra getTeamById(String idTeam, Boolean avversario) {
		return teamFeatures.getTeamById(idTeam, avversario);
	}

	public User changePasswordUser(User user) {
		User userToSend = usersFeatures.updateUser(user);
		return userToSend;
	}

}
