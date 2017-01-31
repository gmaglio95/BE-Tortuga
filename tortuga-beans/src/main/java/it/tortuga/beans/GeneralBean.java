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

	public ErrorMessage getErrorDescriptors() {
		return errorDescriptors;
	}

	public void setErrorDescriptors(ErrorMessage errorDescriptors) {
		this.errorDescriptors = errorDescriptors;
	}
}
