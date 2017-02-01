package it.tortuga.business.document.bean;

import java.util.Date;

import it.tortuga.beans.RuoloApplicativo;
import it.tortuga.beans.RuoloCampo;

public class DocumentUserDTO {

	private String nome;
	private String cognome;
	private String _id;
	private String password;
	private String codiceFiscale;
	private RuoloApplicativo ruoloApplicativo;
	private RuoloCampo ruolo;
	private Date dataNascita;
	private String id_squadra;

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

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(String id_squadra) {
		this.id_squadra = id_squadra;
	}

	public RuoloApplicativo getRuoloApplicativo() {
		return ruoloApplicativo;
	}

	public void setRuoloApplicativo(RuoloApplicativo ruoloApplicativo) {
		this.ruoloApplicativo = ruoloApplicativo;
	}

	public RuoloCampo getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloCampo ruolo) {
		this.ruolo = ruolo;
	}
}
