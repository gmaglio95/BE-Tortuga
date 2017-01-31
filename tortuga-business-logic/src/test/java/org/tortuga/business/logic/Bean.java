package org.tortuga.business.logic;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -435967223017383386L;
	/**
	 * 
	 */
	@Id
	private String _id;
	private String nome;
	private String cognome;
	private String codFiscale;

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

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

}
