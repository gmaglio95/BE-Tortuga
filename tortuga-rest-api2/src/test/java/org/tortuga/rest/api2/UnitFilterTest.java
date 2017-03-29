/**
 * 
 */
package org.tortuga.rest.api2;

import java.util.ArrayList;

import org.junit.Test;

import it.tortuga.beans.IstitutoAllenamento;
import it.tortuga.beans.Squadra;
import it.tortuga.beans.User;
import it.tortuga.business.dbInterface.amministratore.DBAdminFeatures;

/**
 * @author pc ads
 *
 */
public class UnitFilterTest {

	private DBAdminFeatures admin = new DBAdminFeatures();

	public void createTeam() {
		Squadra team = admin.insertNewTeam(GeneralBeanExamples.getTeamExample());
		if (team.getErrorDescriptors() == null) {
			System.out.println("TEAM INSERT SUCCESFULLY");
		}
	}

	public void getTeam() {
		Squadra team = admin.getTeamById(GeneralBeanExamples.getTeamExample().get_id(), false);
		if (team.getErrorDescriptors() == null) {
			System.out.println("TEAM RECOVER SUCCESFULLY");
		}
	}

	public void deleteTeam() {
		Boolean team = admin.deleteTeam(GeneralBeanExamples.getTeamExample());
		if (team) {
			System.out.println("TEAM DELETED");
		}
	}

	public void updateTeam() {
		Squadra teamToUpdate = GeneralBeanExamples.getTeamExample();
		teamToUpdate.setNomeSquadra("Vinova");
//		teamToUpdate.setIstitutoAppartenenza(new IstitutoAllenamento().set);
		teamToUpdate.setListaPartecipanti(new ArrayList<>());
		Squadra team = admin.updateTeam(teamToUpdate);
		if (team.getErrorDescriptors() == null) {
			System.out.println("Team Updated");
		}
	}

	@Test
	public void CRUDSquadra() {
//		createTeam();
		// getTeam();
		 updateTeam();
		// deleteTeam();
	}

	@Test
	public void CRUDUser() {
		// createUser();
		// deleteUser();
		// createUser();
		// updateUser();
		// getUser();
		// deleteUser();
	}

	public void getUser() {
		User user = admin.loginUser(GeneralBeanExamples.getUserById());
		if (user.getErrorDescriptors() == null) {
			System.out.println("USER RECOVER SUCCESFULLY");
		}
	}

	public void createUser() {
		User user = admin.insertNewUser(GeneralBeanExamples.getUserExample());
		if (user.getErrorDescriptors() == null) {
			System.out.println("CREATE USER OK");
		}
	}

	public void updateUser() {
		User userDTO = GeneralBeanExamples.getUserExample();
		userDTO.setCognome("COGNOME");
		userDTO.setCognome("GGIGGGG");
		User user = admin.updateUser(userDTO);
		if (user.getErrorDescriptors() == null) {
			System.out.println("UPDATE USER OK");
		}
	}

	public void deleteUser() {
		Boolean removed = admin.deleteUser(GeneralBeanExamples.getUserExample());
		if (removed) {
			System.out.println("DELETE USER OK");
		}
	}

	@Test
	public void filterByType() {
		// FilterGeneralBean bean = new FilterGeneralBean();
		//
		// bean.setField("88");
		// bean.setType(BeanType.USER);
		// bean.setFildToFilter(FieldType.TEAM);
		// DBAdminFeatures factory = new DBAdminFeatures();
		//
		// List<User> users = factory.listUserByFilter(null);
		// for (User us : users) {
		// System.out.println(us.get_id());
		// }
	}

}
