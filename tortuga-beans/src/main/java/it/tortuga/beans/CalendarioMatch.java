/**
 * 
 */
package it.tortuga.beans;

import java.util.List;

/**
 * @author pc ads
 *
 */
public class CalendarioMatch extends GeneralBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4592431913186105018L;

	private List<Match> matchs;

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

}
