/**
 * 
 */
package it.tortuga.beans;

/**
 * @author pc ads
 *
 */
public abstract class GeneralBean {

	private ErrorMessage errorDescriptors;
	private String _id;

	
	
	public ErrorMessage getErrorDescriptors() {
		return errorDescriptors;
	}

	public void setErrorDescriptors(ErrorMessage errorDescriptors) {
		this.errorDescriptors = errorDescriptors;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof User) {
			User objUser = (User) obj;
			if (objUser.get_id().equals(this.get_id())) {
				isEquals = true;
			}

		}

		return isEquals;
	}
}
