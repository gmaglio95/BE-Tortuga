/**
 * 
 */
package it.tortuga.beans;

/**
 * @author pc ads
 *
 */
public class ElementToUpdateBean extends GeneralBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String elementToUpdate;

	public User getUser() {
		return user;
	}

	public String getElementToUpdate() {
		return elementToUpdate;
	}

	public void setElementToUpdate(String elementToUpdate) {
		this.elementToUpdate = elementToUpdate;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
