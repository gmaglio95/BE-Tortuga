/**
 * 
 */
package it.tortuga.beans;

/**
 * @author pc ads
 *
 */
public enum BeanType {

	USER(User.class), TEAM(Squadra.class), ISTITUTO(IstitutoAllenamento.class);
	private BeanType(Class clazz) {
		this.clazz = clazz;
	}

	private Class clazz;

	public Class getClazz() {
		return clazz;
	}
}