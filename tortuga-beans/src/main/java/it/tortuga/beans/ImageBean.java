/**
 * 
 */
package it.tortuga.beans;

import java.io.Serializable;

/**
 * @author pc ads
 *
 */
public class ImageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6260734875460394619L;
	private byte[] imagesEncoded;

	public byte[] getImagesEncoded() {
		return imagesEncoded;
	}

	public void setImagesEncoded(byte[] imagesEncoded) {
		this.imagesEncoded = imagesEncoded;
	}

}
