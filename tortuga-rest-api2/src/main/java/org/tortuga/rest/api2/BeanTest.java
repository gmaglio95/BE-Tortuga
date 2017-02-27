/**
 * 
 */
package org.tortuga.rest.api2;

import java.io.Serializable;

/**
 * @author pc ads
 *
 */
public class BeanTest implements Serializable{

	private String nome;
	private String cognome;
	private String eta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

}
