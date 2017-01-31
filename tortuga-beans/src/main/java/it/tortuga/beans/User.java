package it.tortuga.beans;

import java.util.Date;

public class User extends GeneralBean {

	private String nome;
	private String cognome;
	private String _id;
	private String password;
	private String codiceFiscale;
	private RuoloApplicativo ruoloApplicativo;
	private RuoloCampo ruolo;
	private Date dataNacita;
	private Squadra squadraAppartenenza;

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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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

	public Date getDataNacita() {
		return dataNacita;
	}

	public void setDataNacita(Date dataNacita) {
		this.dataNacita = dataNacita;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Squadra getSquadraAppartenenza() {
		return squadraAppartenenza;
	}

	public void setSquadraAppartenenza(Squadra squadraAppartenenza) {
		this.squadraAppartenenza = squadraAppartenenza;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
