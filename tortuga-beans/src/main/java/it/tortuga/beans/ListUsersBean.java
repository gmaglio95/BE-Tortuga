/**
 * 
 */
package it.tortuga.beans;

import java.util.List;

/**
 * @author pc ads
 *
 */
public class ListUsersBean extends GeneralBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3657513605905213955L;

		private List<User> users;

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

}
